package com.education.framework.common.exception.handler;

import com.aixuexi.thor.response.ResultData;
import com.aixuexi.thor.except.BaseException;
import com.aixuexi.thor.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 异常结果处理
 * Created by dingqihui on 2016/9/6.
 *
 * @author dingqihui
 */
public class BaseExceptionHandler implements ExceptionHandler<BaseException>{
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseExceptionHandler.class);
    /**
     * 判断是否支持.
     *
     * @param throwable 异常
     * @return 判断结果
     */
    public  boolean isSupport(final Exception throwable){
        return throwable instanceof BaseException;
    }

    /**
     * 处理结果.
     *
     * @param request http请求对象
     * @param response http响应对象
     * @param ex 异常对象
     * @throws IOException 页面异常
     */
    public void handler(final HttpServletRequest request, final HttpServletResponse response, final BaseException ex)throws IOException {
        LOGGER.error(ex.getMessage(), ex);
        ResultUtil.writeResponse(response, new ResultData(ex.getMessage(), ex.getExceptionCode().getCode()));
    }
}
