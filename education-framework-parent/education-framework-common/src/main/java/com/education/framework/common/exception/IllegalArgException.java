package com.education.framework.common.exception;



/**
 * Created by dingqihui on 2016/11/12.
 * @author dingqihui
 */
public class IllegalArgException extends BaseException {
    private ExceptionCode exceptionCode;

    public IllegalArgException(ExceptionCode exceptionCode, String message){
        super(message);
        this.exceptionCode = exceptionCode;
    }

    @Override
    public ExceptionCode getExceptionCode() {
        return exceptionCode;
    }
}
