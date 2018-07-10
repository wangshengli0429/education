package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.TeacherCertificateBo;
import com.education.framework.model.co.TeacherCertificateCo;
import com.education.framework.model.constant.TeacherCertificateEnum;
import com.education.framework.model.po.TeacherCertificate;
import com.education.framework.repo.TeacherCertificateRepo;
import com.education.framework.service.TeacherCertificateApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
@Service
public class TeacherCertificateServiceImpl implements TeacherCertificateApi{

    @Resource
    private TeacherCertificateRepo teacherCertificateRepo;

    @Override
    public ApiResponse<Integer> save(TeacherCertificateBo teacherCertificateBo) {
        if (null==teacherCertificateBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherCertificateBo不能为空!");}
        int result = teacherCertificateRepo.save(teacherCertificateBo);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<TeacherCertificate> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = teacherCertificateRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(TeacherCertificateBo teacherCertificateBo) {
        if (null==teacherCertificateBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherCertificateBo不能为空!");}
        if (null==teacherCertificateBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        TeacherCertificateBo certificateBo = teacherCertificateRepo.getById(teacherCertificateBo.getId());
        if (null==certificateBo){
            return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"数据不存在");
        }
        if (certificateBo.getStatus().equals(TeacherCertificateEnum.status.check_pass.getValue())){
            return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"审核已通过，不允许修改");
        }
        int result = teacherCertificateRepo.updateById(teacherCertificateBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = teacherCertificateRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<TeacherCertificateBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        TeacherCertificateBo teacherCertificateBo = teacherCertificateRepo.getById(id);
        return ApiResponse.success(teacherCertificateBo,"查询成功");
    }

    @Override
    public ApiResponse<List<TeacherCertificateBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<TeacherCertificateBo> teacherCertificateBoList = teacherCertificateRepo.getListByIds(ids);
        return ApiResponse.success(teacherCertificateBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(TeacherCertificate teacherCertificate) {
        if (null==teacherCertificate){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherCertificate不能为空!");}
        int count = teacherCertificateRepo.countByCondition(teacherCertificate);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<TeacherCertificateBo>> getListByCondition(TeacherCertificate teacherCertificate) {
        if (null==teacherCertificate){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherCertificate不能为空!");}
        List<TeacherCertificateBo> result = teacherCertificateRepo.getListByCondition(teacherCertificate);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<TeacherCertificateBo>> getPageByCondition(TeacherCertificateCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<TeacherCertificateBo> result = teacherCertificateRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }
    
}
