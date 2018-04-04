package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.UserBo;
import com.education.framework.model.co.UserCo;
import com.education.framework.model.po.User;
import com.education.framework.repo.UserRepo;
import com.education.framework.service.UserApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
@Service
public class UserServiceImpl implements UserApi{

    @Resource
    private UserRepo userRepo;

    @Override
    public ApiResponse<Integer> save(UserBo userBo) {
        if (null==userBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"user不能为空!");}
        int result = userRepo.save(userBo);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<User> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = userRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(UserBo userBo) {
        if (null==userBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"userBo不能为空!");}
        if (null==userBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"userBo.getId()不能为空!");}
        int result = userRepo.updateById(userBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = userRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<UserBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        UserBo userBo = userRepo.getById(id);
        return ApiResponse.success(userBo,"查询成功");
    }

    @Override
    public ApiResponse<List<UserBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<UserBo> userBoList = userRepo.getListByIds(ids);
        return ApiResponse.success(userBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(User user) {
        if (null==user){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"user不能为空!");}
        int count = userRepo.countByCondition(user);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<UserBo>> getListByCondition(User user) {
        if (null==user){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"user不能为空!");}
        List<UserBo> result = userRepo.getListByCondition(user);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<UserBo>> getPageByCondition(UserCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<UserBo> result = userRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }
}
