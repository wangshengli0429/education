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
     * 证书图片
     */
    private String certificateImg;

    /**
     * 获取证书日期
     */
    private Date regDate;

    /**
     * 描述
     */
    private String descr;

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
