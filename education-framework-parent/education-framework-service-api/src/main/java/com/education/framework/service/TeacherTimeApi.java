package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.TeacherTimeBo;
import com.education.framework.model.co.TeacherTimeCo;
import com.education.framework.model.po.TeacherTime;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface TeacherTimeApi {

    /**
     * 保存
     * @param teacherTimeBo
     * @return
     */
    ApiResponse<Integer> save(TeacherTimeBo teacherTimeBo);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<TeacherTime> list);

    /**
     * 根据id修改
     * @param teacherTimeBo
     * @return
     */
    ApiResponse<Integer> updateById(TeacherTimeBo teacherTimeBo);

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
    ApiResponse<TeacherTimeBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<TeacherTimeBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param teacherTime
     * @return
     */
    ApiResponse<Integer> countByCondition(TeacherTime teacherTime);

    /**
     * 根据条件查询
     * @param teacherTime
     * @return
     */
    public ApiResponse<List<TeacherTimeBo>> getListByCondition(TeacherTime teacherTime);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<TeacherTimeBo>> getPageByCondition(TeacherTimeCo condition, PageParam pageParam);

}
