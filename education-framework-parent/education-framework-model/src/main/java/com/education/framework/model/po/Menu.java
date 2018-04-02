package com.education.framework.model.po;

import com.education.framework.model.base.ModelTemplet;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class Menu extends ModelTemplet{

    /**
     * 编码
     */
    private String code;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * URL
     */
    private String menuUrl;

    /**
     * 打开方式  _blank,_self,framename
     */
    private String target;

    /**
     * 显示顺序
     */
    private Integer idx;

    /**
     * 备注
     */
    private String remar;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getRemar() {
        return remar;
    }

    public void setRemar(String remar) {
        this.remar = remar;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "code='" + code + '\'' +
                ", id=" + id +
                ", parentId=" + parentId +
                ", creatorId=" + creatorId +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", menuUrl='" + menuUrl + '\'' +
                ", updaterId=" + updaterId +
                ", target='" + target + '\'' +
                ", updateTime=" + updateTime +
                ", idx=" + idx +
                ", deleted=" + deleted +
                ", remar='" + remar + '\'' +
                '}';
    }
}
