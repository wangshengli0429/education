package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

import java.util.Date;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class Teacher extends ModelTemplet {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 姓
     */
    private String surname;

    /**
     * 手机号
     */
    private String telephone;

    /**
     * 名
     */
    private String name;

    /**
     * 性别 1男，2女
     */
    private Integer sex;

    /**
     * 出生日期（年月）
     */
    private Date birthday;

    /**
     * 籍惯
     */
    private String nativePlace;

    /**
     * 所在省份
     */
    private String province;

    /**
     * 所在市
     */
    private String city;

    /**
     * 所在区县
     */
    private String dictrict;

    /**
     * 现在住址
     */
    private String address;


    /**
     * 最高学历
     */
    private String educaion;

    /**
     * 所学专业
     */
    private String major;

    /**
     * 简介
     */
    private String selfDescr;

    /**
     * 头像
     */
    private String photo;

    /**
     * 备注
     */
    private String remark;

    /**
     * 身份认证状态
     */
    private Integer authentication;

    /**
     * 大学
     */
    private String university;

    /**
     * 审核失败反馈
     */
    private String failureReason;

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Integer getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDictrict() {
        return dictrict;
    }

    public void setDictrict(String dictrict) {
        this.dictrict = dictrict;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getEducaion() {
        return educaion;
    }

    public void setEducaion(String educaion) {
        this.educaion = educaion;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSelfDescr() {
        return selfDescr;
    }

    public void setSelfDescr(String selfDescr) {
        this.selfDescr = selfDescr;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "userId=" + userId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", creatorId=" + creatorId +
                ", sex=" + sex +
                ", createTime=" + createTime +
                ", updaterId=" + updaterId +
                ", nativePlace='" + nativePlace + '\'' +
                ", updateTime=" + updateTime +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", deleted=" + deleted +
                ", dictrict='" + dictrict + '\'' +
                ", address='" + address + '\'' +
                ", educaion='" + educaion + '\'' +
                ", major='" + major + '\'' +
                ", selfDescr='" + selfDescr + '\'' +
                ", photo='" + photo + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
