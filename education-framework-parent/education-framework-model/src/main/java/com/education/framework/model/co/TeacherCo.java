package com.education.framework.model.co;

import com.education.framework.model.po.Teacher;

import java.util.List;
import java.util.Set;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class TeacherCo extends Teacher {

    /**
     * 综合排序
     */
    public static final Integer ZONGHE = 1;

    /**
     * 评论数降序
     */
    public static final Integer COMMENT_DESC = 2;

    /**
     * 订单数降序
     */
    public static final Integer ORDER_DESC = 3;



    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 当前页码数
     */
    private Integer pageNum;

    /**
     * 排序规则
     */
    private Integer sortOrder;

    /**
     * 学部code
     */
    private String departmentCode;

    /**
     * 科目code
     */
    private String subjectCode;

    /**
     * 年级code
     */
    private String gradeCode;

    /**
     * 年级集合
     */
    private Set<String> gradeCodeBos;

    /**
     * 学部集合
     */
    private Set<String> subjectCodeBos;


    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Set<String> getGradeCodeBos() {
        return gradeCodeBos;
    }

    public void setGradeCodeBos(Set<String> gradeCodeBos) {
        this.gradeCodeBos = gradeCodeBos;
    }

    public Set<String> getSubjectCodeBos() {
        return subjectCodeBos;
    }

    public void setSubjectCodeBos(Set<String> subjectCodeBos) {
        this.subjectCodeBos = subjectCodeBos;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

}
