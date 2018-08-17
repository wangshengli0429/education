package com.education.framework.model.bo;

import com.education.framework.model.po.Teacher;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class TeacherBo extends Teacher {

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 教师证书
     */
    private List<TeacherCertificateBo> teacherCertificateBos;

    /**
     * 教授科目
     */
    private List<TeacherSubjectBo> teacherSubjectBos;

    /**
     * 授课区域
     */
    private String areas;

    /**
     *  关注状态，1关注，0未关注
     */
    private Integer attentionStatus;


    private Integer studentId;

    public Integer getAttentionStatus() {
        return attentionStatus;
    }

    public void setAttentionStatus(Integer attentionStatus) {
        this.attentionStatus = attentionStatus;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public List<TeacherSubjectBo> getTeacherSubjectBos() {
        return teacherSubjectBos;
    }

    public void setTeacherSubjectBos(List<TeacherSubjectBo> teacherSubjectBos) {
        this.teacherSubjectBos = teacherSubjectBos;
    }

    public List<TeacherCertificateBo> getTeacherCertificateBos() {
        return teacherCertificateBos;
    }

    public void setTeacherCertificateBos(List<TeacherCertificateBo> teacherCertificateBos) {
        this.teacherCertificateBos = teacherCertificateBos;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
