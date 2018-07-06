package com.education.framework.model.vo;

import java.io.Serializable;

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
     * 姓名:周老师
     */
    private String name;

    /**
     * 性别：男女
     */
    private String gender;

//    /**
//     * 年纪
//     */
//    private Integer age;

    /**
     * 授课范围:小学语文、小学数学
     */
    private String subjects;

    /**
     * 授课地区
     */
    private String area;

    /**
     * 评论数
     */
    private Integer commentCount;

    /**
     * 订单数
     */
    private Integer orderCount;

    /**
     * 关注数
     */
    private Integer attentionCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    //    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(Integer attentionCount) {
        this.attentionCount = attentionCount;
    }

}
