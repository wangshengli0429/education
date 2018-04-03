package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.TeacherSubjectBo;
import com.education.framework.model.co.TeacherSubjectCo;
import com.education.framework.model.po.TeacherSubject;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface TeacherSubjectApi {

    /**
     * 保存
     * @param teacherSubject
     * @return
     */
    ApiResponse<Integer> save(TeacherSubject teacherSubject);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<TeacherSubject> list);

    /**
     * 根据id修改
     * @param teacherSubject
     * @return
     */
    ApiResponse<Integer> updateById(TeacherSubject teacherSubject);

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
    ApiResponse<TeacherSubjectBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<TeacherSubjectBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param teacherSubject
     * @return
     */
    ApiResponse<Integer> countByCondition(TeacherSubject teacherSubject);

    /**
     * 根据条件查询
     * @param teacherSubject
     * @return
     */
    public ApiResponse<List<TeacherSubjectBo>> getListByCondition(TeacherSubject teacherSubject);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<TeacherSubjectBo>> getPageByCondition(TeacherSubjectCo condition, PageParam pageParam);

}
