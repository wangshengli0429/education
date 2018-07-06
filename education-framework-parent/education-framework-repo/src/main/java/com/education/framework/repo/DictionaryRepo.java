package com.education.framework.repo;

import com.education.framework.model.bo.DictionaryBo;
import com.education.framework.model.co.DictionaryCo;
import com.education.framework.model.po.Dictionary;
import com.education.framework.repo.base.CommonMysqlClient;
import com.education.framework.repo.base.SQLUtil;
import com.google.common.base.Optional;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class DictionaryRepo {

    @Resource
    private CommonMysqlClient mysqlClient;


    static final String INSERT_SQL = "INSERT into dictionary (`type`,code,`name`,`level`,parent_id,`order`,description,status,create_time,creator_id,update_time,updater_id,deleted)" +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    static final String BASE_COLUMN =  " t.id AS id,t.`type` AS type,t.code AS code," +
            " t.`name` AS name, t.parent_id AS parentId, " +
            " t.`order` AS `order`,t.description AS description, " +
            " t.status AS status, t.level AS level, " +
            " t.create_time AS createTime,t.creator_id AS creatorId, " +
            " t.update_time AS updateTime, t.updater_id AS updaterId ";

    /**
     * 插入单条数据
     * @param dictionary
     * @return
     */
    public int insertAndGetKey(final Dictionary dictionary) {
        final String insertSql = INSERT_SQL;
        return mysqlClient.insertAndGetKey(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, Optional.fromNullable(dictionary.getType()).or(""));
                ps.setString(2,Optional.fromNullable(dictionary.getCode()).or(""));
                ps.setString(3,Optional.fromNullable(dictionary.getName()).or(""));
                ps.setInt(4,Optional.fromNullable(dictionary.getLevel()).or(1));
                ps.setInt(5,Optional.fromNullable(dictionary.getParentId()).or(0));
                ps.setInt(6,Optional.fromNullable(dictionary.getOrder()).or(1));
                ps.setString(7,Optional.fromNullable(dictionary.getDescription()).or(""));
                ps.setInt(8,Optional.fromNullable(dictionary.getStatus()).or(1));
                ps.setTimestamp(9,new Timestamp(new java.util.Date().getTime()));
                ps.setInt(10,Optional.fromNullable(dictionary.getCreatorId()).or(-1));
                ps.setTimestamp(11,new Timestamp(new java.util.Date().getTime()));
                ps.setInt(12,Optional.fromNullable(dictionary.getUpdaterId()).or(-1));
                ps.setInt(13,0);
                return ps;
            }
        });
    }

    /**
     *  批量插入
     * @param dictionaryList
     * @return
     */
    public int[] batchInsert(List<Dictionary> dictionaryList) {
        String insertSql = INSERT_SQL;
        List<Object[]> paramsList = new ArrayList<>();
        for (Dictionary dictionary : dictionaryList) {
            handleDefaultValue(dictionary);
            Object[] params = {dictionary.getType(),dictionary.getCode(),dictionary.getName(),dictionary.getLevel(),dictionary.getParentId(),dictionary.getOrder(),dictionary.getStatus(),dictionary.getDescription(),
                    new Timestamp(new java.util.Date().getTime()),dictionary.getCreatorId(),new Timestamp(new java.util.Date().getTime()),dictionary.getUpdaterId(),0};
            paramsList.add(params);
        }
        return mysqlClient.batchInsert(insertSql, paramsList);
    }

    /**
     * 根据id修改
     * @param dictionary
     * @return
     */
    public int updateById(Dictionary dictionary) {
        List<Object> param = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder("UPDATE dictionary SET ");
        this.handleUpdateInfo(sql,dictionary,param);
        if (null==param || param.size()==0|| param.size()==1){
            return 0;
        }
        sql.append(" WHERE id = ? ");
        param.add(dictionary.getId());
        return mysqlClient.update(sql.toString(), param.toArray());
    }

//    /**
//     * 批量修改
//     * @param dictionaryList
//     * @return
//     */
//    public int batchUpdateById(List<Dictionary> dictionaryList) {
//        String updateDirectorySql = "UPDATE dictionary SET dictionary_type_type=?, code=?, parent_id=?, cn_name=?, en_name=?,idx=?, valid_flag=?,updater_id=?,update_time=? WHERE id = ?;";
//        List<Object[]> paramsList = new ArrayList<>();
//        for (Dictionary dictionary : dictionaryList) {
//            Object[] params = {dictionary.getDictionaryTypeType(),dictionary.getCode(),dictionary.getParentId(),dictionary.getCnName(),dictionary.getCnName(),
//                    dictionary.getIdx(),dictionary.getValidFlag(),dictionary.getUpdaterId(),new Timestamp(new java.util.Date().getTime()),dictionary.getId()};
//            paramsList.add(params);
//        }
//        int effectedRows = mysqlClient.batchUpdate(updateDirectorySql, paramsList).length;
//        return effectedRows;
//    }

    /**
     * 根据id删除
     * @param id
     * @param operatorId
     * @return
     */
    public int deleteById(Integer id, Integer operatorId) {
        String deleteSql = "UPDATE dictionary SET deleted = 1, updater_id = ?, update_time = ? WHERE id = ? ";
        return mysqlClient.update(deleteSql, new Object[]{operatorId, new Timestamp(new java.util.Date().getTime()), id});
    }

    /**
     * 批量删除
     * @param ids
     * @param operatorId
     * @return
     */
    public int batchDeleteById(List<Integer> ids, Integer operatorId) {
        String updateDirectorySql = "UPDATE dictionary SET deleted=1, updater_id=?, update_time=? WHERE id = ?;";
        List<Object[]> paramsList = new ArrayList<>();
        for (Integer id : ids) {
            Object[] params = {operatorId, new Timestamp(new java.util.Date().getTime()), id};
            paramsList.add(params);
        }
        int effectedRows = mysqlClient.batchUpdate(updateDirectorySql, paramsList).length;
        return effectedRows;
    }


    /**
     * 根据id 查询
     * @param id
     * @return
     */
    public DictionaryBo getById(Integer id) {
        String sql = "SELECT "+BASE_COLUMN +
                " FROM dictionary t WHERE t.deleted = 0 AND t.id = ?";
        List<DictionaryBo> sqlResult = mysqlClient.query(sql.toString(), new Object[]{id}, new DictionaryBoRowMapper());
        final DictionaryBo dictionaryBo = sqlResult.size() == 0 ? null : sqlResult.get(0);
        return dictionaryBo;
    }

    /**
     *  根据id集合查询
     * @param ids
     * @return
     */
    public List<DictionaryBo> listByIds(List<Integer> ids) {
        final String para = SQLUtil.sizeToUnknown(ids.size());
        String querySql = "SELECT " + BASE_COLUMN +
                " FROM dictionary t WHERE t.deleted = 0 AND t.id in " + para + "order by t.id;";
        return mysqlClient.query(querySql, ids.toArray(), new DictionaryBoRowMapper());
    }


    /**
     *  根据code集合集合查询
     * @param codes
     * @return
     */
    public List<DictionaryBo> listByCodes(List<String> codes) {
        if (CollectionUtils.isEmpty(codes)){
            return new ArrayList<DictionaryBo>();
        }
        StringBuilder sql = new StringBuilder("SELECT " + BASE_COLUMN + " FROM dictionary t WHERE t.deleted = 0 ");
        sql.append(" and t.code in('");
        sql.append(StringUtils.join(codes,"','"));
        sql.append("');");
        return mysqlClient.query(sql.toString(), new Object[]{}, new DictionaryBoRowMapper());
    }

    /**
     * 根据条件查询
     * @param dictionaryCo
     * @return
     */
    public List<DictionaryBo> listByCondition(DictionaryCo dictionaryCo) {
        //sql
        StringBuilder sql = new StringBuilder("SELECT " + BASE_COLUMN + " FROM dictionary t where t.deleted=0 ");
        //params
        List<Object> parm = new ArrayList<>();
        //处理查询条件
        handleCondition(sql, dictionaryCo, parm);
        //处理排序条件
        handleSort(sql, dictionaryCo);
        //分页条件
        if (dictionaryCo.getPageNum() != null && dictionaryCo.getPageSize() != null) {
            sql.append(" limit " + (dictionaryCo.getPageNum() - 1) * dictionaryCo.getPageSize() + "," + dictionaryCo.getPageSize());
        }
        sql.append(";");
        //执行查询
        List<DictionaryBo> sqlResult = mysqlClient.query(sql.toString(), parm.toArray(), new DictionaryBoRowMapper());
        return sqlResult;
    }


    /**
     * 根据查询条件统计总数
     * @param dictionaryCo
     * @return
     */
    public int countByCondition(DictionaryCo dictionaryCo) {
        //sql
        StringBuilder sql = new StringBuilder("SELECT COUNT(DISTINCT id) AS count FROM dictionary t WHERE t.deleted=0 ");
        //params
        List<Object> parm = new ArrayList<>();
        //处理查询条件
        handleCondition(sql, dictionaryCo, parm);
        sql.append(";");
        //step 3:查询结果集
        Map<String, Object> queryForMap = mysqlClient.queryForMap(sql.toString(), parm.toArray());
        int ret = MapUtils.getIntValue(queryForMap, "count");
        return ret;
    }

    /**
     * 处理排序条件
     *
     * @param sql
     *
     */
    private void handleSort(StringBuilder sql, DictionaryCo dictionaryCo) {
        if (dictionaryCo.getSortOrder() == null) {
            sql.append(" ORDER BY t.order ASC ");
        }
        if (DictionaryCo.ORDER_BY_ID_ASC.equals(dictionaryCo.getSortOrder())) { //按id升序排序
            sql.append(" ORDER BY t.id ASC ");
        } else if (DictionaryCo.ORDER_BY_ID_DESC.equals(dictionaryCo.getSortOrder())) { //按id降序排序
            sql.append(" ORDER BY t.id DESC ");
        } else if (DictionaryCo.ORDER_BY_UPDATE_TIME_ASC.equals(dictionaryCo.getSortOrder())) { //按update_time升序排序
            sql.append(" ORDER BY t.update_time ASC ");
        } else if (DictionaryCo.ORDER_BY_UPDATE_TIME_DESC.equals(dictionaryCo.getSortOrder())) { //按update_time降序排序
            sql.append(" ORDER BY t.update_time DESC ");
        }
    }


    /**
     * 设置默认值
     * @param dictionary
     */
    private void handleDefaultValue(Dictionary dictionary){

        if (null == dictionary.getType()){
            dictionary.setType("");
        }
        if (null == dictionary.getCode()){
            dictionary.setCode("");
        }
        if (null == dictionary.getParentId()){
            dictionary.setParentId(0);
        }
        if (null == dictionary.getName()){
            dictionary.setName("");
        }
        if (null == dictionary.getLevel()){
            dictionary.setLevel(1);
        }
        if (null == dictionary.getOrder()){
            dictionary.setOrder(0);
        }
        if (null == dictionary.getStatus()){
            dictionary.setStatus(1);
        }
        if (null == dictionary.getDescription()){
            dictionary.setDescription("");
        }
        if (null == dictionary.getCreatorId()){
            dictionary.setCreatorId(-1);
        }
        if (null == dictionary.getUpdaterId()){
            dictionary.setUpdaterId(-1);
        }

    }


    /**
     * 处理查询条件
     *
     * @param sql
     * @param dictionaryCo
     * @param parm
     */
    private void handleCondition(StringBuilder sql, DictionaryCo dictionaryCo, List<Object> parm) {

        if(null != dictionaryCo.getId()){
            sql.append(" and t.id = ? ");
            parm.add(dictionaryCo.getId());
        }
        if(null != dictionaryCo.getType()){
            sql.append(" and t.type = ? ");
            parm.add(dictionaryCo.getType());
        }
        if(null != dictionaryCo.getCode()){
            sql.append(" and t.code = ? ");
            parm.add(dictionaryCo.getCode());
        }
        if (StringUtils.isNotBlank(dictionaryCo.getName())){
            sql.append(" and t.cn_name like '%" + dictionaryCo.getName() + "%'");
        }
        if (null != dictionaryCo.getLevel()){
            sql.append(" and t.level = ? ");
            parm.add(dictionaryCo.getLevel());
        }
        if (null != dictionaryCo.getParentId()){
            sql.append(" and t.parent_id = ? ");
            parm.add(dictionaryCo.getParentId());
        }
        if (null != dictionaryCo.getOrder()){
            sql.append(" and t.order = ? ");
            parm.add(dictionaryCo.getOrder());
        }
        if (null != dictionaryCo.getDescription()){
            sql.append(" and t.description = ? ");
            parm.add(dictionaryCo.getDescription());
        }
        if (null != dictionaryCo.getStatus()){
            sql.append(" and t.status = ? ");
            parm.add(dictionaryCo.getStatus());
        }

    }

    /**
     * 处理修改
     * @param sql
     * @param dictionary
     * @param parm
     */
    private void handleUpdateInfo(StringBuilder sql,Dictionary dictionary, List<Object> parm){
        if (null != dictionary.getCode()){
            sql.append(" code = ?,");
            parm.add(dictionary.getCode());
        }
        if(null != dictionary.getType()){
            sql.append(" type = ?, ");
            parm.add(dictionary.getType());
        }
        if(null != dictionary.getName()){
            sql.append(" code = ?, ");
            parm.add(dictionary.getName());
        }
        if (null != dictionary.getLevel()){
            sql.append(" level = ?,");
            parm.add(dictionary.getLevel());
        }
        if (null != dictionary.getParentId()){
            sql.append(" parent_id = ?,");
            parm.add(dictionary.getParentId());
        }
        if (null != dictionary.getOrder()){
            sql.append(" order = ?,");
            parm.add(dictionary.getOrder());
        }
        if (null != dictionary.getDescription()){
            sql.append(" description = ?,");
            parm.add(dictionary.getDescription());
        }
        if (null != dictionary.getStatus()){
            sql.append(" status = ?,");
            parm.add(dictionary.getStatus());
        }
        sql.append(" update_time = ? ");
        parm.add(new Timestamp(new java.util.Date().getTime()));
    }


    /**
     * 处理ORM
     */
    private class DictionaryBoRowMapper implements RowMapper<DictionaryBo> {
        @Override
        public DictionaryBo mapRow(ResultSet resultSet, int i) throws SQLException {
            DictionaryBo dictionaryBo = new DictionaryBo();
            DictionaryMapping(resultSet, dictionaryBo); //处理ORM
            return dictionaryBo;
        }
    }

    /**
     * 处理ORM
     *
     * @param resultSet
     * @param dictionaryBo
     */
    public static void DictionaryMapping(ResultSet resultSet, DictionaryBo dictionaryBo) throws SQLException {
        dictionaryBo.setId(resultSet.getInt("id"));
        dictionaryBo.setType(resultSet.getString("type"));
        dictionaryBo.setCode(resultSet.getString("code"));
        dictionaryBo.setParentId(resultSet.getInt("parentId"));
        dictionaryBo.setName(resultSet.getString("name"));
        dictionaryBo.setLevel(resultSet.getInt("level"));
        dictionaryBo.setOrder(resultSet.getInt("order"));
        dictionaryBo.setStatus(resultSet.getInt("status"));
        dictionaryBo.setDescription(resultSet.getString("description"));
        dictionaryBo.setCreateTime(resultSet.getTimestamp("createTime"));
        dictionaryBo.setCreatorId(resultSet.getInt("creatorId"));
        dictionaryBo.setUpdateTime(resultSet.getTimestamp("updateTime"));
        dictionaryBo.setUpdaterId(resultSet.getInt("updaterId"));
    }

}
