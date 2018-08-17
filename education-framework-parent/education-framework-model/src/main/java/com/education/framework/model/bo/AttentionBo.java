package com.education.framework.model.bo;

import com.education.framework.model.po.Attention;

/**
 * @author zhoulin
 * @createTime 2018/7/9.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/9.
 * @note
 */
public class AttentionBo extends Attention {


    private String teacherName;

    /**
     * 性别：男女
     */
    private String teacherGender;

    /**
     * 年龄
     */
    private Integer teacherAge;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

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
}
