package com.education.framework.common.exception;

/**
 * Created by yangtao on 2016/11/12.
 */
public enum ExceptionCode {
    GET_CACHE_KEY_ERROR(ExceptionCode.BASE_HEADER_CODE_SYSTEM_ERROR+ExceptionCode.HEADER_CODE_CACHE_ERROR+1,"生成缓存key失败",null),
    PUT_RESPONSE_DATA_ERROR(ExceptionCode.BASE_HEADER_CODE_SYSTEM_ERROR+ExceptionCode.HEADER_CODE_RESPONSE_ERROR+1,"生成ResultData异常",null),
    RPC_INVOKE_ERROR(ExceptionCode.BASE_HEADER_CODE_SYSTEM_ERROR+ExceptionCode.HEADER_CODE_RPC_INVOKE_ERROR + 1 ,"远程调用异常",null),
    ARGUMENT_IS_EMPTY_ERROR(ExceptionCode.BASE_HEADER_CODE_SYSTEM_ERROR+ExceptionCode.ILLEGAL_ARGUMENT_ERROR + 1 ,"参数为空",null),
    ARGUMENT_IS_ERROR_ERROR(ExceptionCode.BASE_HEADER_CODE_SYSTEM_ERROR+ExceptionCode.ILLEGAL_ARGUMENT_ERROR + 2 ,"参数不正确",null),
    NOT_LOGIN_ERROR(ExceptionCode.BASE_HEADER_CODE_SYSTEM_ERROR+ExceptionCode.HTTP_REQUEST_ERROR + 1 ,"用户未登录",null),
    FILE_UPLOAD_ERROR(ExceptionCode.BASE_HEADER_CODE_SYSTEM_ERROR+ExceptionCode.HTTP_REQUEST_ERROR + 2 ,"文件上传失败",null),
    UNKNOWN(ExceptionCode.BASE_HEADER_CODE_SYSTEM_ERROR,"未知异常",null),;
    ;
    private static final int BASE_HEADER_CODE_SYSTEM_ERROR = 100000000;
    /*非法参数异常*/
    private static final int ILLEGAL_ARGUMENT_ERROR = 0;
    private static final int HEADER_CODE_CACHE_ERROR = 110000;
    private static final int HEADER_CODE_RESPONSE_ERROR = 120000;
    /*rpc调用异常*/
    private static final int HEADER_CODE_RPC_INVOKE_ERROR = 200000;
    /*http请求异常*/
    private static final int HTTP_REQUEST_ERROR = 300000;

    private int code;
    private String message;//内部使用的提示
    private String alter = "系统内部错误";//可给用户展示的提示
    ExceptionCode(int code, String message, String alter){
        this.code=code;
        this.message=message;
        if(alter != null && alter.length() > 0) {
            this.alter = alter;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAlter() {
        return alter;
    }

    public void setAlter(String alter) {
        this.alter = alter;
    }
}
