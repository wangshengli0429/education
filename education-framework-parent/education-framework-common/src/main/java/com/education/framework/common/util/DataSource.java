package com.education.framework.common.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 动态数据库中获取数据
 */

public class DataSource {

    /** 日志 */
    private static final Logger LOGGER = Logger.getLogger(DataSource.class);
    /** Connection */
    private static Connection conn;
    /** PreparedStatement */
    private static PreparedStatement psmt;
    /** ResultSet */
    private static ResultSet rs;

    /**
     * 获取数据库连接
     * 
     * @param url
     * @param dbName
     * @param userName
     * @param password
     * @return
     */
    public static Connection getConn(String url, String dbName, String userName, String password) {
        try {
            Class.forName(Const.MYSQL);
            if (StringUtils.isBlank(url)) {
                LOGGER.error("url不能为空...");
                return null;
            } else if (StringUtils.isBlank(dbName)) {
                LOGGER.error("dbName不能为空...");
                return null;
            } else if (StringUtils.isBlank(userName)) {
                LOGGER.error("userName不能为空...");
                return null;
            } else if (StringUtils.isBlank(password)) {
                LOGGER.error("password不能为空...");
                return null;
            }
            if (url.endsWith("/")) {
                url = url + dbName;
            } else {
                url = url + "/" + dbName;
            }
            conn = (Connection) DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            LOGGER.error("获取动态数据库连接异常：", e);
            return null;
        }
        return conn;
    }

    /**
     * 动态获取数据
     * 
     * @param conn
     * @param sql
     * @param params
     * @return
     */
    public static ResultSet getData(PreparedStatement psmt) {
        try {
            rs = psmt.executeQuery();
        } catch (Exception e) {
            LOGGER.error("操作数据库获取数据：", e);
        }
        return rs;
    }

    /**
     * 获取PreparedStatement
     * 
     * @param conn
     * @param sql
     * @return
     */
    public static PreparedStatement getPsmt(Connection conn, String sql) {
        try {
            psmt = (PreparedStatement) conn.prepareStatement(sql);
        } catch (SQLException e) {
            LOGGER.error("获取PreparedStatement失败：", e);
        }
        return psmt;
    }

    /**
     * 关闭连接
     * 
     * @param conn
     */
    public static void closeConn(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            LOGGER.error("closed Connection is failed...", e);
        }
    }

    /**
     * 关闭PreparedStatement
     * 
     * @param pamt
     */
    public static void closePsmt(PreparedStatement pamt) {
        try {
            psmt.close();
        } catch (SQLException e) {
            LOGGER.error("closed PreparedStatement is failed...", e);
        }
    }

    /**
     * 关闭ResultSet
     * 
     * @param rs
     */
    public static void closeRs(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            LOGGER.error("closed ResultSet is failed...", e);
        }
    }
}
