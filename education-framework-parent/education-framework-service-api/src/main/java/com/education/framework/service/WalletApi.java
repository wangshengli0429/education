package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.WalletBo;
import com.education.framework.model.co.WalletCo;
import com.education.framework.model.po.Wallet;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface WalletApi {

    /**
     * 保存
     * @param wallet
     * @return
     */
    ApiResponse<Integer> save(Wallet wallet);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<Wallet> list);

    /**
     * 根据id修改
     * @param wallet
     * @return
     */
    ApiResponse<Integer> updateById(Wallet wallet);

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
    ApiResponse<WalletBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<WalletBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param wallet
     * @return
     */
    ApiResponse<Integer> countByCondition(Wallet wallet);

    /**
     * 根据条件查询
     * @param wallet
     * @return
     */
    public ApiResponse<List<WalletBo>> getListByCondition(Wallet wallet);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<WalletBo>> getPageByCondition(WalletCo condition, PageParam pageParam);

}
