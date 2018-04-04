package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.ManageBo;
import com.education.framework.model.co.ManageCo;
import com.education.framework.model.po.Manage;
import com.education.framework.repo.ManageRepo;
import com.education.framework.service.ManageApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/4.
 */
@Service
public class ManageServiceImpl implements ManageApi{

    @Resource
    private ManageRepo manageRepo;

    @Override
    public ApiResponse<Integer> save(ManageBo manageBo) {
        if (null==manageBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"manage不能为空!");}
        int result = manageRepo.save(manageBo);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<Manage> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = manageRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(ManageBo manageBo) {
        if (null==manageBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"manageBo不能为空!");}
        if (null==manageBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"manageBo.getId()不能为空!");}
        int result = manageRepo.updateById(manageBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = manageRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<ManageBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        ManageBo manageBo = manageRepo.getById(id);
        return ApiResponse.success(manageBo,"查询成功");
    }

    @Override
    public ApiResponse<List<ManageBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<ManageBo> manageBoList = manageRepo.getListByIds(ids);
        return ApiResponse.success(manageBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(Manage manage) {
        if (null==manage){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"manage不能为空!");}
        int count = manageRepo.countByCondition(manage);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<ManageBo>> getListByCondition(Manage manage) {
        if (null==manage){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"manage不能为空!");}
        List<ManageBo> result = manageRepo.getListByCondition(manage);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<ManageBo>> getPageByCondition(ManageCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<ManageBo> result = manageRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }

}
