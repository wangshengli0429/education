package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.common.util.BaseMapper;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.DictionaryBo;
import com.education.framework.model.co.DictionaryCo;
import com.education.framework.model.po.Dictionary;
import com.education.framework.repo.DictionaryRepo;
import com.education.framework.service.DictionaryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/4.
 */
@Service
public class DictionaryServiceImpl implements DictionaryApi{

    @Resource
    private DictionaryRepo dictionaryRepo;

    @Autowired
    private BaseMapper baseMapper;

    @Override
    public ApiResponse<Integer> save(DictionaryBo dictionaryBo) {
        if (null==dictionaryBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"dictionary不能为空!");}
        int result = dictionaryRepo.insertAndGetKey(dictionaryBo);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<int[]> batchSave(List<Dictionary> list) {
        if (null==list){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list不能为空!");}
        if (list.size()<=0){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"list.size()不能<=0!");}
        int[] result = dictionaryRepo.batchInsert(list);
        return ApiResponse.success(result,"保存成功");
    }

    @Override
    public ApiResponse<Integer> updateById(DictionaryBo dictionaryBo) {
        if (null==dictionaryBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"dictionaryBo不能为空!");}
        if (null==dictionaryBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"dictionaryBo.getId()不能为空!");}
        int result = dictionaryRepo.updateById(dictionaryBo);
        return ApiResponse.success(result,"修改成功");
    }

    @Override
    public ApiResponse<Integer> deleteById(Integer id,Integer operatorId) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        if (null==operatorId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"operatorId不能为空!");}
        int result = dictionaryRepo.deleteById(id,operatorId);
        return ApiResponse.success(result,"删除成功");
    }

    @Override
    public ApiResponse<DictionaryBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        DictionaryBo dictionaryBo = dictionaryRepo.getById(id);
        return ApiResponse.success(dictionaryBo,"查询成功");
    }

    @Override
    public ApiResponse<List<DictionaryBo>> getListByIds(List<Integer> ids) {
        if (null==ids){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"ids不能为空!");}
        List<DictionaryBo> dictionaryBoList = dictionaryRepo.listByIds(ids);
        return ApiResponse.success(dictionaryBoList,"查询成功");
    }

    @Override
    public ApiResponse<List<DictionaryBo>> getListByCodes(List<String> codes) {
        if (null==codes){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"codes不能为空!");}
        List<DictionaryBo> list = dictionaryRepo.listByCodes(codes);
        return ApiResponse.success(list,"查询成功");
    }

    @Override
    public ApiResponse<Integer> countByCondition(Dictionary dictionary) {
        if (null==dictionary){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"dictionary不能为空!");}
        // Dictionary 转换 DictionaryCo
        DictionaryCo dictionaryCo = baseMapper.map(dictionary,DictionaryCo.class);
        int count = dictionaryRepo.countByCondition(dictionaryCo);
        return ApiResponse.success(count,"查询成功");
    }

    @Override
    public ApiResponse<List<DictionaryBo>> getListByCondition(Dictionary dictionary) {
        if (null==dictionary){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"dictionary不能为空!");}
        // Dictionary 转换 DictionaryCo
        DictionaryCo dictionaryCo = baseMapper.map(dictionary,DictionaryCo.class);
        List<DictionaryBo> result = dictionaryRepo.listByCondition(dictionaryCo);
        return ApiResponse.success(result,"查询成功");
    }


    @Override
    public ApiResponse<Page<DictionaryBo>> getPageByCondition(DictionaryCo condition, PageParam pageParam) {
        if (null==condition){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"condition不能为空!");}
        Page<DictionaryBo> result = findPageByCondition(condition,pageParam);
        return ApiResponse.success(result,"查询成功");
    }

    /**
     *  分页查询
     * @param dictionaryCo
     * @param pageParam
     * @return
     */
    public Page<DictionaryBo> findPageByCondition(DictionaryCo dictionaryCo, PageParam pageParam) {
        List<DictionaryBo> list = dictionaryRepo.listByCondition(dictionaryCo);
        //封装返回值
        Page<DictionaryBo> resultData = new Page<DictionaryBo>();
        resultData.setList(list); //数据
        if (null!=pageParam && null!=pageParam.getPageNum() && null!=pageParam.getPageSize()) {
            int count = dictionaryRepo.countByCondition(dictionaryCo);
            resultData.setPageSize(pageParam.getPageSize()); //每页数据量
            int pageCount = (count + pageParam.getPageSize() - 1) / pageParam.getPageSize(); // 总页数
            resultData.setPageTotal(pageCount); //总页数
            int pageNum = pageParam.getPageNum(); // 页码
            if (pageNum > pageCount) {
                pageNum = pageParam.getPageNum() - 1; // 页码
            }
            resultData.setItemTotal(count); //总记录数
            resultData.setPageNum(pageNum); //页码
        }
        return resultData;
    }

}
