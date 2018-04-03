package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.TeacherBo;
import com.education.framework.model.co.TeacherCo;
import com.education.framework.model.po.Teacher;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface TeacherApi {

    /**
     * 保存
     * @param teacher
     * @return
     */
    ApiResponse<Integer> save(Teacher teacher);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<Teacher> list);

    /**
     * 根据id修改
     * @param teacher
     * @return
     */
    ApiResponse<Integer> updateById(Teacher teacher);

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
    ApiResponse<TeacherBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<TeacherBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param teacher
     * @return
     */
    ApiResponse<Integer> countByCondition(Teacher teacher);

    /**
     * 根据条件查询
     * @param teacher
     * @return
     */
    public ApiResponse<List<TeacherBo>> getListByCondition(Teacher teacher);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<TeacherBo>> getPageByCondition(TeacherCo condition,PageParam pageParam);

}
