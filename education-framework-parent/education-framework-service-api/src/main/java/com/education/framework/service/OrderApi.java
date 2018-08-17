package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.OrderBo;
import com.education.framework.model.co.OrderCo;
import com.education.framework.model.po.Orders;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface OrderApi {

    /**
     * 保存
     * @param orderBo
     * @return
     */
    ApiResponse<Integer> save(OrderBo orderBo);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<Orders> list);

    /**
     * 根据id修改
     * @param orderBo
     * @return
     */
    ApiResponse<Integer> updateById(OrderBo orderBo);

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
    ApiResponse<OrderBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<OrderBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param order
     * @return
     */
    ApiResponse<Integer> countByCondition(Orders order);

    /**
     * 根据条件查询
     * @param order
     * @return
     */
    public ApiResponse<List<OrderBo>> getListByCondition(Orders order);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<OrderBo>> getPageByCondition(OrderCo condition, PageParam pageParam);

}
