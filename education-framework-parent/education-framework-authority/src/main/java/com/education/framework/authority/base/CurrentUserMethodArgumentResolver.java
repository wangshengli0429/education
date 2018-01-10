package com.education.framework.authority.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.education.framework.authority.login.model.LoginUser;
import com.education.framework.authority.notes.CurrentUser;

public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

//	@Override
//	public Object resolveArgument(MethodParameter parameter,
//			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
//			WebDataBinderFactory binderFactory) throws Exception {
//		LoginUser user = (LoginUser) webRequest.getAttribute("currentUser", RequestAttributes.SCOPE_REQUEST);
//       if (user != null) {
//           return user;
//       }
//       throw new MissingServletRequestPartException("currentUser");
//	}
//
//	@Override
//	public boolean supportsParameter(MethodParameter parameter) {
//		return parameter.hasParameterAnnotation(CurrentUser.class);
//	}
//	
	/**
	 * 检查解析器是否支持解析该参数
	 */
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
	    if(
	            //如果该参数注解有@CurrentUser
	            parameter.getParameterAnnotation(CurrentUser.class)!=null&&
	            //如果该参数的类型为User
	            parameter.getParameterType()==LoginUser.class
	            ){
	        //支持解析该参数
	        return true;
	    }
	    return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
	        ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
	        WebDataBinderFactory binderFactory) throws Exception {
	        HttpServletRequest request= (HttpServletRequest) webRequest.getNativeRequest();
	    //这里暂时把User对象放在session中
	        LoginUser user=(LoginUser)request.getSession().getAttribute("user");
	        return user;
	    }
	
}
