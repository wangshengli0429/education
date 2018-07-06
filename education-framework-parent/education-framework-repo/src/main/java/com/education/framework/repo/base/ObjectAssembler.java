package com.education.framework.repo.base;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Yang Dong
 * @createTime 2018/3/21  16:26
 * @lastUpdater Yang Dong
 * @lastUpdateTime 2018/3/21  16:26
 * @note
 */
public interface ObjectAssembler<BO> {

    /**
     * 增强的处理函数
     * @param rs  数据库访问对象
     * @param bo  传入的bo
     * @throws SQLException sql异常
     */
    void assemble(ResultSet rs, BO bo) throws SQLException;

}
