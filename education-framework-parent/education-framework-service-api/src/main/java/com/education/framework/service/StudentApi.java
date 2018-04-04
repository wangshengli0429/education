package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.StudentBo;
import com.education.framework.model.co.StudentCo;
import com.education.framework.model.po.Student;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface StudentApi {

    /**
     * 保存
     * @param studentBo
     * @return
     */
    ApiResponse<Integer> save(StudentBo studentBo);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<Student> list);

    /**
     * 根据id修改
     * @param studentBo
     * @return
     */
    ApiResponse<Integer> updateById(StudentBo studentBo);

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
    ApiResponse<StudentBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<StudentBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param student
     * @return
     */
    ApiResponse<Integer> countByCondition(Student student);

    /**
     * 根据条件查询
     * @param student
     * @return
     */
    public ApiResponse<List<StudentBo>> getListByCondition(Student student);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<StudentBo>> getPageByCondition(StudentCo condition, PageParam pageParam);

}
