package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

import java.util.Date;

/**
 * Created by zhoulin on 2018/4/3.
 */
public class TeacherTime extends ModelTemplet{

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
     * 开始授课时间'
     */
    private Date beginTime;

    /**
     * 结束授课时间
     */
    private Date endTime;


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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "TeachTime{" +
                "teacherId=" + teacherId +
                ", id=" + id +
                ", creatorId=" + creatorId +
                ", gradeCode='" + gradeCode + '\'' +
                ", createTime=" + createTime +
                ", subjectCode='" + subjectCode + '\'' +
                ", beginTime=" + beginTime +
                ", updaterId=" + updaterId +
                ", endTime=" + endTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
