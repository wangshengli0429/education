package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.BindAccountBo;
import com.education.framework.model.co.BindAccountCo;
import com.education.framework.model.po.BindAccount;
import com.education.framework.repo.BindAccountRepo;
import com.education.framework.service.BindAccountApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/4.
 */
@Service
public class BindAccountServiceImpl implements BindAccountApi{

    @Resource
    private BindAccountRepo bindAccountRepo;

    @Override
    public ApiResponse<Integer> save(BindAccountBo bindAccountBo) {
        if (null==bindAccountBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"bindAccount不能为空!");}
        int result = bindAccountRepo.save(bindAccountBo);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<BindAccount> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = bindAccountRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(BindAccountBo bindAccountBo) {
        if (null==bindAccountBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"bindAccountBo不能为空!");}
        if (null==bindAccountBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"bindAccountBo.getId()不能为空!");}
        int result = bindAccountRepo.updateById(bindAccountBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = bindAccountRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<BindAccountBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        BindAccountBo bindAccountBo = bindAccountRepo.getById(id);
        return ApiResponse.success(bindAccountBo,"查询成功");
    }

    @Override
    public ApiResponse<List<BindAccountBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<BindAccountBo> bindAccountBoList = bindAccountRepo.getListByIds(ids);
        return ApiResponse.success(bindAccountBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(BindAccount bindAccount) {
        if (null==bindAccount){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"bindAccount不能为空!");}
        int count = bindAccountRepo.countByCondition(bindAccount);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<BindAccountBo>> getListByCondition(BindAccount bindAccount) {
        if (null==bindAccount){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"bindAccount不能为空!");}
        List<BindAccountBo> result = bindAccountRepo.getListByCondition(bindAccount);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<BindAccountBo>> getPageByCondition(BindAccountCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<BindAccountBo> result = bindAccountRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }

}
