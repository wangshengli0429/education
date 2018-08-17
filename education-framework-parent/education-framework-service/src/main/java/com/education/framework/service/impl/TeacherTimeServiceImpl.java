package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.TeacherTimeBo;
import com.education.framework.model.co.TeacherTimeCo;
import com.education.framework.model.po.TeacherTime;
import com.education.framework.repo.TeacherTimeRepo;
import com.education.framework.service.TeacherTimeApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
@Service
public class TeacherTimeServiceImpl implements TeacherTimeApi{

    @Resource
    private TeacherTimeRepo teacherTimeRepo;

    @Override
    public ApiResponse<Integer> save(TeacherTimeBo teacherTimeBo) {
        if (null==teacherTimeBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherTime不能为空!");}
        int result = teacherTimeRepo.save(teacherTimeBo);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<TeacherTime> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = teacherTimeRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(TeacherTimeBo teacherTimeBo) {
        if (null==teacherTimeBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherTimeBo不能为空!");}
        if (null==teacherTimeBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherTimeBo.getId()不能为空!");}
        int result = teacherTimeRepo.updateById(teacherTimeBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> batchUpdateById(List<TeacherTime> teacherTimeBos) {
        if (null==teacherTimeBos){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherTimeBos不能为空!");}
        int result = teacherTimeRepo.batchUpdateById(teacherTimeBos);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = teacherTimeRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<TeacherTimeBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        TeacherTimeBo teacherTimeBo = teacherTimeRepo.getById(id);
        return ApiResponse.success(teacherTimeBo,"查询成功");
    }

    @Override
    public ApiResponse<List<TeacherTimeBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<TeacherTimeBo> teacherTimeBoList = teacherTimeRepo.getListByIds(ids);
        return ApiResponse.success(teacherTimeBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(TeacherTime teacherTime) {
        if (null==teacherTime){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherTime不能为空!");}
        int count = teacherTimeRepo.countByCondition(teacherTime);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<TeacherTimeBo>> getListByCondition(TeacherTime teacherTime) {
        if (null==teacherTime){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherTime不能为空!");}
        List<TeacherTimeBo> result = teacherTimeRepo.getListByCondition(teacherTime);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<TeacherTimeBo>> getPageByCondition(TeacherTimeCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<TeacherTimeBo> result = teacherTimeRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }

    @Override
    public ApiResponse<List<TeacherTimeBo>> listByTeacherAndDate(Integer teacherId, String dateStr) {
        if (null==teacherId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherId不能为空!");}
        List<TeacherTimeBo> list = teacherTimeRepo.listByTeacherAndDate(teacherId,dateStr);
        return ApiResponse.success(list,"查询成功");
    }

}
