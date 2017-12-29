package com.education.framework.authority.common.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.education.framework.common.service.LogFormatService;
import com.education.framework.common.service.LogFormatService.LOGSTEP;
import com.education.framework.common.util.Const;

/**
 * 结果处理类
 */

public final class Resultservice {

    public Resultservice() {

    }

    /**
     * 返回处理
     * 
     * @param data
     * @return
     */
    public static Object success(Object data) {
        Object resultObject = new ResultBody(Const.ResultCode.SUCCESS, data);
        LogFormatService.accMark(LOGSTEP.SUCCESS);
        return new ResponseEntity<Object>(resultObject, HttpStatus.OK);
    }
}
