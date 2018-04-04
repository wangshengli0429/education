package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.SubjectBo;
import com.education.framework.model.co.SubjectCo;
import com.education.framework.model.po.Subject;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface SubjectApi {

    /**
     * 保存
     * @param subjectBo
     * @return
     */
    ApiResponse<Integer> save(SubjectBo subjectBo);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<Subject> list);

    /**
     * 根据id修改
     * @param subjectBo
     * @return
     */
    ApiResponse<Integer> updateById(SubjectBo subjectBo);

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
    ApiResponse<SubjectBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<SubjectBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param subject
     * @return
     */
    ApiResponse<Integer> countByCondition(Subject subject);

    /**
     * 根据条件查询
     * @param subject
     * @return
     */
    public ApiResponse<List<SubjectBo>> getListByCondition(Subject subject);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<SubjectBo>> getPageByCondition(SubjectCo condition, PageParam pageParam);

}
