package com.education.framework.common.exception;

/**
 * Created by dingqihui on 2016/11/12.
 * @author dingqihui
 */
public class NotLoginException extends BaseException {
    private ExceptionCode exceptionCode;

    public NotLoginException(){
        super(ExceptionCode.NOT_LOGIN_ERROR.getMessage());
        this.exceptionCode = ExceptionCode.NOT_LOGIN_ERROR;
    }

    @Override
    public ExceptionCode getExceptionCode() {
        return exceptionCode;
    }
}
