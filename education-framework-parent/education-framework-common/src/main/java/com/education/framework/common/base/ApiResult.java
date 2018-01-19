package com.education.framework.common.base;
 
import com.alibaba.fastjson.JSON;

/**
 * App 返回数据
 */
public class ApiResult implements java.io.Serializable {

	private static final long serialVersionUID = 2177938600160116668L;

	private int code;// 状态码

	private String msg;// 信息

	private String showMessage;// 显示信息

	private Object data;// 数据
	/** 数据总数 */
	private Integer count;
	/**
	 * 创建成功结果的Message
	 *
	 * @param data
	 *            待返回数据
	 * @return 返回的封装结果
	 */
	public static final ApiResult createSuccessResult(Object data) {
		ApiResult result = new ApiResult(ResultCode.MEF_CODE_00000.getCode(), ResultCode.MEF_CODE_00000.getMsg(),
				ResultCode.MEF_CODE_00000.getShowMsg(), data);
		return result;
	}

	 

	public static ApiResult createErrorResult(ResultCode statusCode) {
		return new ApiResult(statusCode.getCode(), statusCode.getMsg(), statusCode.getShowMsg());
	}

	public ApiResult(int code, String msg, String showMessage, Object data) {
		setCode(code);
		setMsg(msg);
		setShowMessage(showMessage);
		setData(data);
	}

	public ApiResult(int code, String showMessage, Object data) {
		super();
		this.code = code;
		this.showMessage = showMessage;
		this.data = data;
	}
	/******** layui 后台报文使用  ********/
	public ApiResult(int code, String msg, Object data, Integer count) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.count = count;
	}
	/******** layui 后台报文使用  ********/
	public ApiResult(int code, String showMessage) {
		super();
		this.code = code;
		this.showMessage = showMessage;
	}

	public ApiResult(int code, String msg, String showMessage) {
		setCode(code);
		setMsg(msg);
		setShowMessage(showMessage);
	}

	public ApiResult() {
		// nothing...
	}

	 

	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public String getShowMessage() {
		return showMessage;
	}

	public void setShowMessage(String showMessage) {
		this.showMessage = showMessage;
	}

	public <T> T getData() {
		@SuppressWarnings("unchecked")
		T _data = (T) data;
		return _data;
	}

	public <T> void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}



	public Integer getCount() {
		return count;
	}



	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
