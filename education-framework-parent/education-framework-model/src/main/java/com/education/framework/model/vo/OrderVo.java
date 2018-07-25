package com.education.framework.model.vo;

import java.io.Serializable;

/**
 * @author zhoulin
 * @createTime 2018/7/24.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/24.
 * @note
 */
public class OrderVo implements Serializable {

    private Integer id;
    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 评星
     */
    private Double commentValue;

    /**
     * 评论内容
     */
    private String commentContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getCommentValue() {
        return commentValue;
    }

    public void setCommentValue(Double commentValue) {
        this.commentValue = commentValue;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
