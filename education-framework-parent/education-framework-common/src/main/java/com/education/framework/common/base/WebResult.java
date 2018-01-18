package com.education.framework.common.base;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class WebResult implements Serializable{

	/**
	 * UID
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	
	private String msg;
	
	private Integer count;
	
	private Object data;
	
	public WebResult() {
		super();
	}

	public WebResult(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public WebResult(Integer code, String msg, Integer count, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
