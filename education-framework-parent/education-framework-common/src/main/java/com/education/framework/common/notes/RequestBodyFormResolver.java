package com.education.framework.common.notes;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.core.Conventions;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * 支持json及from表单解析器<br/>
 * 
 *  wangshengli - 20180123
 * 
 */
public class RequestBodyFormResolver implements HandlerMethodArgumentResolver {

	private ObjectMapper mapper;

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(RequestBodyForm.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpInputMessage inputMessage = new ServletServerHttpRequest(
				webRequest.getNativeRequest(HttpServletRequest.class));
		Object argument;
		if (MediaType.APPLICATION_JSON.includes(inputMessage.getHeaders().getContentType()))// JSON
			argument = resolveJsonArgument(webRequest, parameter);
		else
			argument = resolveFormArgument(parameter, mavContainer, webRequest, binderFactory);

		// String name = Conventions.getVariableNameForParameter(parameter);
		// WebDataBinder binder = binderFactory.createBinder(webRequest,
		// argument, name);
		//
		// if (argument != null) {
		// validate(binder, parameter);
		// }
		//
		// mavContainer.addAttribute(BindingResult.MODEL_KEY_PREFIX + name,
		// binder.getBindingResult());

		return argument;
	}

	private Object resolveJsonArgument(NativeWebRequest webRequest, MethodParameter parameter)
			throws IOException, IllegalAccessException, InstantiationException {

		JavaType javaType = mapper.getTypeFactory().constructType(parameter.getGenericParameterType());
		RequestBodyForm ann = parameter.getParameterAnnotation(RequestBodyForm.class);
		// spring mvc requestBody stream handle
		InputStream inputStream = webRequest.getNativeRequest(HttpServletRequest.class).getInputStream();
		if (!ann.required()) {
			if (inputStream == null) {
				return null;
			} else if (inputStream.markSupported()) {
				inputStream.mark(1);
				if (inputStream.read() == -1) {
					return null;
				}
				inputStream.reset();
			} else {
				final PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
				int b = pushbackInputStream.read();
				if (b == -1) {
					return null;
				} else {
					pushbackInputStream.unread(b);
				}
				inputStream = pushbackInputStream;
			}
		}
		return mapper.readValue(inputStream, javaType);
	}

	private Object resolveFormArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		// spring mvc modelAttribute handle
		String name = getNameForParameter(parameter);
		String value = webRequest.getParameter(name);
		if (value != null) {// 若传入参数为json则解析
			try {
				JavaType javaType = mapper.getTypeFactory().constructType(parameter.getGenericParameterType());
				return mapper.readValue(value, javaType);
			} catch (JsonParseException | JsonMappingException e) {
				// nothing
			}
		}

		Object attribute = (mavContainer.containsAttribute(name)) ? mavContainer.getModel().get(name)
				: BeanUtils.instantiateClass(parameter.getParameterType());

		WebDataBinder binder = binderFactory.createBinder(webRequest, attribute, name);
		if (binder.getTarget() != null) {
			bindRequestParameters(binder, webRequest);
		}

		Map<String, Object> bindingResultModel = binder.getBindingResult().getModel();
		mavContainer.removeAttributes(bindingResultModel);
		mavContainer.addAllAttributes(bindingResultModel);

		return binder.getTarget();
	}

	private void bindRequestParameters(WebDataBinder binder, NativeWebRequest request) {
		ServletRequest sr = request.getNativeRequest(ServletRequest.class);
		ServletRequestDataBinder sdb = (ServletRequestDataBinder) binder;
		sdb.bind(sr);
	}

	public String getNameForParameter(MethodParameter parameter) {
		RequestBodyForm ann = parameter.getParameterAnnotation(RequestBodyForm.class);
		String attrName = (ann == null) ? parameter.getParameterName()
				: "".equals(ann.value()) ? parameter.getParameterName() : ann.value();
		return StringUtils.hasText(attrName) ? attrName : Conventions.getVariableNameForParameter(parameter);
	}

	// 此方法无通用validate意义
	@SuppressWarnings("unused")
	private void validate(WebDataBinder binder, MethodParameter parameter)
			throws Exception, MethodArgumentNotValidException {

		Annotation[] annotations = parameter.getParameterAnnotations();
		for (Annotation ann : annotations) {
			if (ann.annotationType().getSimpleName().startsWith("Valid")) {
				Object hints = AnnotationUtils.getValue(ann);
				binder.validate(hints instanceof Object[] ? (Object[]) hints : new Object[] { hints });
				BindingResult bindingResult = binder.getBindingResult();
				if (bindingResult.hasErrors()) {
					if (isBindExceptionRequired(binder, parameter)) {
						throw new MethodArgumentNotValidException(parameter, bindingResult);
					}
				}
				break;
			}
		}
	}

	private boolean isBindExceptionRequired(WebDataBinder binder, MethodParameter parameter) {
		int i = parameter.getParameterIndex();
		Class<?>[] paramTypes = parameter.getMethod().getParameterTypes();
		boolean hasBindingResult = (paramTypes.length > (i + 1) && Errors.class.isAssignableFrom(paramTypes[i + 1]));
		return !hasBindingResult;
	}

}
