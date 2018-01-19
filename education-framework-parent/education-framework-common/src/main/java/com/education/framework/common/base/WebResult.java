package com.education.framework.common.base;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class WebResult implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 1L;
	/** 返回状态码  0：成功 */
	private Integer code;
	/** 提示信息 */
	private String msg;
	/** 返回数据 */
	private Object data;
	/** 数据总数 */
	private Integer count;
	
	//************************************************** 构造方法 ************************************************************
	
	public WebResult() {
		super();
	}

	public WebResult(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public WebResult(Integer code, String msg, Object data, Integer count) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.count = count;
	}

	// ****************************************  以下是get/set 方法*************************************
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
