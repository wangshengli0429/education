package com.education.framework.service.impl;


import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.TradeRecordBo;
import com.education.framework.model.co.TradeRecordCo;
import com.education.framework.model.po.TradeRecord;
import com.education.framework.repo.TradeRecordRepo;
import com.education.framework.service.TradeRecordApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/4.
 */
@Service
public class TradeRecordServiceImpl implements TradeRecordApi {

    @Resource
    private TradeRecordRepo tradeRecordRepo;

    @Override
    public ApiResponse<Integer> save(TradeRecordBo tradeRecordBo) {
        if (null==tradeRecordBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"tradeRecord不能为空!");}
        int result = tradeRecordRepo.save(tradeRecordBo);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<TradeRecord> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = tradeRecordRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(TradeRecordBo tradeRecordBo) {
        if (null==tradeRecordBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"tradeRecordBo不能为空!");}
        if (null==tradeRecordBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"tradeRecordBo.getId()不能为空!");}
        int result = tradeRecordRepo.updateById(tradeRecordBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = tradeRecordRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<TradeRecordBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        TradeRecordBo tradeRecordBo = tradeRecordRepo.getById(id);
        return ApiResponse.success(tradeRecordBo,"查询成功");
    }

    @Override
    public ApiResponse<List<TradeRecordBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<TradeRecordBo> tradeRecordBoList = tradeRecordRepo.getListByIds(ids);
        return ApiResponse.success(tradeRecordBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(TradeRecord tradeRecord) {
        if (null==tradeRecord){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"tradeRecord不能为空!");}
        int count = tradeRecordRepo.countByCondition(tradeRecord);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<TradeRecordBo>> getListByCondition(TradeRecord tradeRecord) {
        if (null==tradeRecord){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"tradeRecord不能为空!");}
        List<TradeRecordBo> result = tradeRecordRepo.getListByCondition(tradeRecord);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<TradeRecordBo>> getPageByCondition(TradeRecordCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<TradeRecordBo> result = tradeRecordRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }
    
}
