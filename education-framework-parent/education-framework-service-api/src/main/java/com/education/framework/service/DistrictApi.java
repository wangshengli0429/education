package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.po.District;

import java.util.List;

/**
 * @author zhoulin
 * @createTime 2018/7/12.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/12.
 * @note
 */
public interface DistrictApi {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    ApiResponse<District> getById(Integer id);

    /**
     * 根据条件查询
     * @param district
     * @return
     */
    public ApiResponse<List<District>> getListByCondition(District district);

    /**
     * 根据id修改
     * @param district
     * @return
     */
    ApiResponse<Integer> updateById(District district);



}
