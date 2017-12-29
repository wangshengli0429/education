package com.education.framework.authority.common.service;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.education.framework.common.service.LogFormatService;

@SuppressWarnings("all")
public final class VarKeys {

    /** 日志 */
    private static Logger LOGGER = Logger.getLogger(VarKeys.class);
    // 登录类
    public static final String LOGIN = "login";
    // 登录用户信息
    public static final String LOGIN_USER = "loginUser";
    // 信息
    public static final String MSG = "msg";
    // boolean标志
    public static final String FLAG = "flag";
    // 目录
    public static final String MENU_LIST = "menuList";
    // 资源
    public static final String RESOURCE_LIST = "resourceList";
    // 用于记录修改之前的内容的key
    public static final String CON_OLD = "oldContent";

    public static String structKey(String reqName, String param) {
        String key = "";
        if (StringUtils.isBlank(reqName)) {
            LOGGER.error(LogFormatService.logFormat("参数reqName[" + reqName + "]为空异常"));
            throw new RuntimeException();
        } else if (StringUtils.isBlank(param)) {
            LOGGER.error(LogFormatService.logFormat("参数param[" + param + "]为空异常"));
            throw new RuntimeException();
        } else {
            key = reqName + "." + param;
        }
        return key;
    }
}
