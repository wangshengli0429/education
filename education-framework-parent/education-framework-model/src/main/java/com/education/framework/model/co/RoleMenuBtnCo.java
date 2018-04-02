package com.education.framework.model.co;

import com.education.framework.model.po.RoleMenuBtn;

/**
 * Created by zhoulin on 2018/4/2.
 */
public class RoleMenuBtnCo extends RoleMenuBtn {

    private static final Integer ORDER_BY_ID_ASC = 1; // 排序规则：order by id asc

    private static final Integer ORDER_BY_ID_DESC = 2; // 排序规则：order by id desc

    private static final Integer ORDER_BY_UPDATE_TIME_ASC = 3; // 排序规则：order by update_time asc

    private static final Integer ORDER_BY_UPDATE_TIME_DESC = 4; // 排序规则：order by update_time desc


    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 当前页码数
     */
    private Integer pageNum;

    /**
     * 排序规则
     */
    private Integer sortOrder;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

}
