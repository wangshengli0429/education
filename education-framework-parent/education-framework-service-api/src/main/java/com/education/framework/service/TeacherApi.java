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

    ApiResponse<Integer> save(Teacher teacher);

    ApiResponse<int[]> batchSave(List<Teacher> list);

    ApiResponse<Integer> updateById(Teacher teacher);

    ApiResponse<Integer> deleteById(Integer id,Integer operatorId);

    ApiResponse<TeacherBo> getById(Integer id);

    ApiResponse<List<TeacherBo>> getListByIds(List<Integer> ids);

    ApiResponse<Integer> countByCondition(Teacher teacher);

    public ApiResponse<List<TeacherBo>> getListByCondition(Teacher teacher);

    ApiResponse<Page<TeacherBo>> getPageByCondition(TeacherCo condition,PageParam pageParam);

}
