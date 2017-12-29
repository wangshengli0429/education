package com.education.framework.common.exception;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import com.education.framework.common.base.StatusCode;

/**
 * 业务常用错误异常,切换为RuntimeException,避免杂AOP时增加对异常捕获的困难
 *
 * @author wangshengli
 * @see StatusCode
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 296310486707353976L;

	private StatusCode status;

	private String showMessage;

	public BusinessException(StatusCode status) {
		this(status, status.getMsg(), null);
	}

	public BusinessException(StatusCode status, String showMessage) {
		this(status, status.getMsg(), showMessage);
	}

	public BusinessException(StatusCode status, String message, String showMessage) {
		super(message);
		Assert.notNull(status);
		this.status = status;
		setShowMessage(showMessage);
	}

	public BusinessException(Throwable cause, StatusCode status) {
		super(cause);
		Assert.notNull(status);
		this.status = status;
	}

	public BusinessException(Throwable cause, StatusCode status, String showMessage) {
		this(cause, status);
		setShowMessage(showMessage);
	}

	public StatusCode getStatus() {
		return status;
	}

	public Integer getCode() {
		return status.getCode();
	}

	public String getShowMessage() {
		if (StringUtils.isBlank(showMessage))
			return status.getShowMsg();
		return showMessage;
	}

	public void setShowMessage(String showMessage) {
		this.showMessage = showMessage;
	}

}
