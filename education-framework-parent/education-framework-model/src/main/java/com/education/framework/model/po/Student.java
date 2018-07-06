package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

import java.util.Date;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class Student extends ModelTemplet {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 名
     */
    private String name;

    /**
     * 姓
     */
    private String surname;

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
     * 身份证号
     */
    private String idNumber;

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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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
        return "Student{" +
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
                ", idNumber='" + idNumber + '\'' +
                ", selfDescr='" + selfDescr + '\'' +
                ", photo='" + photo + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
