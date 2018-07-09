package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

/**
 * @author zhoulin
 * @createTime 2018/7/9.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/9.
 * @note 关注
 */
public class Attention extends ModelTemplet {

    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 0,禁用，1启用
     */
    private Integer status;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
