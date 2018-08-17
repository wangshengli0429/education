package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.bo.AttentionBo;
import com.education.framework.model.bo.TeacherBo;
import com.education.framework.model.co.AttentionCo;
import com.education.framework.model.constant.AttentionEnum;
import com.education.framework.model.po.Teacher;
import com.education.framework.repo.AttentionRepo;
import com.education.framework.repo.TeacherRepo;
import com.education.framework.service.AttentionApi;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhoulin
 * @createTime 2018/7/9.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/9.
 * @note
 */
@Service
public class AttentionServiceImpl implements AttentionApi {

    @Resource
    private AttentionRepo attentionRepo;

    @Resource
    private TeacherRepo teacherRepo;

    /**
     * 添加关注
     * @param attentionBo
     * @return
     */
    @Override
    public ApiResponse<Integer> save(AttentionBo attentionBo) {
        if (null==attentionBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"attentionBo不能为空!");}
        if (null==attentionBo.getTeacherId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherId不能为空!");}
        if (null==attentionBo.getStudentId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"studentId不能为空!");}

        AttentionCo attentionCo = new AttentionCo();
        attentionCo.setTeacherId(attentionBo.getTeacherId());
        attentionCo.setStudentId(attentionBo.getStudentId());
        List<AttentionBo> list = attentionRepo.getListByCondition(attentionCo);
        if (CollectionUtils.isNotEmpty(list)){
            return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"您已关注");
        }
        attentionBo.setStatus(AttentionEnum.status.status_true.getValue());
        int id = attentionRepo.saveSelective(attentionBo);
        addAttentionCount(attentionBo.getTeacherId());
        return ApiResponse.success(id);
    }


    /**
     * 取消关注
     * @param attentionBo
     * @return
     */
    @Override
    public ApiResponse<Integer> cancel(AttentionBo attentionBo) {
        if (null==attentionBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"attentionBo不能为空!");}
        if (null==attentionBo.getTeacherId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherId不能为空!");}
        if (null==attentionBo.getStudentId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"studentId不能为空!");}
        AttentionCo attention = new AttentionCo();
        attention.setTeacherId(attentionBo.getTeacherId());
        attention.setStudentId(attentionBo.getStudentId());
        List<AttentionBo> list = attentionRepo.getListByCondition(attention);
        if (CollectionUtils.isNotEmpty(list)){
            for (AttentionBo attentionBo1 : list){
                attentionRepo.deleteById(attentionBo1.getId(),-1);
            }
        }
        subddAttentionCount(attention.getTeacherId());
        return ApiResponse.success(1);
    }

    @Override
    public ApiResponse<List<AttentionBo>> findByCondition(AttentionCo attentionCo) {
        if (null == attentionCo) {
            return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR, "attentionCo不能为空!");
        }
        List<AttentionBo> list = attentionRepo.getListByCondition(attentionCo);
        return ApiResponse.success(list);
    }

    /**
     * 删除关注
     * @param id
     * @param operatorId
     * @return
     */
    @Override
    public ApiResponse<Integer> deleteById(Integer id, Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        AttentionBo attention = attentionRepo.getById(id);
        subddAttentionCount(attention.getTeacherId());
        int row = attentionRepo.deleteById(id,-1);
        return ApiResponse.success(row);
    }

    public void addAttentionCount(Integer teacherId){
        TeacherBo teacherBo = teacherRepo.getById(teacherId);
        int addAttentionCount = teacherBo.getAttentionCount();
        Teacher teacher = new Teacher();
        teacher.setId(teacherId);
        teacher.setAttentionCount(addAttentionCount+1);
        teacherRepo.updateById(teacher);
    }

    public void subddAttentionCount(Integer teacherId){
        TeacherBo teacherBo = teacherRepo.getById(teacherId);
        int addAttentionCount = teacherBo.getAttentionCount();
        if (addAttentionCount>0) {
            Teacher teacher = new Teacher();
            teacher.setId(teacherId);
            teacher.setAttentionCount(addAttentionCount - 1);
            teacherRepo.updateById(teacher);
        }
    }


}
