package com.education.framework.authority.common.service;

/**
 * 返回实体类
 * 
 * @author weilibin
 *
 */

public class ResultBody {

    /** 状态码 */
    private int status;
    /** 结果 */
    private Object result;

    public ResultBody() {
    }

    public ResultBody(int status, Object result) {
        this.status = status;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
