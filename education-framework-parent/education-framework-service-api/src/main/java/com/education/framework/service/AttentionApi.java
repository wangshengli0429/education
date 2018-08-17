package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.bo.AttentionBo;
import com.education.framework.model.co.AttentionCo;

import java.util.List;

/**
 * @author zhoulin
 * @createTime 2018/7/9.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/9.
 * @note
 */
public interface AttentionApi {

    /**
     * 保存
     * @param attentionBo
     * @return
     */
    ApiResponse<Integer> save(AttentionBo attentionBo);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    ApiResponse<Integer> deleteById(Integer id,Integer operatorId);

    /**
     * 取消关注
     * @param attentionBo
     * @return
     */
    ApiResponse<Integer> cancel(AttentionBo attentionBo);

    /**
     * 根据条件查询
     * @param attentionCo
     * @return
     */
    ApiResponse<List<AttentionBo>> findByCondition(AttentionCo attentionCo);

}
