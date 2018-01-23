package com.education.framework.common.notes;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.annotation.Annotation;

/**
 *  wangshengli - 20180123
 * 获取 @RequestAttribute attribute
 */
public class RequestAttributeResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestAttribute.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Annotation[] annotations = parameter.getParameterAnnotations();
        for (Annotation annotation : annotations) {
            if (RequestAttribute.class.isInstance(annotation)) {
                RequestAttribute ann = (RequestAttribute) annotation;
                String name = ann.value();
                return webRequest.getAttribute(name, RequestAttributes.SCOPE_REQUEST);
            }
        }
        return null;
    }
}
