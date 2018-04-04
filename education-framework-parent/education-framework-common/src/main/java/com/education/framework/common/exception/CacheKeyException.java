package com.education.framework.common.exception;

/**
 * Created by yangtao on 2016/11/12.
 */
public class CacheKeyException extends BaseException {
    private ExceptionCode exceptionCode = ExceptionCode.GET_CACHE_KEY_ERROR;

    public CacheKeyException(){
        super(ExceptionCode.GET_CACHE_KEY_ERROR.getMessage());
    }

    @Override
    public ExceptionCode getExceptionCode() {
        return exceptionCode;
    }
}
