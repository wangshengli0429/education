package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.SubjectBo;
import com.education.framework.model.co.SubjectCo;
import com.education.framework.model.po.Subject;
import com.education.framework.repo.SubjectRepo;
import com.education.framework.service.SubjectApi;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/4.
 */
public class SubjectServiceImpl implements SubjectApi{

    @Resource
    private SubjectRepo subjectRepo;

    @Override
    public ApiResponse<Integer> save(SubjectBo subjectBo) {
        if (null==subjectBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"subject不能为空!");}
        int result = subjectRepo.save(subjectBo);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<Subject> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = subjectRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(SubjectBo subjectBo) {
        if (null==subjectBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"subjectBo不能为空!");}
        if (null==subjectBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"subjectBo.getId()不能为空!");}
        int result = subjectRepo.updateById(subjectBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = subjectRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<SubjectBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        SubjectBo subjectBo = subjectRepo.getById(id);
        return ApiResponse.success(subjectBo,"查询成功");
    }

    @Override
    public ApiResponse<List<SubjectBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<SubjectBo> subjectBoList = subjectRepo.getListByIds(ids);
        return ApiResponse.success(subjectBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(Subject subject) {
        if (null==subject){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"subject不能为空!");}
        int count = subjectRepo.countByCondition(subject);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<SubjectBo>> getListByCondition(Subject subject) {
        if (null==subject){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"subject不能为空!");}
        List<SubjectBo> result = subjectRepo.getListByCondition(subject);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<SubjectBo>> getPageByCondition(SubjectCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<SubjectBo> result = subjectRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }
    
}
