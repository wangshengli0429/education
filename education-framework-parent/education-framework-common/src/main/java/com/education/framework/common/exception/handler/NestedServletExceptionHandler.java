package com.education.framework.common.exception.handler;

import com.aixuexi.thor.response.ResultData;
import com.aixuexi.thor.except.ExceptionCode;
import com.aixuexi.thor.util.ResultUtil;
import org.springframework.web.util.NestedServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 异常结果处理
 * Created by dingqihui on 2016/9/6.
 *
 * @author dingqihui
 */
public class NestedServletExceptionHandler implements ExceptionHandler<NestedServletException>{
    /**
     * 异常处理对象.
     */
    private List<ExceptionHandler<Exception>> exceptionHandlers;
    /**
     * 判断是否支持.
     *
     * @param throwable 异常
     * @return 判断结果
     */
    public  boolean isSupport(final Exception throwable){
        return throwable instanceof NestedServletException;
    }

    @Override
    public void handler(final HttpServletRequest request, final  HttpServletResponse response, final NestedServletException ex)
            throws IOException {
        final Throwable throwable = ex.getCause();
        if(exceptionHandlers ==null || exceptionHandlers.isEmpty()){
            ResultUtil.writeResponse(response, new ResultData(ExceptionCode.UNKNOWN.getMessage(), ExceptionCode.UNKNOWN.getCode()));
            return;
        }
        if(throwable instanceof Exception){
            for(final ExceptionHandler exceptionHandler:exceptionHandlers){
                if(exceptionHandler.isSupport((Exception) throwable)){
                    exceptionHandler.handler(request, response, (Exception) throwable);
                    return;
                }
            }
        }
        //抛出异常给默认异常handler处理
        throw new RuntimeException(throwable);
    }

    public void setExceptionHandlers(final List<ExceptionHandler<Exception>> exceptionHandlers) {
        this.exceptionHandlers = exceptionHandlers;
    }
}
