package com.education.framework.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhoulin
 * @createTime 2018/7/6.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/6.
 * @note
 */
public class TeacherVo implements Serializable,Cloneable{

    /**
     * 教师
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 姓
     */
    private String name;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 性别：男女
     */
    private Integer sex;

    /**
     * 性别：男女
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 授课区域
     */
    private String areas;

    /**
     * 最高学历
     */
    private String educaion;

    /**
     * 头像
     */
    private String photo;

    /**
     * 身份认证状态
     */
    private Integer authentication;

    /**
     * 专业
     */
    private String major;

    /**
     * 大学
     */
    private String university;

    /**
     * 授课科目
     */
    private String subjects;

    /**
     * 关注数
     */
    private Integer attentionCount;

    /**
     * 订单数
     */
    private Integer orderCount;

    /**
     * 评论数
     */
    private Integer commentCount;

    /**
     * 评论数
     */
    private Double commentValue;

    public Double getCommentValue() {
        return commentValue;
    }

    public void setCommentValue(Double commentValue) {
        this.commentValue = commentValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public String getEducaion() {
        return educaion;
    }

    public void setEducaion(String educaion) {
        this.educaion = educaion;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public Integer getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(Integer attentionCount) {
        this.attentionCount = attentionCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
}
