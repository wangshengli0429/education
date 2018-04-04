package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.BindAccountBo;
import com.education.framework.model.co.BindAccountCo;
import com.education.framework.model.po.BindAccount;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface BindAccountApi {

    /**
     * 保存
     * @param bindAccountBo
     * @return
     */
    ApiResponse<Integer> save(BindAccountBo bindAccountBo);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<BindAccount> list);

    /**
     * 根据id修改
     * @param bindAccountBo
     * @return
     */
    ApiResponse<Integer> updateById(BindAccountBo bindAccountBo);

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
    ApiResponse<BindAccountBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<BindAccountBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param bindAccount
     * @return
     */
    ApiResponse<Integer> countByCondition(BindAccount bindAccount);

    /**
     * 根据条件查询
     * @param bindAccount
     * @return
     */
    public ApiResponse<List<BindAccountBo>> getListByCondition(BindAccount bindAccount);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<BindAccountBo>> getPageByCondition(BindAccountCo condition, PageParam pageParam);

}
