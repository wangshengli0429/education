package com.education.framework.common.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;

public class Check {
	
	private static final Logger LOGGER = Logger.getLogger(DateUtil1.class);
	
	/**
	 * 验证ULR是否有效
	 * 
	 * @param url
	 * @return
	 */
	public static boolean urlTest(String url) {
		if (url == null || "".equals(url) || url.length() <= 0) {
			return false;
		}
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			int state = connection.getResponseCode();
			if (state == 200) {
				return true;
			}
		} catch (Exception e) {
			LOGGER.error("验证URL有效性异常", e);
			return false;
		}
		return false;
	}
	
	/**
	 * 验证数据库连接是否有效
	 * 
	 * @param url
	 * @param dbName
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean testDBUrl(String url,String dbName,String userName,String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if (url == null || "".equals(url) || url.length() <=0 ) {
				return false;
			}
			if (url.endsWith("/")) {
				url = url + dbName;
			} else {
				url = url+"/" + dbName;
			}
			DriverManager.getConnection(url,userName,password);
		} catch (Exception e) {
			LOGGER.error("测试数据库连接异常", e);
			return false;
		} 
		return true;
	}
	
	/**
	 * 数据库连接
	 * 
	 * @param url
	 * @param dbName
	 * @param userName
	 * @param password
	 * @return
	 */
	public static Connection getDBUrl(String url,String dbName,String userName,String password) {
	    Connection conn= null;
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        if (url == null || "".equals(url) || url.length() <=0 ) {
	            return null;
	        }
	        if (url.endsWith("/")) {
	            url = url + dbName;
	        } else {
	            url = url+"/" + dbName;
	        }
	        conn= (Connection) DriverManager.getConnection(url,userName,password);
	    } catch (Exception e) {
	        LOGGER.error("测试数据库连接异常", e);
	        return null;
	    } 
	    return conn;
	}

}
