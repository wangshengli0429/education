package com.education.framework.common.exception;

/**
 * Created by yangtao on 2016/11/12.
 */
public class ResponseDataException extends BaseException {
    private ExceptionCode exceptionCode = ExceptionCode.PUT_RESPONSE_DATA_ERROR;

    public ResponseDataException(){
        super(ExceptionCode.PUT_RESPONSE_DATA_ERROR.getMessage());
    }

    @Override
    public ExceptionCode getExceptionCode() {
        return exceptionCode;
    }
}
