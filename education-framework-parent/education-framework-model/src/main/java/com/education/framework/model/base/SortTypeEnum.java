package com.education.framework.model.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 排序
 */
public enum SortTypeEnum {
    ID_ASC(1, "id asc"),

    ID_DESC(2, "id desc"),

    CREATE_TIME_ASC(3, "create_time asc"),

    CREATE_TIME_DESC(4, "create_time desc"),

    UPDATE_TIME_ASC(5, "update_time asc"),

    UPDATE_TIME_DESC(6, "update_time desc");

    private final String sortSql;
    private final Integer sortId;

    private static final Map<Integer, String> idSqlMap = new HashMap<>(SortTypeEnum.values().length * 3);

    SortTypeEnum(Integer sortId, String sortSql) {
        this.sortSql = sortSql;
        this.sortId = sortId;
    }

    public static String getSqlBySortId(Integer sortId) {
        if (idSqlMap.size() != SortTypeEnum.values().length) {
            if(idSqlMap.size()!=0) {
                idSqlMap.clear();
            }
            for (SortTypeEnum sortTypeEnum : SortTypeEnum.values()) {
                idSqlMap.put(sortTypeEnum.sortId, sortTypeEnum.sortSql);
            }
        }
        return idSqlMap.get(sortId);
    }


    public String getSortSql() {
        return sortSql;
    }

    public Integer getSortId() {
        return sortId;
    }
}
