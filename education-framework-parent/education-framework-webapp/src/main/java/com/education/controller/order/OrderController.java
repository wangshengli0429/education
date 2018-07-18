package com.education.controller.order;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.ResultData;
import com.education.framework.model.bo.OrderAppointmentBo;
import com.education.framework.model.bo.OrderBo;
import com.education.framework.model.bo.TeacherTimeBo;
import com.education.framework.model.constant.OrderEnum;
import com.education.framework.model.constant.TeacherTimeEnum;
import com.education.framework.model.po.OrderAppointment;
import com.education.framework.model.po.TeacherTime;
import com.education.framework.service.*;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author zhoulin
 * @createTime 2018/7/5.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/5.
 * @note
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderApi orderApi;

    @Autowired
    private TeacherApi teacherApi;

    @Autowired
    private StudentApi studentApi;

    @Autowired
    private TeacherTimeApi teacherTimeApi;

    @Autowired
    private OrderAppointmentApi orderAppointmentApi;



    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResultData save(OrderBo orderBo){
        if (null==orderBo){return ResultData.failed("orderBo不能为空!");}
        if (CollectionUtils.isEmpty(orderBo.getTeacherTimeIds())){return ResultData.failed("授课时间不能为空!");}
        String orderNuber = UUID.randomUUID().toString().replace("-","").toUpperCase();
        orderBo.setOrderNumber(orderNuber);
        List<TeacherTimeBo> teacherTimeBos = teacherTimeApi.getListByIds(orderBo.getTeacherTimeIds()).getBody();
        if (CollectionUtils.isEmpty(teacherTimeBos)){return ResultData.failed("授课时间不存在");}
        List<TeacherTime> teacherTimes = new ArrayList<TeacherTime>();
        for (TeacherTimeBo teacherTimeBo:teacherTimeBos) {
            if (teacherTimeBo.getTimeStatus().equals(TeacherTimeEnum.timeStatus.no.getValue())) {
                return ResultData.failed("授课时间已经被预约");
            }
            TeacherTime teacherTime = new TeacherTime();
            teacherTime.setId(teacherTimeBo.getId());
            teacherTime.setTimeStatus(TeacherTimeEnum.timeStatus.no.getValue());
            teacherTimes.add(teacherTime);
        }
        // 保存订单
        int id = orderApi.save(orderBo).getBody();
        // 设置更新时间已被预约
        teacherTimeApi.batchUpdateById(teacherTimes);
        List<OrderAppointment> orderAppointments = new ArrayList<>();
        for (Integer timeId:orderBo.getTeacherTimeIds()){
            OrderAppointment orderAppointment = new OrderAppointment();
            orderAppointment.setTeacherTimeId(timeId);
            orderAppointment.setOrderId(id);
            orderAppointments.add(orderAppointment);
        }
        // 设置订单-授课时间关系
        orderAppointmentApi.batchSave(orderAppointments);
        return ResultData.successed(id);
    }

    /**
     * 订单取消
     * @param id
     * @return
     */
    @RequestMapping(value = "/cancel",method = RequestMethod.DELETE)
    public ResultData cancel(Integer id){
        if (null==id){return ResultData.failed("id不能为空!");}
        OrderBo orderBo = orderApi.getById(id).getBody();
        if (null==orderBo){return ResultData.failed("订单不存在");}
        if (!OrderEnum.orderStatus.pay_wait.getValue().equals(orderBo.getOrderStatus())){
            return ResultData.failed("该订单不允许取消");
        }
        OrderAppointment orderAppointment = new OrderAppointment();
        orderAppointment.setOrderId(id);
        List<OrderAppointmentBo> OrderAppointmentBos = orderAppointmentApi.getListByCondition(orderAppointment).getBody();
        List<TeacherTime> teacherTimes = new ArrayList<TeacherTime>();
        List<Integer> orderAppointmentIds = Lists.newArrayList();
        for (OrderAppointmentBo appointmentBo:OrderAppointmentBos) {
            orderAppointmentIds.add(appointmentBo.getId());
            TeacherTime teacherTime = new TeacherTime();
            teacherTime.setId(appointmentBo.getTeacherTimeId());
            teacherTime.setTimeStatus(TeacherTimeEnum.timeStatus.yes.getValue());
            teacherTimes.add(teacherTime);
        }
        // 设置教师时间可用
        teacherTimeApi.batchUpdateById(teacherTimes);
        // 删除教师授课时间、订单关系
        orderAppointmentApi.batchDeleteById(orderAppointmentIds,-1);
        // 删除订单
        ApiResponse<Integer> apiResponse = orderApi.deleteById(id, -1);
        return ResultData.successed(apiResponse.getBody());

    }


    @RequestMapping(value = "/byTeacher",method = RequestMethod.GET)
    public ResultData getByTeacher(OrderBo orderBo){
        List<OrderBo> list = new ArrayList<OrderBo>();
        OrderBo order = new OrderBo();
        order.setId(1);
        order.setOrderNumber("123456");
        order.setPayMode(1);
        order.setPayMoney(100d);
        order.setOrderStatus(1);
        order.setOrderDescr("订单描述");

        return ResultData.successed(1);
    }


}
