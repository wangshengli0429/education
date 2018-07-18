package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.OrderAppointmentBo;
import com.education.framework.model.co.OrderAppointmentCo;
import com.education.framework.model.po.OrderAppointment;
import com.education.framework.repo.OrderAppointmentRepo;
import com.education.framework.service.OrderAppointmentApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/4.
 */
@Service
public class OrderAppointmentServiceImpl implements OrderAppointmentApi{

    @Resource
    private OrderAppointmentRepo orderAppointmentRepo;

    @Override
    public ApiResponse<Integer> save(OrderAppointmentBo orderAppointmentBo) {
        if (null==orderAppointmentBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"orderAppointment不能为空!");}
        int result = orderAppointmentRepo.save(orderAppointmentBo);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<OrderAppointment> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = orderAppointmentRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(OrderAppointmentBo orderAppointmentBo) {
        if (null==orderAppointmentBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"orderAppointmentBo不能为空!");}
        if (null==orderAppointmentBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"orderAppointmentBo.getId()不能为空!");}
        int result = orderAppointmentRepo.updateById(orderAppointmentBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = orderAppointmentRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<Integer> batchDeleteById(List<Integer> ids,Integer operatorId) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = orderAppointmentRepo.batchDeleteById(ids,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<OrderAppointmentBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        OrderAppointmentBo orderAppointmentBo = orderAppointmentRepo.getById(id);
        return ApiResponse.success(orderAppointmentBo,"查询成功");
    }

    @Override
    public ApiResponse<List<OrderAppointmentBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<OrderAppointmentBo> orderAppointmentBoList = orderAppointmentRepo.getListByIds(ids);
        return ApiResponse.success(orderAppointmentBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(OrderAppointment orderAppointment) {
        if (null==orderAppointment){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"orderAppointment不能为空!");}
        int count = orderAppointmentRepo.countByCondition(orderAppointment);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<OrderAppointmentBo>> getListByCondition(OrderAppointment orderAppointment) {
        if (null==orderAppointment){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"orderAppointment不能为空!");}
        List<OrderAppointmentBo> result = orderAppointmentRepo.getListByCondition(orderAppointment);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<OrderAppointmentBo>> getPageByCondition(OrderAppointmentCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<OrderAppointmentBo> result = orderAppointmentRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }

}
