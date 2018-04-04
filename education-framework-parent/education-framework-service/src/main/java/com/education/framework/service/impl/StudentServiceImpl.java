package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.StudentBo;
import com.education.framework.model.co.StudentCo;
import com.education.framework.model.po.Student;
import com.education.framework.repo.StudentRepo;
import com.education.framework.service.StudentApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
@Service
public class StudentServiceImpl implements StudentApi{

    @Resource
    private StudentRepo studentRepo;

    @Override
    public ApiResponse<Integer> save(StudentBo studentBo) {
        if (null==studentBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"studentBo不能为空!");}
        int result = studentRepo.save(studentBo);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<Student> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = studentRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(StudentBo studentBo) {
        if (null==studentBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"studentBo不能为空!");}
        if (null==studentBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"studentBo.getId()不能为空!");}
        int result = studentRepo.updateById(studentBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = studentRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<StudentBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        StudentBo studentBo = studentRepo.getById(id);
        return ApiResponse.success(studentBo,"查询成功");
    }

    @Override
    public ApiResponse<List<StudentBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<StudentBo> studentBoList = studentRepo.getListByIds(ids);
        return ApiResponse.success(studentBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(Student student) {
        if (null==student){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"student不能为空!");}
        int count = studentRepo.countByCondition(student);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<StudentBo>> getListByCondition(Student student) {
        if (null==student){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"student不能为空!");}
        List<StudentBo> result = studentRepo.getListByCondition(student);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<StudentBo>> getPageByCondition(StudentCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<StudentBo> result = studentRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }
    
}
