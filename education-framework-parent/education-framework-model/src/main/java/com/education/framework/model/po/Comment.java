package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

import java.util.Date;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class Comment extends ModelTemplet{

    /**
     * 教师D(被评论人)
     */
    private Integer teacherId;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 评星
     */
    private Integer commentValue;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论用户ID
     */
    private Integer studentId;

    /**
     * 状态 1有用，0无用
     */
    private Integer status;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCommentValue() {
        return commentValue;
    }

    public void setCommentValue(Integer commentValue) {
        this.commentValue = commentValue;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", creatorId=" + creatorId +
                ", commentContent='" + commentContent + '\'' +
                ", createTime=" + createTime +
                ", studentId=" + studentId +
                ", updaterId=" + updaterId +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", deleted=" + deleted +
                '}';
    }
}
