package com.education.framework.common.response;



import com.education.framework.common.response.constants.ApiRetCode;

import java.io.Serializable;

/**
 * @author ChengZhu Liang
 * @CreateTime 16/10/19
 * @note api返回结构封装
 * @param <T>
 */


public class ApiResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_SUCCESS_MSG = "SUCCESS";
	private String message;
	private int retCode;
	private T body;

	public ApiResponse() {
		super();
	}

	public ApiResponse(int retCode, String message, T body) {
		this();
		this.message = message;
		this.body = body;
		this.retCode = retCode;
	}

	public boolean isSuccess() {
		return this.retCode == ApiRetCode.SUCCESS_CODE;
	}

	public boolean isNotSuccess() {
		return this.retCode != ApiRetCode.SUCCESS_CODE;
	}

	public static <T> ApiResponse<T> success(T body) {
		return new ApiResponse<T>(ApiRetCode.SUCCESS_CODE,DEFAULT_SUCCESS_MSG, body);
	}

	public static <T> ApiResponse<T> success(T body,String message) {
		return new ApiResponse<T>(ApiRetCode.SUCCESS_CODE, message, body);
	}

	public static <T> ApiResponse<T> fail(int retCode ,String message, T body) {
		return new ApiResponse<T>(retCode, message, body);
	}

	public static <T> ApiResponse<T> parameterError(String message, T body) {
		return new ApiResponse<T>(ApiRetCode.PARAMETER_ERROR, message, body);
	}

	public static <T> ApiResponse<T> parameterError(String message) {
		return new ApiResponse<T>(ApiRetCode.PARAMETER_ERROR, message, null);
	}

	public static <T> ApiResponse<T> fail(int retCode ,String message) {
		return new ApiResponse<T>(retCode, message, null);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getBody() {
		return body;
	}

	public int getRetCode() {
		return retCode;
	}

	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}

	public void setBody(T body) {
		this.body = body;
	}

}
