package com.education.framework.common.base;
 
import com.alibaba.fastjson.JSON;

/**
 * App 返回数据
 */
public class ApiResult implements java.io.Serializable {

	private static final long serialVersionUID = 2177938600160116668L;

	private int state;// 状态码

	private String message;// 信息

	private String showMessage;// 显示信息

	private Object data;// 数据

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

	public ApiResult(int state, String message, String showMessage, Object data) {
		setState(state);
		setMessage(message);
		setShowMessage(showMessage);
		setData(data);
	}

	public ApiResult(int state, String showMessage, Object data) {
		super();
		this.state = state;
		this.showMessage = showMessage;
		this.data = data;
	}

	 
	public ApiResult(int state, String showMessage) {
		super();
		this.state = state;
		this.showMessage = showMessage;
	}

	public ApiResult(int state, String message, String showMessage) {
		setState(state);
		setMessage(message);
		setShowMessage(showMessage);
	}

	public ApiResult() {
		// nothing...
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
}
