package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

import java.util.Date;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class TeacherCertificate extends ModelTemplet{

    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 证书类型:1毕业证，2学位证，3资格证，4英语等级证
     */
    private Integer certificateType;

    /**
     * 证书标题
     */
    private String certificateTitle;

    /**
     * 证书图片
     */
    private String certificateImg;

    /**
     * 获取证书日期
     */
    private Date regDate;

    /**
     * 审核不通过反馈描述
     */
    private String descr;

    /**
     * 0待审核，1审核通过，2不通过
     */
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCertificateTitle() {
        return certificateTitle;
    }

    public void setCertificateTitle(String certificateTitle) {
        this.certificateTitle = certificateTitle;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateImg() {
        return certificateImg;
    }

    public void setCertificateImg(String certificateImg) {
        this.certificateImg = certificateImg;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "TeacherCertificate{" +
                "teacherId=" + teacherId +
                ", id=" + id +
                ", certificateType=" + certificateType +
                ", certificateImg='" + certificateImg + '\'' +
                ", creatorId=" + creatorId +
                ", regDate=" + regDate +
                ", descr='" + descr + '\'' +
                ", createTime=" + createTime +
                ", updaterId=" + updaterId +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
