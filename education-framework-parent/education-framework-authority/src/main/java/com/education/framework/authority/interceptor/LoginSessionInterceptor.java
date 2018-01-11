package com.education.framework.authority.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.education.framework.authority.login.model.LoginUser;
import com.education.framework.common.service.LogFormatService;
import com.education.framework.common.util.Const;
import com.education.framework.common.util.ResultError;

/**
 * 拦截器
 * 
 * @author Administrator
 *
 */
public class LoginSessionInterceptor implements HandlerInterceptor {

    /** 日志 */
    private static Logger LOGGER = Logger.getLogger(LoginSessionInterceptor.class);
    /** converter */
    @Autowired
    private MappingJackson2HttpMessageConverter converter;

    @Override
    public void afterCompletion(HttpServletRequest arg0,
            HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
            Object arg2, ModelAndView arg3) throws Exception {

    }

    /**
     * 拦截处理
     * 
     * 1. session用户信息为空，未登陆 
     * 
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object arg2) throws Exception {
    	
	   
    	
    	
    	
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpSession session = httpReq.getSession();
        String method = httpReq.getMethod();
        boolean flag = false;
        String reqPath = "";
        if ("GET".equals(method) || "POST".equals(method)) {
            reqPath = extractRequestPath(httpReq);
            /******************  APP 登录拦截规则  **********************/
            if(cotainRest(reqPath)){
            	LOGGER.info("拦截到APP端访问:"+reqPath);
            	//TODO APP访问拦截规则定义
            	//TODO APP 查询数据库Token
            	//TODO Token存在效验正确放过
            	//TODO Token失败返回登录
            	
            }else{
            
	            /******************  PC登录管理拦截  **********************/
	            LoginUser loginUser = (LoginUser) session.getAttribute("user");
	            // 判断用户是否为空，即是否登陆过
	            if (loginUser != null) {
	                LogFormatService.init(reqPath, loginUser.getManageCode());
	                // 服务端访问
	//                if (cotainAdmin(reqPath)) {
	//                    if (Const.Base.ISSTAFF_Y != loginUser.getIsstaff()) {
	//                        flag = false;
	//                        LOGGER.info(LogFormatService.logogram("用户[" + loginUser.getUserName()
	//                                + "]没有服务器端访问权限, request path:" + reqPath));
	//                        request.getRequestDispatcher("/static/error/error2login.jsp").forward(request, response);
	//                    } else {
	//                        if (hasAnthority(reqPath, loginUser)) {
	//                            flag = true;
	//                        } else {
	//                            LOGGER.info(LogFormatService.logogram("有服务器端访问权限但无该资源的访问权限reqPath:" + reqPath));
	//                            if (extractRequestAjax(request)) {
	//                                fail(response, -1, "用户没有权限");
	//                            } else {
	//                                request.getRequestDispatcher("/static/error/error3Authority.jsp").forward(request, response);
	//                            }
	//                            flag = false;
	//                        }
	//                    }
	//                } else {
	//                    LOGGER.info("有客户端访问权限");
	                    flag = true;
	//                }
	            } else {
	                // 未登录，跳转到登录页面
	                LOGGER.info(LogFormatService.logogram("用户未登录, request path:" + reqPath));
	                request.getRequestDispatcher("/static/error/error2login.jsp").forward(request, response);
	            }
            
            }
        }
        if (!flag) {

        }
        return flag;
    }

    /** 获取url */
    private String extractRequestPath(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        String query = request.getQueryString();
        return (servletPath == null ? "" : servletPath) + (pathInfo == null ? "" : pathInfo)
                + (query == null ? "" : ("?" + query));
    }
    
    /** 判断是否为ajax请求 */
    private boolean extractRequestAjax(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        if (StringUtils.isNotBlank(requestType) && requestType.equals("XMLHttpRequest")) {
            return true;
        } else {
            return false;
        }
    }

    /** 判断后台还是前台的url */
    private boolean cotainAdmin(String url) {
        if (url != null && !"".equals(url) && url.length() > 0) {
            String[] pathArr = url.split("/");
            for (int i = 0; i < pathArr.length; i++) {
                if (Const.ADMIN.equals(pathArr[i])) {
                    return true;
                }
            }
        }
        return false;
    }
    /** 判断是否是APP访问 规则  /rest/**  */
    private boolean cotainRest(String url) {
        if (url != null && !"".equals(url) && url.length() > 0) {
            String[] pathArr = url.split("/");
            for (int i = 0; i < pathArr.length; i++) {
                if (Const.REST.equals(pathArr[i])) {
                    return true;
                }
            }
        }
        return false;
    }
    

    /** 用户权限 */
    private boolean hasAnthority(String url, LoginUser loginUser) {
        boolean flag = false;
        //TODO
        //TODO
        //TODO
//        if (url.indexOf("?") >= 0) {
//            url = url.split(File.separator+"?")[0].toString();
//        }
//        List<Resource> list = loginUser.getResourceList();
//        if (CollectionUtils.isEmpty(list)) {
//            flag = false;
//        } else {
//            for (Resource resource : list) {
//                String resourceUrl = resource.getResourceUrl();
//                if (StringUtils.isNotBlank(resourceUrl) && url.trim().equals(resourceUrl.trim())) {
//                    flag = true;
//                    break;
//                }
//            }
//        }
        return flag;
    }

    /**
     * ajax错误处理.
     * 
     * @param response
     *            响应
     * @param errorCode
     *            错误号
     * @param errorMsg
     *            错误信息
     */
    private void fail(HttpServletResponse response, int errorCode, String errorMsg) {
        try {
            LOGGER.error(LogFormatService.logFormat("PermissionFail: errorCode="
                    + errorCode + ", errorMsg=" + errorMsg));
            response.setCharacterEncoding("UTF-8");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            converter.write(new ResultError(errorCode, errorMsg),
                    MediaType.APPLICATION_JSON, new ServletServerHttpResponse(
                            response));
        } catch (Throwable e) {
            LOGGER.error(LogFormatService.logFormat("ajax error"), e);
        }
    }
    
}
