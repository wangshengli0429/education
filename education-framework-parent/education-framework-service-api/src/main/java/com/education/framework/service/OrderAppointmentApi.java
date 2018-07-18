package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.OrderAppointmentBo;
import com.education.framework.model.co.OrderAppointmentCo;
import com.education.framework.model.po.OrderAppointment;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface OrderAppointmentApi {

    /**
     * 保存
     * @param orderAppointmentBo
     * @return
     */
    ApiResponse<Integer> save(OrderAppointmentBo orderAppointmentBo);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<OrderAppointment> list);

    /**
     * 根据id修改
     * @param orderAppointmentBo
     * @return
     */
    ApiResponse<Integer> updateById(OrderAppointmentBo orderAppointmentBo);

    /**
     * 逻辑删除
     * @param id
     * @param operatorId 操作人
     * @return
     */
    ApiResponse<Integer> deleteById(Integer id,Integer operatorId);

    /**
     * 批量删除
     * @param ids
     * @param operatorId
     * @return
     */
    ApiResponse<Integer> batchDeleteById(List<Integer> ids,Integer operatorId);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    ApiResponse<OrderAppointmentBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<OrderAppointmentBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param orderAppointment
     * @return
     */
    ApiResponse<Integer> countByCondition(OrderAppointment orderAppointment);

    /**
     * 根据条件查询
     * @param orderAppointment
     * @return
     */
    public ApiResponse<List<OrderAppointmentBo>> getListByCondition(OrderAppointment orderAppointment);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<OrderAppointmentBo>> getPageByCondition(OrderAppointmentCo condition, PageParam pageParam);

}
