package com.education.framework.model.bo;

import com.education.framework.model.po.Orders;

import java.util.List;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class OrderBo extends Orders {

    private TeacherBo teacherBo;

    private StudentBo studentBo;

    /**
     * 教师号码
     */
    private String teacherTelephone;

    private String teacherName;

    /**
     * 性别：男女
     */
    private String teacherGender;

    /**
     * 年龄
     */
    private Integer teacherAge;

    /**
     * 学生号码
     */
    private String studentTelephone;

    private String studentName;
    /**
     * 性别：男女
     */
    private String studentGender;

    /**
     * 年龄
     */
    private Integer studentAge;

    private List<Integer> teacherTimeIds;

    /**
     * 授课科目
     */
    private TeacherSubjectBo teacherSubjectBo;

    /**
     * 授课时间
     */
    private List<TeacherTimeBo> teacherTimeBos;

    private List<CommentBo> commentBos;

    public String getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public List<CommentBo> getCommentBos() {
        return commentBos;
    }

    public void setCommentBos(List<CommentBo> commentBos) {
        this.commentBos = commentBos;
    }

    public List<TeacherTimeBo> getTeacherTimeBos() {
        return teacherTimeBos;
    }

    public void setTeacherTimeBos(List<TeacherTimeBo> teacherTimeBos) {
        this.teacherTimeBos = teacherTimeBos;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTeacherTelephone() {
        return teacherTelephone;
    }

    public void setTeacherTelephone(String teacherTelephone) {
        this.teacherTelephone = teacherTelephone;
    }

    public String getStudentTelephone() {
        return studentTelephone;
    }

    public void setStudentTelephone(String studentTelephone) {
        this.studentTelephone = studentTelephone;
    }

    public TeacherSubjectBo getTeacherSubjectBo() {
        return teacherSubjectBo;
    }

    public void setTeacherSubjectBo(TeacherSubjectBo teacherSubjectBo) {
        this.teacherSubjectBo = teacherSubjectBo;
    }

    public List<Integer> getTeacherTimeIds() {
        return teacherTimeIds;
    }

    public void setTeacherTimeIds(List<Integer> teacherTimeIds) {
        this.teacherTimeIds = teacherTimeIds;
    }

    public TeacherBo getTeacherBo() {
        return teacherBo;
    }

    public void setTeacherBo(TeacherBo teacherBo) {
        this.teacherBo = teacherBo;
    }

    public StudentBo getStudentBo() {
        return studentBo;
    }

    public void setStudentBo(StudentBo studentBo) {
        this.studentBo = studentBo;
    }

}
