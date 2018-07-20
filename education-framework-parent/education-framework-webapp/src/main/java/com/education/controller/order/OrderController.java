package com.education.controller.order;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.ResultData;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.bo.*;
import com.education.framework.model.constant.CommentEnum;
import com.education.framework.model.constant.OrderEnum;
import com.education.framework.model.po.Comment;
import com.education.framework.model.po.OrderAppointment;
import com.education.framework.service.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

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
    private TeacherSubjectApi teacherSubjectApi;

    @Autowired
    private TeacherTimeApi teacherTimeApi;

    @Autowired
    private OrderAppointmentApi orderAppointmentApi;

    @Autowired
    private CommentApi commentApi;



    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResultData save(OrderBo orderBo){
        if (null==orderBo){return ResultData.failed("orderBo不能为空!");}
        if (CollectionUtils.isEmpty(orderBo.getTeacherTimeIds())){return ResultData.failed("授课时间不能为空!");}
        ApiResponse<Integer> apiResponse = orderApi.save(orderBo);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
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
        ApiResponse<Integer> apiResponse = orderApi.deleteById(id,-1);
        if (!OrderEnum.orderStatus.pay_wait.getValue().equals(orderBo.getOrderStatus())){
            return ResultData.failed("该订单不允许取消");
        }
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }


    /**
     * 订单详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/details",method = RequestMethod.GET)
    public ResultData details(Integer id){
        if (null==id){return ResultData.failed("id不能为空!");}
        OrderBo orderBo = orderApi.getById(id).getBody();
        OrderAppointment orderAppointment = new OrderAppointment();
        orderAppointment.setOrderId(orderBo.getId());
        // 查询教订单-授课时间-中间表
        List<OrderAppointmentBo> appointmentList = orderAppointmentApi.getListByCondition(orderAppointment).getBody();
        List<Integer> teacherTimeIds = new ArrayList<Integer>();
        if (CollectionUtils.isNotEmpty(appointmentList)){
            for (OrderAppointment orderAppoint : appointmentList){
                teacherTimeIds.add(orderAppoint.getTeacherTimeId());
            }
        }
        // 查询授课时间
        List<TeacherTimeBo> timeBos = teacherTimeApi.getListByIds(teacherTimeIds).getBody();
        // 查询授课科目
        TeacherSubjectBo subjectBo = teacherSubjectApi.getById(orderBo.getTeacherSubjectId()).getBody();
        orderBo.setTeacherSubjectBo(subjectBo);
        orderBo.setTeacherTimeBos(timeBos);
        if (orderBo.getOrderStatus().equals(OrderEnum.orderStatus.pay_do.getValue())){
            // 已支付,查询，学生，老师的联系方式
            TeacherBo teacherBo = teacherApi.getById(orderBo.getTeacherId()).getBody();
            StudentBo studentBo = studentApi.getById(orderBo.getStudentId()).getBody();
            orderBo.setTeacherName(teacherBo.getSurname()+teacherBo.getName());
            orderBo.setStudentName(studentBo.getSurname()+studentBo.getName());
            orderBo.setTeacherTelephone(teacherBo.getTelephone());
            orderBo.setStudentTelephone(teacherBo.getTelephone());
        }
        if (orderBo.getOrderStatus().equals(OrderEnum.orderStatus.pay_evaluate.getValue())){
            // 已评论，查询评论
            Comment comment = new Comment();
            comment.setOrderId(orderBo.getId());
            comment.setStatus(CommentEnum.status.status_true.getValue());
            List<CommentBo> commentBos = commentApi.getListByCondition(comment).getBody();
            orderBo.setCommentBos(commentBos);
        }
        return ResultData.successed(orderBo);
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
