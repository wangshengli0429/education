package com.education.framework.common.util;

import java.util.UUID;

public class StringUUID {
    /**
     * 生成UUID字符串
     * @return
     */
    public static String generate(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
