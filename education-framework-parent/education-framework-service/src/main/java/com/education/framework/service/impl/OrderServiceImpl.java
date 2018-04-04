package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.OrderBo;
import com.education.framework.model.co.OrderCo;
import com.education.framework.model.po.Order;
import com.education.framework.repo.OrderRepo;
import com.education.framework.service.OrderApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
@Service
public class OrderServiceImpl implements OrderApi{

    @Resource
    private OrderRepo orderRepo;

    @Override
    public ApiResponse<Integer> save(OrderBo orderBo) {
        if (null==orderBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"orderBo不能为空!");}
        int result = orderRepo.save(orderBo);
        return ApiResponse.success(result,"保存成功");
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
        int result = orderRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
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
