package com.education.framework.repo.base;

import java.io.Serializable;
import java.util.List;

/**
 * @author Yang Dong
 * @createTime 2018/3/21  18:31
 * @lastUpdater Yang Dong
 * @lastUpdateTime 2018/3/21  18:31
 * @note
 */
public class QueryEnhance<BO> implements Serializable {


    /**
     * 拼接到select 后面
     * 示例： "i.id, i.name as i_name, i.code i_code "
     */
    private String selectSql;

    /**
     * 拼接到join 后面
     * 示例： "left join institution.institution i
     */
    private String joinSql;

    /**
     * 拼接到where 后面
     * 示例： "i.update_time > ? and i.update_time < ?"
     */
    private String whereSql;

    /**
     * 拼接到where 后面语句的参数
     * 示例： { "2015-10-01", "2017-10-01" }
     */
    private List whereParam;

    public QueryEnhance() {
    }

    public QueryEnhance(String selectSql, String joinSql, String whereSql, List whereParam, ObjectAssembler<BO> objectAssembler) {
        this.selectSql = selectSql;
        this.joinSql = joinSql;
        this.whereSql = whereSql;
        this.whereParam = whereParam;
        this.objectAssembler = objectAssembler;
    }

    public QueryEnhance(String selectSql, String joinSql, String whereSql, List whereParam, String orderSql, ObjectAssembler<BO> objectAssembler) {

        this.selectSql = selectSql;
        this.joinSql = joinSql;
        this.whereSql = whereSql;
        this.whereParam = whereParam;
        this.orderSql = orderSql;
        this.objectAssembler = objectAssembler;
    }

    public QueryEnhance(String orderSql) {

        this.orderSql = orderSql;
    }

    public QueryEnhance(String whereSql, List whereParam) {

        this.whereSql = whereSql;
        this.whereParam = whereParam;
    }

    public QueryEnhance(String selectSql, String joinSql, String whereSql, List whereParam) {

        this.selectSql = selectSql;
        this.joinSql = joinSql;
        this.whereSql = whereSql;
        this.whereParam = whereParam;
    }

    public QueryEnhance(String selectSql, String joinSql) {
        this.selectSql = selectSql;

        this.joinSql = joinSql;
    }

    /**
     * 拼接到order by 后面
     * 示例： "i.id asc, i.name desc"
     */
    private String orderSql;


    /**
     * BO 对象组装器， 在自动封装本表字段后执行，以便进行额外的操作
     */
    private ObjectAssembler<BO> objectAssembler;

    public ObjectAssembler getObjectAssembler() {
        return objectAssembler;
    }

    public void setObjectAssembler(ObjectAssembler objectAssembler) {
        this.objectAssembler = objectAssembler;
    }

    public String getSelectSql() {
        return selectSql;
    }

    public void setSelectSql(String selectSql) {
        this.selectSql = selectSql;
    }

    public String getJoinSql() {
        return joinSql;
    }

    public void setJoinSql(String joinSql) {
        this.joinSql = joinSql;
    }

    public String getWhereSql() {
        return whereSql;
    }

    public void setWhereSql(String whereSql) {
        this.whereSql = whereSql;
    }

    public List getWhereParam() {
        return whereParam;
    }

    public void setWhereParam(List whereParam) {
        this.whereParam = whereParam;
    }

    public String getOrderSql() {
        return orderSql;
    }

    public void setOrderSql(String orderSql) {
        this.orderSql = orderSql;
    }
}
