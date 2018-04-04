package com.education.framework.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.TeacherCertificateBo;
import com.education.framework.model.co.TeacherCertificateCo;
import com.education.framework.model.po.TeacherCertificate;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/3.
 */
public interface TeacherCertificateApi {

    /**
     * 保存
     * @param teacherCertificateBo
     * @return
     */
    ApiResponse<Integer> save(TeacherCertificateBo teacherCertificateBo);

    /**
     * 批量保存
     * @param list
     * @return
     */
    ApiResponse<int[]> batchSave(List<TeacherCertificate> list);

    /**
     * 根据id修改
     * @param teacherCertificateBo
     * @return
     */
    ApiResponse<Integer> updateById(TeacherCertificateBo teacherCertificateBo);

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
    ApiResponse<TeacherCertificateBo> getById(Integer id);

    /**
     * 根据 id集合查询
     * @param ids
     * @return
     */
    ApiResponse<List<TeacherCertificateBo>> getListByIds(List<Integer> ids);

    /**
     * 根据条件统计总数
     * @param teacherCertificate
     * @return
     */
    ApiResponse<Integer> countByCondition(TeacherCertificate teacherCertificate);

    /**
     * 根据条件查询
     * @param teacherCertificate
     * @return
     */
    public ApiResponse<List<TeacherCertificateBo>> getListByCondition(TeacherCertificate teacherCertificate);

    /**
     * 分页查询
     * @param condition
     * @param pageParam
     * @return
     */
    ApiResponse<Page<TeacherCertificateBo>> getPageByCondition(TeacherCertificateCo condition, PageParam pageParam);

}
