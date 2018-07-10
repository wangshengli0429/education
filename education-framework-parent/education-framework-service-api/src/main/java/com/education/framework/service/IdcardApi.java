package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.bo.IdcardBo;

/**
 * @author zhoulin
 * @createTime 2018/7/10.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/10.
 * @note
 */
public interface IdcardApi {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    ApiResponse<IdcardBo> getById(Integer id);

    /**
     * 根据id查询
     * @param userId
     * @return
     */
    ApiResponse<IdcardBo> getByUserId(Integer userId);

    /**
     * 根据id查询数量
     * @param userId
     * @return
     */
    ApiResponse<Integer> countByUserId(Integer userId);

    /**
     * 保存
     * @param idcardBo
     * @return
     */
    ApiResponse<Integer> save(IdcardBo idcardBo);

    /**
     * 根据id修改
     * @param idcardBo
     * @return
     */
    ApiResponse<Integer> updateById(IdcardBo idcardBo);

}
