package com.education.framework.common.response;


import com.alibaba.fastjson.JSON;
import com.education.framework.common.exception.ResponseDataException;
import com.education.framework.common.util.JsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据类型
 *
 * @author dingqihui
 */
public class ResultData implements Serializable {
    private static final long serialVersionUID = 5419750602572069009L;
    private static Logger logger = LoggerFactory.getLogger(ResultData.class);

    public static final int STATUS_NORMAL = 1; //业务状态 正常

    public static final int STATUS_ERROR = 0; //业务状态 异常

    public static final int STATUS_DEPRECATED = -1; //业务状态 废弃

    private int status = STATUS_NORMAL; //业务状态 默认正常

    private int errorCode; //错误代码

    private String errorMessage = "";

    private Object body;

    public ResultData() {
        super();
    }

    /**
     * 带参构造函数
     *
     * @param status       状态
     * @param errorMessage 信息
     * @param errorCode    错误码
     */
    public ResultData(final int status, final String errorMessage, final int errorCode) {
        super();
        this.status = status;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    /**
     * 带参构造函数(默认错误)
     *
     * @param errorMessage 信息
     * @param errorCode    错误码
     */
    public ResultData(final String errorMessage, final int errorCode) {
        super();
        this.status = ResultData.STATUS_ERROR;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    /**
     * 带参构造函数(默认正确)
     *
     * @param body 数据
     */
    public ResultData(final Object body) {
        super();
        this.body = body;
        if (this.body == null) {
            logger.error("ResultData.body is null.");
        }
    }

    public Object getBody() {
        if (this.body == null) {
            return new HashMap<String, Object>();
        } else {
            return body;
        }
    }

    public ResultData setBody(Object body) {
        this.body = body;
        if (this.body == null) {
            logger.error("ResultData.body is null.");
        }
        return this;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 向body中放置数据,前提是Map类型或还未放值
     *
     * @param key   (String)
     * @param value (Object)
     * @return
     */
    public boolean putKV(String key, Object value) {
        if (key != null && value != null) {
            if (body == null) {
                body = new HashMap<>();
            }
            if (body instanceof Map) {
                ((Map) body).put(key, value);
                return true;
            } else {
                throw new ResponseDataException();
            }
        }
        return false;
    }

    /**
     * 从body中获取数据,前提是Map类型
     *
     * @param key (String)
     * @return Object
     */
    public Object tetKV(String key) {
        if (body == null){
            return null;
        }
        return ((Map) body).get(key);
    }

    /**
     * 从body中获取String数据,前提是Map类型
     *
     * @param key (String)
     * @return String
     */
    public String tetKVString(String key) {
        return (String) tetKV(key);
    }

    /**
     * 从body中获取Integer数据,前提是Map类型
     *
     * @param key (String)
     * @return String
     */
    public Integer tetKVInteger(String key) {
        return (Integer) tetKV(key);
    }

    /**
     * 从body中获取Long数据,前提是Map类型
     *
     * @param key (String)
     * @return String
     */
    public Long tetKVLong(String key) {
        return (Long) tetKV(key);
    }

    /**
     * Body是否是Map类型
     *
     * @return
     */
    public boolean itMapBody() {
        return body != null && body instanceof Map;
    }

    /**
     * 是否正常
     *
     * @return
     */
    public boolean itSuccess() {
        return status == ResultData.STATUS_NORMAL;
    }

    /**
     * 是否异常
     *
     * @return
     */
    public boolean itNotSuccess() {
        return status != ResultData.STATUS_NORMAL;
    }

    /**
     * 是否废弃
     *
     * @return
     */
    public boolean itNotDeprecated() {
        return status != ResultData.STATUS_DEPRECATED;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "status=" + status +
                ", errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", body=" + JsonHelper.GetJsonResult(getBody()) +
                '}';
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public static ResultData successed() {
        return new ResultData();
    }

    public static ResultData successed(Object data) {
        ResultData resultData = new ResultData();
        resultData.setBody(data);
        return resultData;
    }

    public static ResultData successed(String mesg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setErrorMessage(mesg);
        resultData.setBody(data);
        return resultData;
    }

    public static ResultData failed(String mesg) {
        ResultData resultData = new ResultData();
        resultData.setErrorMessage(mesg);
        resultData.setStatus(STATUS_ERROR);
        return resultData;
    }

    public static ResultData deprecated(Object data) {
        ResultData resultData = new ResultData();
        resultData.setBody(data);
        resultData.setStatus(STATUS_DEPRECATED);
        return resultData;
    }

    public static ResultData convert(RpcResultData rpcResultData) {
        ResultData resultData = new ResultData(rpcResultData.getStatus(), rpcResultData.getErrorMessage(), rpcResultData.getErrorCode());
        resultData.setBody(rpcResultData.getData());
        return resultData;
    }

}
