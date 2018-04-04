package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.TeacherBo;
import com.education.framework.model.co.TeacherCo;
import com.education.framework.model.po.Teacher;
import com.education.framework.repo.TeacherRepo;
import com.education.framework.service.TeacherApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
@Service
public class TeacherServiceImpl implements TeacherApi{

    @Resource
    private TeacherRepo teacherRepo;

    @Override
    public ApiResponse<Integer> save(TeacherBo teacherBo) {
        if (null==teacherBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacher不能为空!");}
        int result = teacherRepo.save(teacherBo);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<Teacher> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = teacherRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(TeacherBo teacherBo) {
        if (null==teacherBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherBo不能为空!");}
        if (null==teacherBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherBo.getId()不能为空!");}
        int result = teacherRepo.updateById(teacherBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = teacherRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<TeacherBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        TeacherBo teacherBo = teacherRepo.getById(id);
        return ApiResponse.success(teacherBo,"查询成功");
    }

    @Override
    public ApiResponse<List<TeacherBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<TeacherBo> teacherBoList = teacherRepo.getListByIds(ids);
        return ApiResponse.success(teacherBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(Teacher teacher) {
        if (null==teacher){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacher不能为空!");}
        int count = teacherRepo.countByCondition(teacher);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<TeacherBo>> getListByCondition(Teacher teacher) {
        if (null==teacher){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacher不能为空!");}
        List<TeacherBo> result = teacherRepo.getListByCondition(teacher);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<TeacherBo>> getPageByCondition(TeacherCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<TeacherBo> result = teacherRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }
}
