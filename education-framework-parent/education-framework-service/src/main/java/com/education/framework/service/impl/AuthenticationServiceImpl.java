package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.AuthenticationBo;
import com.education.framework.model.co.AuthenticationCo;
import com.education.framework.model.po.Authentication;
import com.education.framework.repo.AuthenticationRepo;
import com.education.framework.service.AuthenticationApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/4.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationApi{

    @Resource
    private AuthenticationRepo authenticationRepo;

    @Override
    public ApiResponse<Integer> save(AuthenticationBo authenticationBo) {
        if (null==authenticationBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"authentication不能为空!");}
        int result = authenticationRepo.save(authenticationBo);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<Authentication> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = authenticationRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(AuthenticationBo authenticationBo) {
        if (null==authenticationBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"authenticationBo不能为空!");}
        if (null==authenticationBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"authenticationBo.getId()不能为空!");}
        int result = authenticationRepo.updateById(authenticationBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = authenticationRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<AuthenticationBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        AuthenticationBo authenticationBo = authenticationRepo.getById(id);
        return ApiResponse.success(authenticationBo,"查询成功");
    }

    @Override
    public ApiResponse<List<AuthenticationBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<AuthenticationBo> authenticationBoList = authenticationRepo.getListByIds(ids);
        return ApiResponse.success(authenticationBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(Authentication authentication) {
        if (null==authentication){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"authentication不能为空!");}
        int count = authenticationRepo.countByCondition(authentication);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<AuthenticationBo>> getListByCondition(Authentication authentication) {
        if (null==authentication){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"authentication不能为空!");}
        List<AuthenticationBo> result = authenticationRepo.getListByCondition(authentication);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<AuthenticationBo>> getPageByCondition(AuthenticationCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<AuthenticationBo> result = authenticationRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }

}
