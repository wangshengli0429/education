package com.education.framework.common.notes;

import java.lang.annotation.*;

/**
 *  wangshengli - 20180123
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestAttribute {

    /**
     * 参数绑定到哪里
     * @return
     */
    String value();

}
