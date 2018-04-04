package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.GradeBo;
import com.education.framework.model.co.GradeCo;
import com.education.framework.model.po.Grade;
import com.education.framework.repo.GradeRepo;
import com.education.framework.service.GradeApi;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/4.
 */
public class GradeServiceImpl implements GradeApi{

    @Resource
    private GradeRepo gradeRepo;

    @Override
    public ApiResponse<Integer> save(GradeBo gradeBo) {
        if (null==gradeBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"grade不能为空!");}
        int result = gradeRepo.save(gradeBo);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<Grade> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = gradeRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(GradeBo gradeBo) {
        if (null==gradeBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"gradeBo不能为空!");}
        if (null==gradeBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"gradeBo.getId()不能为空!");}
        int result = gradeRepo.updateById(gradeBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = gradeRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<GradeBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        GradeBo gradeBo = gradeRepo.getById(id);
        return ApiResponse.success(gradeBo,"查询成功");
    }

    @Override
    public ApiResponse<List<GradeBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<GradeBo> gradeBoList = gradeRepo.getListByIds(ids);
        return ApiResponse.success(gradeBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(Grade grade) {
        if (null==grade){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"grade不能为空!");}
        int count = gradeRepo.countByCondition(grade);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<GradeBo>> getListByCondition(Grade grade) {
        if (null==grade){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"grade不能为空!");}
        List<GradeBo> result = gradeRepo.getListByCondition(grade);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<GradeBo>> getPageByCondition(GradeCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<GradeBo> result = gradeRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }

}
