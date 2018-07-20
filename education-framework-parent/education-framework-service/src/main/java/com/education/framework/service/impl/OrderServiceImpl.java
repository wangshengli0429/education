package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.OrderAppointmentBo;
import com.education.framework.model.bo.OrderBo;
import com.education.framework.model.bo.TeacherBo;
import com.education.framework.model.bo.TeacherTimeBo;
import com.education.framework.model.co.OrderCo;
import com.education.framework.model.constant.TeacherTimeEnum;
import com.education.framework.model.po.Order;
import com.education.framework.model.po.OrderAppointment;
import com.education.framework.model.po.Teacher;
import com.education.framework.model.po.TeacherTime;
import com.education.framework.repo.OrderAppointmentRepo;
import com.education.framework.repo.OrderRepo;
import com.education.framework.repo.TeacherRepo;
import com.education.framework.repo.TeacherTimeRepo;
import com.education.framework.service.OrderApi;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhoulin on 2018/4/3.
 */
@Service
public class OrderServiceImpl implements OrderApi{

    @Resource
    private OrderRepo orderRepo;

    @Resource
    private OrderAppointmentRepo orderAppointmentRepo;

    @Resource
    private TeacherTimeRepo teacherTimeRepo;

    @Resource
    private TeacherRepo teacherRepo;

    @Override
    public ApiResponse<Integer> save(OrderBo orderBo) {
        if (null==orderBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"orderBo不能为空!");}
        String orderNuber = UUID.randomUUID().toString().replace("-","").toUpperCase();
        orderBo.setOrderNumber(orderNuber);
        List<TeacherTimeBo> teacherTimeBos = teacherTimeRepo.getListByIds(orderBo.getTeacherTimeIds());
        if (CollectionUtils.isEmpty(teacherTimeBos)){return ApiResponse.fail(ApiRetCode.FETCH_DATA_FAIL,"授课时间不存在");}
        List<TeacherTime> teacherTimes = new ArrayList<TeacherTime>();
        for (TeacherTimeBo teacherTimeBo:teacherTimeBos) {
            if (teacherTimeBo.getTimeStatus().equals(TeacherTimeEnum.timeStatus.no.getValue())) {
                return ApiResponse.fail(ApiRetCode.FETCH_DATA_FAIL,"授课时间已经被预约");
            }
            TeacherTime teacherTime = new TeacherTime();
            teacherTime.setId(teacherTimeBo.getId());
            teacherTime.setTimeStatus(TeacherTimeEnum.timeStatus.no.getValue());
            teacherTimes.add(teacherTime);
        }
        // 保存订单
        int id = orderRepo.saveSelective(orderBo);
        // 设置更新时间已被预约
        teacherTimeRepo.batchUpdateById(teacherTimes);
        List<OrderAppointment> orderAppointments = new ArrayList<>();
        for (Integer timeId:orderBo.getTeacherTimeIds()){
            OrderAppointment orderAppointment = new OrderAppointment();
            orderAppointment.setTeacherTimeId(timeId);
            orderAppointment.setOrderId(id);
            orderAppointments.add(orderAppointment);
        }
        // 设置订单-授课时间关系
        orderAppointmentRepo.batchSave(orderAppointments);
        // 教师表订单数+1
        addOrderCount(orderBo.getTeacherId());
        return ApiResponse.success(id,"保存成功");

    }

    @Override
    public ApiResponse<int[]> batchSave(List<Order> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = orderRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(OrderBo orderBo) {
        if (null==orderBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"orderBo不能为空!");}
        if (null==orderBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"orderBo.getId()不能为空!");}
        int result = orderRepo.updateById(orderBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        OrderBo orderBo = orderRepo.getById(id);
        OrderAppointment orderAppointment = new OrderAppointment();
        orderAppointment.setOrderId(id);
        List<OrderAppointmentBo> OrderAppointmentBos = orderAppointmentRepo.getListByCondition(orderAppointment);
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
        teacherTimeRepo.batchUpdateById(teacherTimes);
        // 删除教师授课时间、订单关系
        orderAppointmentRepo.batchDeleteById(orderAppointmentIds,-1);
        // 删除订单
        Integer result = orderRepo.deleteById(id, -1);
        // 教师表订单数-1
        subOrderCount(orderBo.getTeacherId());
        return ApiResponse.success(result,"删除成功");
    }

    public void addOrderCount(Integer teacherId){
        TeacherBo teacherBo = teacherRepo.getById(teacherId);
        int orderCount = teacherBo.getOrderCount();
        Teacher teacher = new Teacher();
        teacher.setId(teacherId);
        teacher.setOrderCount(orderCount+1);
        teacherRepo.updateById(teacher);
    }

    public void subOrderCount(Integer teacherId){
        TeacherBo teacherBo = teacherRepo.getById(teacherId);
        int orderCount = teacherBo.getOrderCount();
        Teacher teacher = new Teacher();
        teacher.setId(teacherId);
        teacher.setOrderCount(orderCount-1);
        teacherRepo.updateById(teacher);
    }

    @Override
    public ApiResponse<OrderBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        OrderBo orderBo = orderRepo.getById(id);
        return ApiResponse.success(orderBo,"查询成功");
    }

    @Override
    public ApiResponse<List<OrderBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<OrderBo> orderBoList = orderRepo.getListByIds(ids);
        return ApiResponse.success(orderBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(Order order) {
        if (null==order){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"order不能为空!");}
        int count = orderRepo.countByCondition(order);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<OrderBo>> getListByCondition(Order order) {
        if (null==order){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"order不能为空!");}
        List<OrderBo> result = orderRepo.getListByCondition(order);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<OrderBo>> getPageByCondition(OrderCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<OrderBo> result = orderRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }
    
}
