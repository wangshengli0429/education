package com.education.framework.common.notes;

import java.lang.annotation.*;

/**
 * 解密 wangshengli - 20180123
 * 同时支持json及from提交
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestBodyForm {

    boolean required() default true;

    String value() default "";

}
