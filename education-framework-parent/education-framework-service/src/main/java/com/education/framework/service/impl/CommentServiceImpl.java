package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.CommentBo;
import com.education.framework.model.bo.TeacherBo;
import com.education.framework.model.co.CommentCo;
import com.education.framework.model.po.Comment;
import com.education.framework.model.po.Teacher;
import com.education.framework.repo.CommentRepo;
import com.education.framework.repo.TeacherRepo;
import com.education.framework.service.CommentApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
@Service
public class CommentServiceImpl implements CommentApi{

    @Resource
    private CommentRepo commentRepo;

    @Resource
    private TeacherRepo teacherRepo;

    @Override
    public ApiResponse<Integer> save(CommentBo commentBo) {
        if (null==commentBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"commentBo不能为空!");}
        if (null==commentBo.getTeacherId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"teacherId不能为空!");}
        int result = commentRepo.save(commentBo);
        addCommentCount(commentBo.getTeacherId());
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<Comment> list) {
//        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
//        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
//        int[] result = commentRepo.batchSave(list);
//        return ApiResponse.success(result,"保存成功");
        return null;
    }

    @Override
    public ApiResponse<Integer> updateById(CommentBo commentBo) {
        if (null==commentBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"commentBo不能为空!");}
        if (null==commentBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"commentBo.getId()不能为空!");}
        int result = commentRepo.updateById(commentBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        CommentBo commentBo = commentRepo.getById(id);
        subCommentCount(commentBo.getTeacherId());
        int result = commentRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<CommentBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        CommentBo commentBo = commentRepo.getById(id);
        return ApiResponse.success(commentBo,"查询成功");
    }

    @Override
    public ApiResponse<List<CommentBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<CommentBo> commentBoList = commentRepo.getListByIds(ids);
        return ApiResponse.success(commentBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(Comment comment) {
        if (null==comment){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"comment不能为空!");}
        int count = commentRepo.countByCondition(comment);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<CommentBo>> getListByCondition(Comment comment) {
        if (null==comment){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"comment不能为空!");}
        List<CommentBo> result = commentRepo.getListByCondition(comment);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<CommentBo>> getPageByCondition(CommentCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<CommentBo> result = commentRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }


    public void addCommentCount(Integer teacherId){
        TeacherBo teacherBo = teacherRepo.getById(teacherId);
        int addCommentCount = teacherBo.getCommentCount();
        Teacher teacher = new Teacher();
        teacher.setId(teacherId);
        teacher.setCommentCount(addCommentCount+1);
        teacherRepo.updateById(teacher);
    }

    public void subCommentCount(Integer teacherId){
        TeacherBo teacherBo = teacherRepo.getById(teacherId);
        int addCommentCount = teacherBo.getCommentCount();
        if (addCommentCount>0) {
            Teacher teacher = new Teacher();
            teacher.setId(teacherId);
            teacher.setCommentCount(addCommentCount - 1);
            teacherRepo.updateById(teacher);
        }
    }

    
}
