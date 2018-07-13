package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class TeacherSubject extends ModelTemplet{

    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 年级code
     */
    private String gradeCode;

    /**
     * 科目code
     */
    private String subjectCode;

    /**
     * 学部code
     */
    private String departmentCode;

    /**
     * 科目名称
     */
    private String subjectName;

    /**
     * 年级名称
     */
    private String gradeName;

    /**
     * 价格
     */
    private Double price;


    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Override
    public String toString() {
        return "TeacherSubject{" +
                "teacherId=" + teacherId +
                ", id=" + id +
                ", gradeCode='" + gradeCode + '\'' +
                ", creatorId=" + creatorId +
                ", subjectCode='" + subjectCode + '\'' +
                ", createTime=" + createTime +
                ", departmentCode='" + departmentCode + '\'' +
                ", updaterId=" + updaterId +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
