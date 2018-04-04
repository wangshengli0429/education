package com.education.framework.common.exception;

/**
 * Created by yangtao on 2016/11/12.
 */
public abstract class BaseException extends RuntimeException {

    public BaseException(String message){
        super(message);
    }

    public abstract ExceptionCode getExceptionCode();
}
