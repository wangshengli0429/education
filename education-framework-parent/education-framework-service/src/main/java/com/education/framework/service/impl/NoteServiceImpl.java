package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.NoteBo;
import com.education.framework.model.co.NoteCo;
import com.education.framework.model.po.Note;
import com.education.framework.repo.NoteRepo;
import com.education.framework.service.NoteApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
@Service
public class NoteServiceImpl implements NoteApi{

    @Resource
    private NoteRepo noteRepo;

    @Override
    public ApiResponse<Integer> save(NoteBo noteBo) {
        if (null==noteBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"noteBo不能为空!");}
        int result = noteRepo.save(noteBo);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<Note> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = noteRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(NoteBo noteBo) {
        if (null==noteBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"noteBo不能为空!");}
        if (null==noteBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"noteBo.getId()不能为空!");}
        int result = noteRepo.updateById(noteBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = noteRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<NoteBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        NoteBo noteBo = noteRepo.getById(id);
        return ApiResponse.success(noteBo,"查询成功");
    }

    @Override
    public ApiResponse<List<NoteBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<NoteBo> noteBoList = noteRepo.getListByIds(ids);
        return ApiResponse.success(noteBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(Note note) {
        if (null==note){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"note不能为空!");}
        int count = noteRepo.countByCondition(note);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<NoteBo>> getListByCondition(Note note) {
        if (null==note){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"note不能为空!");}
        List<NoteBo> result = noteRepo.getListByCondition(note);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<NoteBo>> getPageByCondition(NoteCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<NoteBo> result = noteRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }
    
}
