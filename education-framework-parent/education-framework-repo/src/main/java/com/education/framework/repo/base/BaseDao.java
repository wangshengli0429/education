package com.education.framework.repo.base;

import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.base.SortTypeEnum;
import com.google.common.collect.Lists;


import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.CollectionUtils;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * /@author Yang Dong
 * /@createTime 2017/6/9  11:49
 * /@lastUpdater Yang Dong
 * /@lastUpdateTime 2017/6/9  11:49
 * /@note abstract class which contains common repo operations
 */
@SuppressWarnings("all")
public abstract class BaseDao<PO, CO extends PO, BO extends PO> {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BaseDao.class);
    protected final String BASE_COLUMN;
    protected final String FULL_TABLE_NAME;
    protected final String TABLE_NAME;
    protected final String UPDATE_SQL;
    protected final String FROM_SQL;
    protected final String TABLE_POINT;
    protected final String SELECT_ALL_FROM_SQL;
    protected final String INSERT_SQL;


    protected final Field[] poFields;

    protected final Class<PO> poClassType;
    protected final Class<BO> boClassType;
    protected final Field[] boFields;
    protected final String[] poColumnName;
    protected final String[] boColumnName;

    private final Map<String, Field> poFieldNameMap;
    private final Map<String, Field> boFieldNameMap;


    private final Integer defaultPageSize = 10;
    private final Integer defaultPageNumber = 1;
    private final Integer defaultSortOrder = 2;
    protected final Set<String> noUpdateColumns;
    protected final Set<String> timeColumns;

    protected final String DELETED = "deleted";
    protected final String ID = "id";
    protected final String UPDATE_TIME = "update_time";
    protected final String CREATE_TIME = "create_time";
    protected final String OPERATOR_ID = "operator_id";

    private String deleteFilterSqlTableName = " 1=1 ";
    private boolean updateTimeExist = false;
    private boolean createTimeExist = false;
    private boolean deletedExist = false;
    private boolean operatorIdExist = false;

    @Autowired
    protected CommonMysqlClient commonMysqlClient;

    @SuppressWarnings("unchecked")
    public BaseDao() {
        this.poClassType = ((Class<PO>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
        this.boClassType = ((Class<BO>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[2]));
        this.poFields = getFields(poClassType);
        this.boFields = getFields(boClassType);

        if (poClassType.isAnnotationPresent(Table.class)) {
            Table table = poClassType.getAnnotation(Table.class);
            String schema = table.schema();
            String tableName = table.name();
            if (schema == null || schema.length() < 1) {
                schema = "";
            } else {
                schema = "`" + schema + "`.";
            }
            if (tableName.length() < 1) {
                this.TABLE_NAME = camelToUnderLine(poClassType.getSimpleName());
            } else {
                this.TABLE_NAME = tableName;
            }

            this.FULL_TABLE_NAME = schema + "`" + TABLE_NAME + "`";

        } else {
            this.TABLE_NAME = camelToUnderLine(poClassType.getSimpleName());
            this.FULL_TABLE_NAME = "`" + TABLE_NAME + "`";
        }


        FROM_SQL = "  from  " + FULL_TABLE_NAME + "  " + TABLE_NAME + " ";
        TABLE_POINT = " " + TABLE_NAME + ".";

        this.poColumnName = new String[poFields.length];
        this.boColumnName = new String[boFields.length];


        //to reduce probability of hash colliding,
        this.poFieldNameMap = new HashMap<>(3 * poFields.length);
        this.boFieldNameMap = new HashMap<>(3 * boFields.length);


        noUpdateColumns = new HashSet<>(9);
        noUpdateColumns.add(ID);
        noUpdateColumns.add(CREATE_TIME);
        noUpdateColumns.add(DELETED);

        timeColumns = new HashSet<>(7);
        timeColumns.add(CREATE_TIME);
        timeColumns.add(UPDATE_TIME);


        StringBuilder allColumns = new StringBuilder();
        StringBuilder insertSql = new StringBuilder("INSERT INTO ").append(FULL_TABLE_NAME).append(" (");
        StringBuilder valueSql = new StringBuilder("VALUES (");
        StringBuilder updateSql = new StringBuilder("UPDATE ").append(FULL_TABLE_NAME).append(" SET ");

        Field field;
        for (int i = 0; i < poFields.length; i++) {
            field = poFields[i];
            field.setAccessible(true);
            poColumnName[i] = getFieldColumnName(field);
            //init index of columns name
            poFieldNameMap.put(poColumnName[i], field);
            if (DELETED.equals(poColumnName[i])) {
                deleteFilterSqlTableName = TABLE_POINT + "deleted = 0 ";
                deletedExist = true;
            }
            if (UPDATE_TIME.equals(poColumnName[i])) {
                updateTimeExist = true;
            }
            if (CREATE_TIME.equals(poColumnName[i])) {
                createTimeExist = true;
            }
            if (OPERATOR_ID.equals(poColumnName[i])) {
                operatorIdExist = true;
            }


            if (!noUpdateColumns.contains(poColumnName[i])) {
                updateSql.append(poColumnName[i]).append(" =?,");
            }

            //sample  "po.id "
            allColumns.append(TABLE_POINT).append(poColumnName[i]).append(" ").append(poColumnName[i]);
            //sample "po_id "
            //allColumns.append(poColumnName[i]).append(" ");

            if (i < poFields.length - 1) {
                allColumns.append(", ");
            }

            //generate insertSql and whereSqk
            if (!field.getName().equals(ID)) {
                insertSql.append(" `").append(poColumnName[i]).append("` ");

                if (poColumnName[i].equals(DELETED)) {
                    valueSql.append("0");
                } else {
                    valueSql.append("?");
                }
                if (i < poFields.length - 1) {
                    valueSql.append(", ");
                    insertSql.append(", ");
                } else {
                    insertSql.append(" ) ");
                    valueSql.append(" );");
                }
            }

        }

        BASE_COLUMN = allColumns.toString();
        INSERT_SQL = insertSql.append(valueSql).toString();
        UPDATE_SQL = updateSql.deleteCharAt(updateSql.length() - 1).toString();
        SELECT_ALL_FROM_SQL = "SELECT " + BASE_COLUMN + FROM_SQL;

        for (int i = 0; i < boFields.length; i++) {
            boFields[i].setAccessible(true);
            boColumnName[i] = getFieldColumnName(boFields[i]);
            boFieldNameMap.put(boColumnName[i], boFields[i]);
        }

    }


    private String getFieldColumnName(Field field) {
        field.setAccessible(true);
        if (field.isAnnotationPresent(Column.class)) {
            //init columns name of po
            Column column = field.getAnnotation(Column.class);
            if (column.name().length() > 0) {
                return column.name();
            } else {
                //init columns name of po
                return camelToUnderLine(field.getName());
            }
        }
        //init columns name of po
        return camelToUnderLine(field.getName());
    }

    private Object getValue(PO po, String column) {
        try {
            poFieldNameMap.get(column).setAccessible(true);
            return poFieldNameMap.get(column).get(po);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    private void setValue(PO po, String column, Object vakue) {
        try {
            poFieldNameMap.get(column).setAccessible(true);
            poFieldNameMap.get(column).set(po, vakue);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage());
        }
    }

    private Field[] getFields(Class<?> clazzType) {
        List<Field> fieldList = new LinkedList<>();
        Field[] fields;
        while (true) {
            fields = clazzType.getDeclaredFields();
            for (Field field : fields) {
                //marked static or final fields will not seem as table column
                if (Modifier.isStatic(field.getModifiers())
                        || Modifier.isFinal(field.getModifiers())) {
                    continue ;
                } else if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    if (column.insertable() == false) {
                        continue;
                    }
                }
                fieldList.add(field);

            }
            if (clazzType.getSuperclass() != null
                    && !clazzType.equals(Object.class)) {
                clazzType = clazzType.getSuperclass();
            } else {
                break;
            }
        }
        return fieldList.toArray(new Field[]{});
    }

    private String camelToUnderLine(String s) {
        final String UNDER_LINE = "_";
        StringBuilder camelCase = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                if (i != 0) {
                    camelCase.append(UNDER_LINE);
                }
                camelCase.append(Character.toLowerCase(s.charAt(i)));
            } else {
                camelCase.append(s.charAt(i));
            }
        }
        return camelCase.toString();
    }


    /**
     * 处理ORM
     *
     * @param resultSet resultSet
     * @param po        bo
     */
    private void handleMapping(ResultSet resultSet, PO po) throws SQLException {
        Field field;
        try {
            for (int i = 0; i < poColumnName.length; i++) {
                field = poFields[i];
                //close permission validation to enhance performance
                field.setAccessible(true);

                if (field.getType() == Integer.class) {
                    field.set(po, resultSet.getInt(poColumnName[i]));
                }
                if (field.getType() == String.class) {
                    field.set(po, resultSet.getString(poColumnName[i]));
                }
                if (field.getType() == Date.class) {
                    field.set(po, resultSet.getTimestamp(poColumnName[i]));
                }
                if (field.getType() == Long.class) {
                    field.set(po, resultSet.getLong(poColumnName[i]));
                }
                if (field.getType() == Double.class) {
                    field.set(po, resultSet.getDouble(poColumnName[i]));
                }
                if (field.getType() == BigDecimal.class) {
                    field.set(po, resultSet.getBigDecimal(poColumnName[i]));
                }

            }
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public int saveSelective(final PO po) {
        StringBuilder insertSql = new StringBuilder("insert into " + FULL_TABLE_NAME + "( ");
        final List<Object> values = new ArrayList<>(poFields.length);
        Object value;
        Field field;
        String columnName;
        for (int i = 0; i < poFields.length; ++i) {
            field = poFields[i];
            field.setAccessible(true);
            columnName = poColumnName[i];
            if (ID.equals(columnName)) {
                continue;
            }
            try {
                value = field.get(po);
            } catch (IllegalAccessException e) {
                logger.error(e.getMessage());
                continue;
            }
            if (value == null) {
                continue;
            }
            insertSql.append(columnName);
            values.add(value);
            insertSql.append(",");
        }
        insertSql.deleteCharAt(insertSql.length() - 1);
        insertSql.append(") values ").append(SQLUtil.sizeToUnknown(values.size()));
        final String insertSqlStr = insertSql.toString();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        commonMysqlClient.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(insertSqlStr, Statement.RETURN_GENERATED_KEYS);
                for (int i = 1; i <= values.size(); i++) {
                    ps.setObject(i, values.get(i - 1));
                }
                return ps;
            }
        }, keyHolder);
        int id = keyHolder.getKey().intValue();
        setValue(po, "id", id);
        return id;
//        return commonMysqlClient.insertAndGetKey();
    }

    /**
     * @param po po
     * @return id
     * @deprecated 建议使用  saveSelective   方法替代
     */
    @Deprecated
    public int save(final PO po) {
        // final PO po = boToPo(bo);
        if(po==null || getValue(po,"id")!=null){
            return 0;
        }
        initNotNull(po);
        int id = commonMysqlClient.insertAndGetKey(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
                try {
                    int index = 1;
                    Object value;
                    for (int i = 0; i < poFields.length; i++) {
                        if ((value = poFields[i].get(po)) != null) {
                            if (poFields[i].getType() == String.class) {
                                ps.setString(index++, (String) value);
                            }
                            if (poFields[i].getType() == Integer.class) {
                                if (!poColumnName[i].equals("id")
                                        && !poColumnName[i].equals("deleted")) {
                                    ps.setInt(index++, (Integer) value);
                                }
                            }
                            if (poFields[i].getType() == Long.class) {
                                ps.setLong(index++, (Long) value);
                            }
                            if (poFields[i].getType() == Double.class) {
                                ps.setDouble(index++, (Double) value);
                            }
                            if (poFields[i].getType() == BigDecimal.class) {
                                ps.setBigDecimal(index++, (BigDecimal) value);
                            }
                            if (poFields[i].getType() == Boolean.class) {
                                ps.setBoolean(index++, (Boolean) value);
                            }
                            if (poFields[i].getType() == Byte.class) {
                                ps.setByte(index++, (Byte) value);
                            }
                            if (poFields[i].getType() == Float.class) {
                                ps.setFloat(index++, (Float) value);
                            }
                            if (poFields[i].getType() == Date.class) {
                                if (timeColumns.contains(poColumnName[i])) {
                                    ps.setTimestamp(index++, getCurrentTime());
                                } else {
                                    ps.setTimestamp(index++, new Timestamp(((Date) value).getTime()));
                                }
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    logger.error(e.getMessage());
                }

                return ps;
            }
        });
        setValue(po, "id", id);
        return id;
    }

    protected void initNotNull(PO po) {
        try {
            for (int i = 0; i < poFields.length; i++) {
                if (poFields[i].get(po) == null) {
                    if (poFields[i].getType() == String.class) {
                        poFields[i].set(po, "");
                    }

                    if (poFields[i].getType() == Date.class) {
                        if (timeColumns.contains(poColumnName[i])) {
                            poFields[i].set(po, getCurrentTime());
                        } else {
                            //default time  '1970-01-01 00:00:00'
                            //for time zone
                            poFields[i].set(po, new Timestamp(-28800000));
                        }
                    }

                    if (poFields[i].getType() == Long.class) {
                        poFields[i].set(po, 0L);
                    }

                    if (poFields[i].getType() == Double.class) {
                        poFields[i].set(po, 0.0);
                    }

                    if ((poFields[i].getType() == Integer.class
                            || poFields[i].getType() == Byte.class
                            || poFields[i].getType() == Short.class)
                            && !poColumnName[i].equals(ID)) {
                        poFields[i].set(po, 0);
                    }

                    if (poFields[i].getType() == Float.class) {
                        poFields[i].set(po, 0.0F);
                    }

                    if (poFields[i].getType() == Boolean.class) {
                        poFields[i].set(po, false);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage());
        }
    }

    public int updateById(PO po) {
        // PO po = boToPo(bo);
        if (po == null
                || getValue(po, "id") == null) {
            return 0;
        }
        StringBuilder updateSql = new StringBuilder("");
        //params
        List<Object> para = new ArrayList<>();
        //处理update条件
        handleUpdateInfo(updateSql, po, para);
        if (updateSql.length() == 0) {
            return 0;
        }
        //sql  simple " UPDATE notice SET "
        String sql = "UPDATE " + FULL_TABLE_NAME + " SET " + updateSql + " WHERE id = ? ";

        para.add(getValue(po, "id"));
        return commonMysqlClient.update(sql, para.toArray());
    }


    /**
     * 根据指定字段更新
     *
     * @param bo        bo
     * @param whereList where list
     * @return count
     */
    public int updateByColumn(PO po, Collection<String> whereList) {
        //PO po = boToPo(bo);
        StringBuilder updateSql = new StringBuilder("");
        //params
        List<Object> para = new ArrayList<>();
        //处理update条件
        handleUpdateInfo(updateSql, po, para);
        if (updateSql.length() == 0) {
            return 0;
        }
        StringBuilder whereSql = new StringBuilder(" WHERE 1=1 ");
        handleWhereInfoFromList(po, para, whereSql, whereList);
        String sql = "UPDATE " + FULL_TABLE_NAME + " SET " + updateSql + whereSql.toString();
        return commonMysqlClient.update(sql, para.toArray());
    }

    /**
     * give a where
     *
     * @param para para
     * @param map  map
     */
    protected void handleWhereInfoFromList(PO po, List<Object> para, StringBuilder whereSql, Collection<String> where) {
        Object o = null;
        for (String s : where) {
            if (poFieldNameMap.get(s) != null
                    && ((o = getValue(po, s)) != null)) {
                whereSql.append(" and ").append(TABLE_POINT).append(s).append(" = ? ");
                para.add(o);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public List<BO> getListByCondition(PO co) {
        String  querySql = SELECT_ALL_FROM_SQL + getWhereSql(co);
        return commonMysqlClient.query(querySql, getPara(co), new BaseDaoRowMapper());
    }

    /**
     * @param co         co
     * @param enableNull true: can null , false: not null
     * @return sample "advert.abc=? and advert.edf=?;"
     */
    private String getWhereSql(PO co) {
        if (co == null) {
            return "where 1=2";
        }
        StringBuilder whereSql = new StringBuilder(" where 1=1  ");
        if (deletedExist) {
            whereSql.append(" and " + FULL_TABLE_NAME + ".deleted = 0 ");
        }
        try {
            for (int i = 0; i < poFields.length; i++) {
                poFields[i].setAccessible(true);
                //logic will be too complex if two if condition combined
                //so split it to two if statement
                //if enableNull is false,only the value of filed is not null can be append in where sql
                if (poFields[i].get(co) != null) {
                    //excluded 'deleted' filed ,for the default query option is 'deleted=0'
                    if (!poColumnName[i].equals("deleted")) {
                        whereSql.append("  and ").append(TABLE_POINT).append(poColumnName[i]).append(" =?  ");
                    }
                }
            }

        } catch (IllegalAccessException e) {
            logger.error(e.getMessage());
        }
        return whereSql.toString();
    }


    /**
     * @param co         co
     * @param enableNull true:all para, false:not null
     * @return [value1, value2]
     */
    private List<Object> getParaList(PO co) {
        if (co == null) {
            return new ArrayList<>();
        }
        List<Object> objectList = new ArrayList<>(poFields.length);
        try {
            for (Field coField : poFields) {
                coField.setAccessible(true);
                if (coField.get(co) != null) {
                    objectList.add(coField.get(co));
                }
            }
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage());
        }
        return objectList;
    }

    private Object[] getPara(PO co) {
        return getParaList(co).toArray();
    }


    public int countByCondition(PO po) {
        //sql
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) AS count " + FROM_SQL).append(getWhereSql(po));
        //params
        Object[] para = getPara(po);
        sql.append(";");
        //step 3:查询结果集
        Map<String, Object> queryForMap = commonMysqlClient.queryForMap(sql.toString(), para);

        return MapUtils.getIntValue(queryForMap, "count");
    }


    public int deleteById(Integer id, Integer operatorId) {
        String deleteSql = "UPDATE " + FULL_TABLE_NAME + " SET deleted = 1 ";
        List paras = new LinkedList();
        if (operatorIdExist && operatorId != null) {
            deleteSql+=", operator_id = ? ";
            paras.add(operatorId);
        }
        if (updateTimeExist) {
            deleteSql += " , update_time = ? ";
            paras.add(getCurrentTime());
        }
        deleteSql += " WHERE id = ?  ";
        paras.add(id);
        return commonMysqlClient.update(deleteSql, paras.toArray());
    }


    @SuppressWarnings("unchecked")
    public BO getById(Integer id) {
        String sql = SELECT_ALL_FROM_SQL + " WHERE " + deleteFilterSqlTableName +
                " and " + TABLE_POINT + "id = ?;";
        List<BO> sqlResult = commonMysqlClient.query(sql, new Object[]{id}, new BaseDaoRowMapper());
        return sqlResult.size() == 0 ? null : sqlResult.get(0);
    }

    @SuppressWarnings("unchecked")
    public BO getByKeyValue(Object... values) {
        if (values.length == 0 || values.length % 2 != 0) {
            return null;
        }
        List<BO> boList = getListByKeyValue(values);
        if (boList.size() < 1) {
            return null;
        }
        return boList.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<BO> getListByKeyValue(Object... values) {
        if (values.length == 0 || values.length % 2 != 0) {
            return Lists.newArrayList();
        }
        StringBuilder whereSql = new StringBuilder(" 1= 1 ");
        Object value;
        List<Object> paras = Lists.newLinkedList();
        for (int i = 0; i < values.length / 2; ++i) {
            whereSql.append(" and ").append(TABLE_POINT).append("`").append(values[2 * i]).append("`");
            value = values[2 * i + 1];
            if (value instanceof Collection) {
                paras.addAll((Collection) value);
                whereSql.append(" in ").append(SQLUtil.sizeToUnknown(((Collection) value).size()));
            } else {
                paras.add(value);
                whereSql.append("=? ");
            }
        }
        String sql = SELECT_ALL_FROM_SQL + " WHERE " + deleteFilterSqlTableName +
                " and " + whereSql.toString();
        List<BO> sqlResult = commonMysqlClient.query(sql, paras.toArray(), new BaseDaoRowMapper());
        return sqlResult;
    }


    @SuppressWarnings("unchecked")
    public List<BO> getListByIds(Collection<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return new ArrayList<>();
        }
        final String para = SQLUtil.sizeToUnknown(ids.size());
        final String querySql = "SELECT " + BASE_COLUMN + FROM_SQL + " where " + deleteFilterSqlTableName +
                " and " + TABLE_POINT + "id in " + para + ";";
        return commonMysqlClient.query(querySql, ids.toArray(), new BaseDaoRowMapper());
    }

    public <T extends PO> int[] batchSave(Collection<T> boList) {
        // List<PO> poList = listBoToPo(boList);
        Iterator<T> it = boList.iterator();
        PO poTmp = null;
        while (it.hasNext()) {
            poTmp = it.next();
            if (getValue(poTmp, ID) != null) {
                it.remove();
            } else {
                initNotNull(poTmp);
            }
        }
        List<Object[]> paramsList = new ArrayList<>();
        for (PO po : boList) {
            initNotNull(po);
            paramsList.add(getInsertParasValues(po));
        }
        return commonMysqlClient.batchInsert(INSERT_SQL, paramsList);
    }

    public <T extends PO> int[] batchSaveSelective(Collection<T> poList) {

        if (CollectionUtils.isEmpty(poList)) {
            return new  int[0];
        }
        List<Object[]> paramsList = new ArrayList<>();

        StringBuilder insertSqlBuilder = new StringBuilder(300);
        insertSqlBuilder.append(" insert into " + TABLE_NAME + "  ( ");
        StringBuilder valuesSqlBuilder = new StringBuilder(100);
        valuesSqlBuilder.append(" VALUES ( ");
        int fieldIndex = 0;
        int poIndex = 0;
        int paraIndex = 0;
        boolean isBeforeId = true;
        boolean isFirstValue = true;
        Object value;
        List<List<Object>> paraList = new ArrayList<>(poList.size());
        List<Object> para = null;
        Boolean isAllNull;
        String columnName;
        Field poField;
        try {
            for (int i = 0, poFieldsLength = poFields.length; i < poFieldsLength; i++) {
                poField = poFields[i];
                columnName = poColumnName[i];

                if(ID.equals(columnName)){
                    continue;
                }
                poField.setAccessible(true);
                poIndex = 0;
                isAllNull = null;
                for (T t : poList) {
                    if (poIndex < paraList.size()) {
                        para = paraList.get(poIndex);
                    } else {
                        para = new LinkedList<>();
                        paraList.add(para);
                    }
                    poIndex++;
                    value = poField.get(t);
                    if (isAllNull == null) {
                        isAllNull = (value == null);
                    }
                    if ((!isAllNull && value == null) || (isAllNull && value != null)) {
                        throw new RuntimeException("字段: " + columnName + " 部分有值部分为null");
                    }
                    if (!isAllNull && value != null) {
                        para.add(value);
                    }
                }

                if (isAllNull != null && !isAllNull) {
                    if (isFirstValue) {
                        isFirstValue = false;
                    } else {
                        insertSqlBuilder.append(" , ");
                        valuesSqlBuilder.append(" , ");
                    }
                    insertSqlBuilder.append(columnName);
                    valuesSqlBuilder.append(" ? ");
                }

            }
            insertSqlBuilder.append(" ) ");
            valuesSqlBuilder.append(") ; ");

            insertSqlBuilder.append(valuesSqlBuilder);

            for (List<Object> objects : paraList) {
                paramsList.add(objects.toArray());
            }
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        String insertSql = insertSqlBuilder.toString();
        logger.info(insertSql);;
        return commonMysqlClient.batchInsert(insertSql, paramsList);

    }
    private Object[] getInsertParasValues(PO po) {
        List<Object> values = new ArrayList<>(poFields.length);
        int index = 0;
        try {
            for (int i = 0; i < poFields.length; i++) {
                poFields[i].setAccessible(true);
                if (!poColumnName[i].equals(ID)
                        && !poColumnName[i].equals(DELETED)) {
                    if (timeColumns.contains(poColumnName[i])) {
                        values.add(getCurrentTime());
                    } else {
                        values.add(poFields[i].get(po));
                    }
                }
            }
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage());
        }
        return values.toArray();
    }

    /**
     * @param po            po
     * @param whereVariable whereVariable
     * @return para [a,b,c,d]
     */
    private Object[] getUpdateValues(PO po, List<String> whereVariable) {
        List<Object> para = new ArrayList<>(poFields.length + whereVariable.size());
        try {
            for (int i = 0; i < poFields.length; i++) {
                if (!noUpdateColumns.contains(poColumnName[i])
                        && !whereVariable.contains(poColumnName[i])) {
                    if (poColumnName[i].equals(UPDATE_TIME)) {
                        para.add(getCurrentTime());
                    } else {
                        para.add(poFields[i].get(po));
                    }
                }
            }
            for (String aWhereVariable : whereVariable) {
                para.add(getValue(po, aWhereVariable));
            }

        } catch (IllegalAccessException e) {
            logger.error(e.getMessage());
        }
        return para.toArray();
    }


    private BO poToBo(PO po) {
        try {
            BO bo = boClassType.newInstance();
            for (int j = 0; j < poFields.length; j++) {
                boFieldNameMap.get(poColumnName[j]).set(bo, poFields[j].get(po));
            }
            return bo;
        } catch (IllegalAccessException | InstantiationException e) {
            logger.error(e.getMessage());
            return null;
        }

    }

    public <T extends PO> int batchUpdateById(Collection<T> poList) {
        if (CollectionUtils.isEmpty(poList)) {
            return 0;
        }
        String updateDirectorySql = UPDATE_SQL + " WHERE id = ?;";
        List<Object[]> paramsList = new ArrayList<>();
        List<String> whereVariable = new ArrayList<>(1);
        whereVariable.add("id");
        for (PO po : poList) {
            initNotNull(po);
            paramsList.add(getUpdateValues(po, whereVariable));
        }
        return commonMysqlClient.batchUpdate(updateDirectorySql, paramsList).length;
    }

    public <T extends PO> int batchUpdateByIdSelective(Collection<T> poList) {
        if (CollectionUtils.isEmpty(poList)) {
            return 0;
        }
        List<Object[]> paramsList
                = new ArrayList<>();
        List<String> whereVariable = new ArrayList<>(1);
        whereVariable.add("id");
        StringBuilder updateSqlBuilder = new StringBuilder(300);
        updateSqlBuilder.append("update " + TABLE_NAME + "  set ");
        int fieldIndex = 0;
        int poIndex = 0;
        int paraIndex = 0;
        boolean isBeforeId = true;
        boolean isFirstValue = true;
        Object value;
        List<List<Object>> paraList = new ArrayList<>(poList.size());
        List<Object> para = null;
        Boolean isAllNull;
        String columnName;
        Field poField;
        try {
            for (int i = 0, poFieldsLength = poFields.length; i < poFieldsLength; i++) {
                poField = poFields[i];
                columnName = poColumnName[i];
                poField.setAccessible(true);
                poIndex = 0;
                isAllNull = null;
                for (T t : poList) {
                    if (poIndex < paraList.size()) {
                        para = paraList.get(poIndex);
                    } else {
                        para = new LinkedList<>();
                        paraList.add(para);
                    }
                    poIndex++;
                    value = poField.get(t);
                    if (columnName.equals(ID)) {
                        if (value == null) {
                            throw new RuntimeException(" id 不能为null");
                        }
                        para.add(value);
                        isBeforeId = false;
                        continue;
                    }
                    if (isAllNull == null) {
                        isAllNull = (value == null);
                    }
                    if ((!isAllNull && value == null) || (isAllNull && value != null)) {
                        throw new RuntimeException("字段: " + columnName + " 部分有值部分为null");
                    }
                    if (!isAllNull && value != null) {
                        if (isBeforeId) {
                            para.add(value);
                        } else {
                            para.add(para.size() - 1, value);
                        }
                    }
                }

                if (isAllNull != null && !isAllNull) {
                    if (isFirstValue) {
                        isFirstValue = false;
                    } else {
                        updateSqlBuilder.append(" , ");
                    }
                    updateSqlBuilder.append(columnName + " = ? ");
                }

            }
            updateSqlBuilder.append(" where id =? ");
            for (List<Object> objects : paraList) {
                paramsList.add(objects.toArray());
            }
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return commonMysqlClient.batchUpdate(updateSqlBuilder.toString(), paramsList).length;
    }


    /**
     *
     * @param boList        boList
     * @param whereVariable whereVariable
     * @return n
     */
    public int batchUpdateByColumns(List<? extends PO> poList, List<String> whereVariable) {
        //List<PO> poList = listBoToPo(boList);
        List<Object[]> paramsList = new ArrayList<>();
        String updateSql = getUpdateSql(whereVariable) + getWhereSql(whereVariable);
        for (PO po : poList) {
            initNotNull(po);
            paramsList.add(getUpdateValues(po, whereVariable));
        }
        return commonMysqlClient.batchUpdate(updateSql, paramsList).length;

    }

    protected String getUpdateSql(List<String> columns) {
        StringBuilder updateSql = new StringBuilder("UPDATE  ").append(FULL_TABLE_NAME).append("  SET ");
        for (int i = 0; i < poFields.length; i++) {
            if (!noUpdateColumns.contains(poColumnName[i])
                    && !columns.contains(poColumnName[i])) {
                updateSql.append("  ").append(poColumnName[i]).append("  =?,");
            }
        }
        return updateSql.deleteCharAt(updateSql.length() - 1).toString();
    }

    protected String getWhereSql(List<String> columns) {
        StringBuilder whereSql = new StringBuilder(" where 1=1 ");
        for (String column : columns) {
            whereSql.append(" and ").append(column).append(" =? ");
        }
        whereSql.deleteCharAt(whereSql.length() - 1);
        whereSql.append(";");
        return whereSql.toString();
    }

    public int batchDeleteById(Collection<Integer> ids, Integer operatorId) {
        String batchDeleteSqll = "UPDATE " + FULL_TABLE_NAME + " SET deleted=1, operator_id=? ";
        List paras = new LinkedList();
        paras.add(operatorId);
        if (updateTimeExist) {
            batchDeleteSqll += ", update_time=? ";
            paras.add(getCurrentTime());
        }
        batchDeleteSqll += " WHERE id = ?;";
        List<Object[]> paramsList = new ArrayList<>();
        for (Integer id : ids) {
            paras.add(id);
            paramsList.add(paras.toArray());
            paras.remove(paras.size() - 1);
        }
        return commonMysqlClient.batchUpdate(batchDeleteSqll, paramsList).length;
    }


    @SuppressWarnings("unchecked")
    public List<BO> getListByIds(Integer... ids) {
        final String para = SQLUtil.sizeToUnknown(ids.length);
        final String querySql = SELECT_ALL_FROM_SQL + " where " + deleteFilterSqlTableName + " and " + TABLE_POINT + "id in " + para + ";";
        return commonMysqlClient.query(querySql, ids, new BaseDaoRowMapper());
    }

    public Page<BO> getPageByCondition(PO co, PageParam pageParam) {

        return getPageByCondition(co, pageParam, null);
    }
    /**
     * @param co       co
     * @param pageParam pageInfo
     * @return Page<Po>
     */
    @SuppressWarnings("unchecked")
    public Page<BO> getPageByCondition(PO co, PageParam pageParam, QueryEnhance queryEnhance) {
        if (pageParam == null) {
            pageParam = new PageParam(defaultPageNumber, defaultPageSize, defaultSortOrder);
        }
        StringBuilder selectSql = new StringBuilder("select ").append(BASE_COLUMN);
        StringBuilder fromSql = new StringBuilder(FROM_SQL);
        StringBuilder whereSql = new StringBuilder(getWhereSql(co));
        StringBuilder orderSql = new StringBuilder(" ORDER BY ");

        List<Object> paras = getParaList(co);
        BaseDaoRowMapper mapper = new BaseDaoRowMapper();
        if (queryEnhance != null) {
            if (queryEnhance.getSelectSql() != null) {
                selectSql.append(", ").append(queryEnhance.getSelectSql());
            }
            if (queryEnhance.getJoinSql() != null) {
                fromSql.append(queryEnhance.getJoinSql());
            }
            if (queryEnhance.getWhereSql() != null) {
                whereSql.append(queryEnhance.getWhereSql());
                if (queryEnhance.getWhereParam() != null
                        && queryEnhance.getWhereParam().size() > 0) {
                    paras.addAll(queryEnhance.getWhereParam());
                }
            }
            if (queryEnhance.getOrderSql() != null) {
                orderSql.append(queryEnhance.getOrderSql());
            }
            if (queryEnhance.getObjectAssembler() != null) {
                mapper.setObjectAssembler(queryEnhance.getObjectAssembler());
            }
        }
        getSqlByPageInfo(pageParam, orderSql);
        String querySql = selectSql.append(fromSql).append(whereSql).append(orderSql).toString();

        logger.info(querySql);
        List<BO> boList = commonMysqlClient.query(querySql, paras.toArray(), mapper);
        //查询总记录数
        int rows = countByCondition(co);
        //封装返回值
        Page<BO> resultData = new Page<>();

        if (pageParam.getPageSize() == null) {
            pageParam.setPageSize(defaultPageSize);
        }
        int pageCount = (rows + pageParam.getPageSize() - 1) / pageParam.getPageSize();
        int pageNum = pageParam.getPageNum();
        if (pageNum > pageCount) {
            pageNum = pageParam.getPageNum() - 1; // 页码
        }
        resultData.setPageNum(pageNum); //页码
        resultData.setPageSize(pageParam.getPageSize()); //每页数据量
        resultData.setPageTotal(pageCount); //总页数

        resultData.setList(boList); //分页数据
        resultData.setItemTotal(rows); //总记录数
        return resultData;
    }

    protected Timestamp getCurrentTime() {
        return new Timestamp(new Date().getTime());
    }

//    /**
//     * @param co
//     * @param pageInfo
//     * @return
//     */
//    public int countByPage(PO co, PageParam pageInfo) {
//        final boolean enableNull = false;
//        String querySql = "SELECT COUNT(DISTINCT " + FULL_TABLE_NAME + ".id) AS count " + FROM_SQL + getWhereSql(co) + getSqlByPageInfo(pageInfo);
//        //step 3:查询结果集
//        Map<String, Object> queryForMap = commonMysqlClient.queryForMap(querySql, getPara(co));
//        return MapUtils.getIntValue(queryForMap, "count");
//    }

    /**
     * 处理排序条件
     *
     * @param pageInfo pageInfo
     * @return sample " ORDER BY ${poAliasName}.id"
     */
    protected String getSqlByPageInfo(PageParam pageInfo, StringBuilder orderBy) {
        if (pageInfo == null) {
            return "";
        }
        String sortSql = "";
        if (pageInfo.getSortOrder() != null
                && SortTypeEnum.getSqlBySortId(pageInfo.getSortOrder()) != null) {
            sortSql += (TABLE_POINT+SortTypeEnum.getSqlBySortId(pageInfo.getSortOrder()));
        }
        if (pageInfo.getOrderBy() != null && pageInfo.getOrderBy().length() > 4) {
            if (sortSql != null && sortSql.length() > 4) {
                sortSql += ",";
            }
            sortSql += pageInfo.getOrderBy();
        }

        if (sortSql.length() < 1) {
            sortSql = SortTypeEnum.getSqlBySortId(defaultSortOrder);
        }

        if (pageInfo.getPageSize() == null
                || pageInfo.getPageSize() < 0) {
            pageInfo.setPageSize(defaultPageSize);
        }

        if (pageInfo.getPageNum() == null
                || pageInfo.getPageNum() < 1) {
            pageInfo.setPageNum(defaultPageNumber);
        }
        if (!sortSql.isEmpty()) {
            if (orderBy.length() > 13) {
                orderBy.append(" , ");
            }
            orderBy.append(sortSql);
        }
        orderBy.append(" limit ").append((pageInfo.getPageNum() - 1) * pageInfo.getPageSize()).append(",").append(pageInfo.getPageSize());

        return orderBy.toString();
    }


    /**
     * 处理修改信息
     *
     * @param sql  sql
     * @param po   PO class instance
     * @param para para
     */
    private void handleUpdateInfo(StringBuilder sql, PO po, List<Object> para) {

        Field field;
        boolean firstPara = true;
        try {
            for (int i = 0; i < poFields.length; i++) {
                field = poFields[i];
                //close permission validation to enhance performance
                field.setAccessible(true);

                if (!noUpdateColumns.contains(poColumnName[i])
                        && !poColumnName[i].equals(UPDATE_TIME)
                        && field.get(po) != null) {
                    if (!firstPara) {
                        sql.append(", ");
                    }
                    sql.append(poColumnName[i]).append(" = ? ");
                    para.add(field.get(po));
                    firstPara=false;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (updateTimeExist && !firstPara) {
            sql.append(" ,update_time = ? "); //更新时间
            para.add(getCurrentTime());
        }
    }



    /**
     * 处理ORM
     */
    public class BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper<BO> {

        private ObjectAssembler<BO> objectAssembler;

        public BaseDaoRowMapper(ObjectAssembler<BO> objectAssembler) {
            this.objectAssembler = objectAssembler;
        }

        public BaseDaoRowMapper() {

        }

        public ObjectAssembler<BO> getObjectAssembler() {
            return objectAssembler;
        }

        public void setObjectAssembler(ObjectAssembler<BO> objectAssembler) {
            this.objectAssembler = objectAssembler;
        }

        @Override
        public BO mapRow(ResultSet resultSet, int i) throws SQLException {
            try {
                PO po = poClassType.newInstance();
                handleMapping(resultSet, po); //处理ORM
                BO bo = poToBo(po);

                if (objectAssembler != null) {
                    objectAssembler.assemble(resultSet, bo);
                }
                return bo;
            } catch (InstantiationException | IllegalAccessException e) {
                logger.error(e.getMessage());
            }
            return null;
        }
    }
}

