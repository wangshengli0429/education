package com.education.framework.repo.jdbc;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.dao.support.DataAccessUtils;

import java.util.Collection;

/**
 * Created by jiayuepeng on 2016/12/6.
 */
public class MyDataAccessUtils extends DataAccessUtils {
    public static <T> T requiredSingleResult(Collection<T> results) throws IncorrectResultSizeDataAccessException {
        int size = (results != null?results.size() : 0);
        if (size == 0) {
            return null;
        }
        if (results.size() > 1) {
            throw new IncorrectResultSizeDataAccessException(1, size);
        }
        return results.iterator().next();
    }
}
