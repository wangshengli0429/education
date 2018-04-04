package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.DictionaryTypeBo;
import com.education.framework.model.co.DictionaryTypeCo;
import com.education.framework.model.po.DictionaryType;
import com.education.framework.repo.DictionaryTypeRepo;
import com.education.framework.service.DictionaryTypeApi;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/4.
 */
public class DictionaryTypeServiceImpl implements DictionaryTypeApi{

    @Resource
    private DictionaryTypeRepo dictionaryTypeRepo;

    @Override
    public ApiResponse<Integer> save(DictionaryTypeBo dictionaryTypeBo) {
        if (null==dictionaryTypeBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"dictionaryType不能为空!");}
        int result = dictionaryTypeRepo.save(dictionaryTypeBo);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<DictionaryType> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = dictionaryTypeRepo.batchSave(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(DictionaryTypeBo dictionaryTypeBo) {
        if (null==dictionaryTypeBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"dictionaryTypeBo不能为空!");}
        if (null==dictionaryTypeBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"dictionaryTypeBo.getId()不能为空!");}
        int result = dictionaryTypeRepo.updateById(dictionaryTypeBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = dictionaryTypeRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<DictionaryTypeBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        DictionaryTypeBo dictionaryTypeBo = dictionaryTypeRepo.getById(id);
        return ApiResponse.success(dictionaryTypeBo,"查询成功");
    }

    @Override
    public ApiResponse<List<DictionaryTypeBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<DictionaryTypeBo> dictionaryTypeBoList = dictionaryTypeRepo.getListByIds(ids);
        return ApiResponse.success(dictionaryTypeBoList,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(DictionaryType dictionaryType) {
        if (null==dictionaryType){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"dictionaryType不能为空!");}
        int count = dictionaryTypeRepo.countByCondition(dictionaryType);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<DictionaryTypeBo>> getListByCondition(DictionaryType dictionaryType) {
        if (null==dictionaryType){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"dictionaryType不能为空!");}
        List<DictionaryTypeBo> result = dictionaryTypeRepo.getListByCondition(dictionaryType);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<DictionaryTypeBo>> getPageByCondition(DictionaryTypeCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<DictionaryTypeBo> result = dictionaryTypeRepo.getPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }

}
