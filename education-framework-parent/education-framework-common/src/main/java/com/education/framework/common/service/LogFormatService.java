package com.education.framework.common.service;

import java.util.Date;

import org.apache.log4j.Logger;

import com.education.framework.common.util.Const;
import com.education.framework.common.util.DateUtil;
import com.education.framework.common.util.MetaInfo;

@SuppressWarnings("all")
public final class LogFormatService {

    /** 日志 */
    private static Logger LOGGER = Logger.getLogger(LogFormatService.class);

    /**
     * 返回状态
     */
    public static enum LOGSTEP {
        SUCCESS, FAILED, DEFAULT
    }

    /**
     * tag.
     */
    private static final String STATUS_SUE = "SUE";
    /**
     * tag.
     */
    private static final String STATUS_FAD = "FAD";
    /**
     * tag.
     */
    private static final String PROCESS = "[PROCESS]";
    /**
     * tag.
     */
    private static final String L = "[";
    /**
     * tag.
     */
    private static final String R = "]";
    /**
     * tag.
     */
    private static final String RL = "][";
    /**
     * tag.
     */
    private static final String TIME_MS = "ms";
    /**
     * tag.
     */
    private static final String PRM = "[PRM=";
    /**
     * tag.
     */
    private static final String RTN = "[RTN=";

    /**
     * tag.
     */
    private static final String LID = "LID=";
    /**
     * tag.
     */
    private static final String ETM = "ETM=";

    /**
     * tag.
     */
    private static final String MTD = "MTD=";

    /**
     * tag.
     */
    private static final String MSG = "[MSG=";
    /**
     * tag.
     */
    private static final String ACC = "[ACC-";
    /**
     * tag.
     */
    private static final String XR = "]";
    /**
     * tag.
     */
    private static final String TXR = "...]";

    /**
     * tag.
     */
    private static final String BLANK = "";
    /**
     * tag.
     */
    private static final int LENGTH_MAX = 4096;
    /**
     * tag.
     */
    private static final String USER = "用户<";
    /**
     * tag.
     */
    private static final String IN = "在<";
    /**
     * tag.
     */
    private static final String UXR = ">";
    /**
     * tag.
     */
    private static final String OPA_L = "执行了<";
    /**
     * tag.
     */
    private static final String OPA_R = ">操作，内容：";

    /**
     * 日志参数实体
     */
    private static MetaInfo meta;
    /**
     * 操作时间
     */
    private static String operatDate;

    public static void init(String method, String userName) {
        meta = new MetaInfo(method, userName);
    }

    /**
     * 获取MetaInfo
     * 
     */
    public static void getMetaInfo() {
        if (meta == null) {
            init(BLANK, BLANK);
        }
    }

    public static void accMark(LOGSTEP step) {
        if (step != null) {
            getMetaInfo();
            if (meta != null && LOGSTEP.SUCCESS == step) {
                meta.setStatus(STATUS_SUE);
            } else if (meta != null && LOGSTEP.FAILED == step) {
                meta.setStatus(STATUS_FAD);
            }
        }

    }

    /**
     * 日志:简单信息
     * 
     * @param msg
     * @return
     */
    public static String logogram(String msg) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(PROCESS);
        buffer.append(MSG).append(msg).append(XR);
        return buffer.toString();
    }

    /**
     * 日志:自定义开始时间与方法名
     * 
     * @param msg
     * @param time
     * @param method
     * @return
     */
    public static String logFormat(String msg, long time, String method) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(PROCESS);
        buffer.append(L);
        buffer.append(ETM).append(System.currentTimeMillis() - time).append(TIME_MS);
        buffer.append(RL).append(MTD).append(method).append(R);
        buffer.append(MSG).append(msg).append(XR);
        return buffer.toString();
    }

    /**
     * 日志:开始时间为进入方法的时间，自定义方法名
     * 
     * @param msg
     * @param method
     * @return
     */
    public static String logFormat(String msg, String method) {
        StringBuffer buffer = new StringBuffer();
        getMetaInfo();
        buffer.append(PROCESS);
        buffer.append(L);
        buffer.append(ETM).append(System.currentTimeMillis() - meta.getStartTime()).append(TIME_MS);
        buffer.append(RL).append(MTD).append(method).append(R);
        buffer.append(MSG).append(msg).append(XR);
        return buffer.toString();
    }

    /**
     * 日志:系统定义开始时间与方法名，只需输入msg
     * 
     * @param msg
     * @return
     */
    public static String logFormat(String msg) {
        StringBuffer buffer = new StringBuffer();
        getMetaInfo();
        buffer.append(PROCESS);
        buffer.append(L);
        buffer.append(ETM).append(System.currentTimeMillis() - meta.getStartTime()).append(TIME_MS);
        buffer.append(RL).append(MTD).append(meta.getMethod()).append(R);
        buffer.append(MSG).append(msg).append(XR);
        return buffer.toString();
    }

    /**
     * 日志：增、删、改记录
     * 
     * @param optName 操作类型
     * @param msg
     * @return
     */
    public static String urdLogFormat(String optName, String msg) {
        operatDate = DateUtil.format(new Date(), DateUtil.DATE_NORMAL_PATTERN);
        StringBuffer buffer = new StringBuffer();
        buffer.append(L).append(optName).append(R).append(L);
        buffer.append(ETM).append(System.currentTimeMillis() - meta.getStartTime()).append(TIME_MS);
        buffer.append(RL).append(MTD).append(meta.getMethod()).append(R);
        buffer.append(MSG).append(USER).append(meta.getUserName()).append(UXR);
        buffer.append(IN).append(operatDate).append(UXR);
        buffer.append(OPA_L).append(optName).append(OPA_R);
        if (Const.DELETE.equals(optName)) {
            buffer.append("ID=").append(msg);
        } else {
            buffer.append(msg);
        }
        buffer.append(XR);
        return buffer.toString();
    }

    /**
     * 修改日志内容构造
     * 
     * @param before 修改前
     * @param now 修改后
     * @return
     */
    public static String hndAddMsg(String before, String now) {
        return before + "修改为" + now;
    }
}
