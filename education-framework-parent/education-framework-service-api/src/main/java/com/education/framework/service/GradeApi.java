package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.GradeBo;
import com.education.framework.model.co.GradeCo;
import com.education.framework.model.po.Grade;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface GradeApi {

    /**
     * 保存
     * @param gradeBo
     * @return
     */
    ApiResponse<Integer> save(GradeBo gradeBo);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<Grade> list);

    /**
     * 根据id修改
     * @param gradeBo
     * @return
     */
    ApiResponse<Integer> updateById(GradeBo gradeBo);

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
    ApiResponse<GradeBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<GradeBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param grade
     * @return
     */
    ApiResponse<Integer> countByCondition(Grade grade);

    /**
     * 根据条件查询
     * @param grade
     * @return
     */
    public ApiResponse<List<GradeBo>> getListByCondition(Grade grade);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<GradeBo>> getPageByCondition(GradeCo condition, PageParam pageParam);

}
