package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.TradeRecordBo;
import com.education.framework.model.co.TradeRecordCo;
import com.education.framework.model.po.TradeRecord;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface TradeRecordApi {

    /**
     * 保存
     * @param tradeRecord
     * @return
     */
    ApiResponse<Integer> save(TradeRecord tradeRecord);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<TradeRecord> list);

    /**
     * 根据id修改
     * @param tradeRecord
     * @return
     */
    ApiResponse<Integer> updateById(TradeRecord tradeRecord);

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
    ApiResponse<TradeRecordBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<TradeRecordBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param tradeRecord
     * @return
     */
    ApiResponse<Integer> countByCondition(TradeRecord tradeRecord);

    /**
     * 根据条件查询
     * @param tradeRecord
     * @return
     */
    public ApiResponse<List<TradeRecordBo>> getListByCondition(TradeRecord tradeRecord);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<TradeRecordBo>> getPageByCondition(TradeRecordCo condition, PageParam pageParam);

}
