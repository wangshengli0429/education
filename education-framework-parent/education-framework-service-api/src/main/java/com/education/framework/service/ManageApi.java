package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.ManageBo;
import com.education.framework.model.co.ManageCo;
import com.education.framework.model.po.Manage;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface ManageApi {

    /**
     * 保存
     * @param manageBo
     * @return
     */
    ApiResponse<Integer> save(ManageBo manageBo);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<Manage> list);

    /**
     * 根据id修改
     * @param manageBo
     * @return
     */
    ApiResponse<Integer> updateById(ManageBo manageBo);

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
    ApiResponse<ManageBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<ManageBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param manage
     * @return
     */
    ApiResponse<Integer> countByCondition(Manage manage);

    /**
     * 根据条件查询
     * @param manage
     * @return
     */
    public ApiResponse<List<ManageBo>> getListByCondition(Manage manage);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<ManageBo>> getPageByCondition(ManageCo condition, PageParam pageParam);

}
