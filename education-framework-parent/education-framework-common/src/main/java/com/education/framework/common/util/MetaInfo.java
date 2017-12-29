package com.education.framework.common.util;

import java.io.Serializable;

/**
 * 日志参数
 */

public final class MetaInfo implements Serializable {

    /**
     * STATUS_DEF.
     */
    private static final String STATUS_DEF = "DEF";
    /** uuid */
    private static final long serialVersionUID = 1L;
    /** 方法名 */
    private String method;
    /** 开始时间 */
    private long startTime;
    /** 用户帐号 */
    private String userName;
    /** 状态 */
    private String status = STATUS_DEF;

    public MetaInfo(String method, String userName) {
        this.method = method;
        this.userName = userName;
        this.startTime = System.currentTimeMillis();
    }

    public MetaInfo(String method) {
        this.method = method;
        this.startTime = System.currentTimeMillis();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public long getTime() {
        return System.currentTimeMillis() - startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
