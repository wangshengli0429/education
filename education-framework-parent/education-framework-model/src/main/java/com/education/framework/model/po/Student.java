package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class Student extends ModelTemplet {

    /**
     * 用户id
     */
    private Integer user_id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别 1男，2女
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

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


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
                "user_id=" + user_id +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", creatorId=" + creatorId +
                ", sex=" + sex +
                ", createTime=" + createTime +
                ", age=" + age +
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