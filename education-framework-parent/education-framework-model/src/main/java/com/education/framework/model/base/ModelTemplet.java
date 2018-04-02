package com.education.framework.model.base;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhoulin on 2018/4/2.
 */
public abstract class ModelTemplet implements Serializable,Cloneable{

    /**
     * id
     */
    protected  Integer id;

    /**
     * 创建人
     */
    protected  Integer creatorId;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 修改人id
     */
    protected  Integer updaterId;

    /**
     * 修改时间
     */
    protected Date updateTime;

    /**
     * 删除状态,1删除，0未删除
     */
    protected  Integer deleted;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "ModelTemplet{" +
                "id=" + id +
                ", creatorId=" + creatorId +
                ", createTime=" + createTime +
                ", updaterId=" + updaterId +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
