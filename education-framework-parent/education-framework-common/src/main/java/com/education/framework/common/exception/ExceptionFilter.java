package com.education.framework.common.exception;

import com.aixuexi.thor.except.handler.DefaultExceptionHandler;
import com.aixuexi.thor.except.handler.ExceptionHandler;
import com.aixuexi.thor.log.Constants;
import com.aixuexi.thor.util.HttpRequestUtils;
import com.alibaba.dubbo.common.json.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 异常处理
 * Created by dingqihui on 2016/9/6.
 *
 * @author dingqihui
 */
public class ExceptionFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(ExceptionFilter.class);
    private static String COMM_FLAG = "{!@#$%^&*}";
    private List<ExceptionHandler<Exception>> exceptionHandlers;
    private ExceptionHandler<Exception> defaultHandler = new DefaultExceptionHandler();
    private GetUserIdProxy getUserIdProxy;
    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        try{
            MDC.put(Constants.LOGGER_TRADE_NO, UUID.randomUUID().toString().replaceAll("-",""));
            chain.doFilter(request, response);
        } catch (final Exception e){
            HttpServletRequest servletRequest = (HttpServletRequest) request;
            String params = JSON.json(servletRequest.getParameterMap());
            Long userId = 0L;
            if (getUserIdProxy != null) {
                userId = getUserIdProxy.getUserId(servletRequest);
            }
            logger.error("{} USER_ID:{}, USER_IP:{}, URI:{}, PARAMS:{}", COMM_FLAG, userId,
                    HttpRequestUtils.getIP(servletRequest), servletRequest.getRequestURI(), params);
            Exception exception = e;
            final HttpServletRequest httpServletRequest=(HttpServletRequest) request;
            final HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            //是否定义异常处理，如果没有使用默认
            if(exceptionHandlers !=null && !exceptionHandlers.isEmpty()){
                try{
                    //循环判断
                    for(final ExceptionHandler exceptionHandler:exceptionHandlers){
                        if(exceptionHandler.isSupport(exception)){
                            exceptionHandler.handler(httpServletRequest, httpServletResponse, exception);
                            return;
                        }
                    }
                }catch (final Exception ex){
                    exception=ex;
                }
            }
            //如果没有默认将异常包装为ServletException抛出
           if(defaultHandler!=null && defaultHandler.isSupport(exception)){
                defaultHandler.handler(httpServletRequest, httpServletResponse, exception);
            }else{
               throw new ServletException(exception);
           }
        } finally {
            MDC.remove(Constants.LOGGER_TRADE_NO);
        }
    }

    @Override
    public void destroy() {
    }

    public void setExceptionHandlers(final List<ExceptionHandler<Exception>> exceptionHandlers) {
        this.exceptionHandlers = exceptionHandlers;
    }

    public void setDefaultHandler(final ExceptionHandler<Exception> defaultHandler) {
        this.defaultHandler = defaultHandler;
    }

    public void setGetUserIdProxy(GetUserIdProxy getUserIdProxy) {
        this.getUserIdProxy = getUserIdProxy;
    }
}
