package com.education.framework.common.redis;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.education.framework.common.util.DateUtil;
//import com.rock.framework.cif.vo.outupt.Result;

/**
 * Description:redis日切
 * Author:wangshengli
 * DateTime: 2017/12/10 11:11
 */

public class RedisExpire{
    protected static final Logger logger = Logger.getLogger(RedisExpire.class);

    protected boolean FACE_DETECTION_ENABLED = true;//face++ 人脸识别验证开关 为0时关闭，默认为1 启用，不设置时为1启用
    protected  static final String FACE_1E4 = "1e-4";//万分之一阈值(第二次调用时)TODO:抽取到rock.properties
    protected  static final String FACE_1E3 = "1e-3";//千分之一阈值(第一次调用时)TODO:抽取到rock.properties
    protected static final String PASSED = "1";
    protected static final String NOT_PASSED = "0";
   
    /**
     * 获取系统切日，redis失效时间。单位：秒
     * @return
     */
    protected  int getExpireSecond(){
        Date fistTime = DateUtil.getDateTime();//当前时间
        Date nextDate = DateUtil.add(DateUtil.getDate(), Calendar.DAY_OF_MONTH,1);
        String nextDateTime = DateUtil.formatDate(nextDate,"yyyy-MM-dd HH:mm:ss");
        Date secondTime = DateUtil.parseDateTime(nextDateTime);//系统日切时间即：第二天00:00:00
        long expireTime = (secondTime.getTime()-fistTime.getTime())/1000;
        return (int)expireTime;
    }
    /**
     *  获取系统切24小时，redis失效时间。单位：秒
     * @return
     */
    protected int getExpireDay() {
    	 Date fistTime = DateUtil.getDateTime();//当前时间
    	 Date nextDate =  DateUtil.add(DateUtil.getDateTime(), Calendar.HOUR,24);
    	 String nextDateTime = DateUtil.formatDate(nextDate,"yyyy-MM-dd HH:mm:ss");
    	 Date secondTime = DateUtil.parseDateTime(nextDateTime);//系统日切时间即：第二天00:00:00
    	 long expireTime = (secondTime.getTime()-fistTime.getTime())/1000;
    	 return (int)expireTime;
	}
    /**
     *  获取系统切月，redis失效时间。单位：秒
     * @return
     */
    protected int getExpireMonth() {
    	 Date fistTime = DateUtil.getDateTime();//当前时间
    	 Date nextDate = DateUtil.add(DateUtil.getDate(), Calendar.DAY_OF_MONTH,30);
    	 String nextDateTime = DateUtil.formatDate(nextDate,"yyyy-MM-dd HH:mm:ss");
    	 Date secondTime = DateUtil.parseDateTime(nextDateTime);//系统日切时间即：第二天00:00:00
    	 long expireTime = (secondTime.getTime()-fistTime.getTime())/1000;
    	 return (int)expireTime;
	}
    
    
}
