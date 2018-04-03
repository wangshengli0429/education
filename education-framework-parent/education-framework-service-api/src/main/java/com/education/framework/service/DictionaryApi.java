package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.DictionaryBo;
import com.education.framework.model.co.DictionaryCo;
import com.education.framework.model.po.Dictionary;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface DictionaryApi {

    /**
     * 保存
     * @param dictionary
     * @return
     */
    ApiResponse<Integer> save(Dictionary dictionary);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<Dictionary> list);

    /**
     * 根据id修改
     * @param dictionary
     * @return
     */
    ApiResponse<Integer> updateById(Dictionary dictionary);

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
    ApiResponse<DictionaryBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<DictionaryBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param dictionary
     * @return
     */
    ApiResponse<Integer> countByCondition(Dictionary dictionary);

    /**
     * 根据条件查询
     * @param dictionary
     * @return
     */
    public ApiResponse<List<DictionaryBo>> getListByCondition(Dictionary dictionary);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<DictionaryBo>> getPageByCondition(DictionaryCo condition, PageParam pageParam);

}
