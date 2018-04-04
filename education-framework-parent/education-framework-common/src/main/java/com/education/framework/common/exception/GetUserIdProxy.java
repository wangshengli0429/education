package com.education.framework.common.exception;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangyiming on 2017/1/18.
 */
public interface GetUserIdProxy {
    Long getUserId(HttpServletRequest request);
}
