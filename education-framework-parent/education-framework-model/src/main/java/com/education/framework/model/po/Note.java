package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

import java.util.Date;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class Note extends ModelTemplet{

    /**
     * 留言内容
     */
    private String noteContent;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 留言时间
     */
    private Date noteTime;

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getNoteTime() {
        return noteTime;
    }

    public void setNoteTime(Date noteTime) {
        this.noteTime = noteTime;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteContent='" + noteContent + '\'' +
                ", id=" + id +
                ", creatorId=" + creatorId +
                ", userId=" + userId +
                ", noteTime=" + noteTime +
                ", createTime=" + createTime +
                ", updaterId=" + updaterId +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
