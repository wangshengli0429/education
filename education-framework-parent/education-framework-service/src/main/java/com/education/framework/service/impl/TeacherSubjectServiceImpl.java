package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.TeacherSubjectBo;
import com.education.framework.model.co.TeacherSubjectCo;
import com.education.framework.model.po.TeacherSubject;
import com.education.framework.repo.TeacherSubjectRepo;
import com.education.framework.service.TeacherSubjectApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
@Service
public class TeacherSubjectServiceImpl implements TeacherSubjectApi{

    @Resource
    private TeacherSubjectRepo teacherSubjectRepo;

    @Override
    public ApiResponse<Integer> save(TeacherSubject teacherSubject) {
        if (null==teacherSubject){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherSubject不能为空!");}
        int result = teacherSubjectRepo.save(teacherSubject);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<TeacherSubject> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = teacherSubjectRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(TeacherSubject teacherSubject) {
        if (null==teacherSubject){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherSubject不能为空!");}
        if (null==teacherSubject.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherSubject.getId()不能为空!");}
        int result = teacherSubjectRepo.updateById(teacherSubject);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = teacherSubjectRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<TeacherSubjectBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        TeacherSubjectBo teacherSubjectBo = teacherSubjectRepo.getById(id);
        return ApiResponse.success(teacherSubjectBo,"查询成功");
    }

    @Override
    public ApiResponse<List<TeacherSubjectBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<TeacherSubjectBo> teacherSubjectBoList = teacherSubjectRepo.getListByIds(ids);
        return ApiResponse.success(teacherSubjectBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(TeacherSubject teacherSubject) {
        if (null==teacherSubject){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherSubject不能为空!");}
        int count = teacherSubjectRepo.countByCondition(teacherSubject);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<TeacherSubjectBo>> getListByCondition(TeacherSubject teacherSubject) {
        if (null==teacherSubject){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherSubject不能为空!");}
        List<TeacherSubjectBo> result = teacherSubjectRepo.getListByCondition(teacherSubject);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<TeacherSubjectBo>> getPageByCondition(TeacherSubjectCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<TeacherSubjectBo> result = teacherSubjectRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }

}
