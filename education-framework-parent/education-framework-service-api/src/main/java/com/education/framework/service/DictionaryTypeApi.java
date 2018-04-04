package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.DictionaryTypeBo;
import com.education.framework.model.co.DictionaryTypeCo;
import com.education.framework.model.po.DictionaryType;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface DictionaryTypeApi {

    /**
     * 保存
     * @param dictionaryTypeBo
     * @return
     */
    ApiResponse<Integer> save(DictionaryTypeBo dictionaryTypeBo);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<DictionaryType> list);

    /**
     * 根据id修改
     * @param dictionaryTypeBo
     * @return
     */
    ApiResponse<Integer> updateById(DictionaryTypeBo dictionaryTypeBo);

    /**
     * 逻辑删除
     * @param id
     * @param operatorId 操作人
     * @return
     */
    ApiResponse<Integer> deleteById(Integer id,Integer operatorId);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    ApiResponse<DictionaryTypeBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<DictionaryTypeBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param dictionaryType
     * @return
     */
    ApiResponse<Integer> countByCondition(DictionaryType dictionaryType);

    /**
     * 根据条件查询
     * @param dictionaryType
     * @return
     */
    public ApiResponse<List<DictionaryTypeBo>> getListByCondition(DictionaryType dictionaryType);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<DictionaryTypeBo>> getPageByCondition(DictionaryTypeCo condition, PageParam pageParam);

}
