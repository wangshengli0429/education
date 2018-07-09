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
     * 预约状态：0可预约，1已预约
     */
    private Integer timeStatus;

    /**
     * 时间段，1上午8：00-12：00，2下午13：00-21：00
     */
    private Integer period;


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

    public Integer getTimeStatus() {
        return timeStatus;
    }

    public void setTimeStatus(Integer timeStatus) {
        this.timeStatus = timeStatus;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
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
        return "TeacherTime{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", creatorId=" + creatorId +
                ", timeStatus=" + timeStatus +
                ", createTime=" + createTime +
                ", period=" + period +
                ", updaterId=" + updaterId +
                ", beginTime=" + beginTime +
                ", updateTime=" + updateTime +
                ", endTime=" + endTime +
                ", deleted=" + deleted +
                "} " + super.toString();
    }
}
