package com.education.framework.common.exception.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 异常结果处理
 * Created by dingqihui on 2016/9/6.
 *
 * @author dingqihui
 */
public interface ExceptionHandler<T extends Exception> {
    /**
     * 判断是否支持.
     *
     * @param throwable 异常
     * @return 判断结果
     */
    boolean isSupport(Exception throwable);

    /**
     *
     * @param request http请求对象
     * @param response http响应对象
     * @param ex 异常对象
     * @throws IOException 页面输出异常
     */
    void handler(final HttpServletRequest request, final HttpServletResponse response, final T ex) throws IOException;
}
