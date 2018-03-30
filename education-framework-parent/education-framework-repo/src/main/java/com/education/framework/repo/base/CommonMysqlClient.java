package com.education.framework.repo.base;


import com.education.framework.repo.jdbc.MyJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChengZhu Liang
 * @CreateTime 16/10/20
 * @note 封装Mysql DataSource 主从实例
 */
public class CommonMysqlClient {

    public static final String GENERATED_KEY = "GENERATED_KEY";

//    private DataSource dataSource;
//    private List<DataSource> dataSourceSlaves;
//    private Random random = new Random();

//    private JdbcTemplate masterJdbcTemplate;
//    private JdbcTemplate[] slaveJdbcTemplateArr;
    @Resource
    private MyJdbcTemplate myJdbcTemplate;

    //1、如果是写操作或者没有配置从库，则读写主库。2、配置主从库时，读从库。3、多从库时，随机读。
//    private JdbcTemplate getJdbcTemplate(boolean isWrite) {
//        if (isWrite || (this.slaveJdbcTemplateArr == null || this.slaveJdbcTemplateArr.length == 0)) {
//            return masterJdbcTemplate;
//        }
//        if (this.slaveJdbcTemplateArr.length == 1) {
//            return slaveJdbcTemplateArr[0];
//        }
//        return this.slaveJdbcTemplateArr[this.random.nextInt(this.dataSourceSlaves.size())];
//    }

    /**
     * 数据库增删改，参数为对象数组
     *
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql, Object[] args) {
        return myJdbcTemplate.update(sql, args);
    }

    /**
     * 数据库增加后返回主键
     *
     * @param preparedStatementCreator
     * @return
     */
    public int insertAndGetKey(PreparedStatementCreator preparedStatementCreator) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        myJdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().intValue();
    }

    /**
     * 数据库增加后返回主键
     *
     * @param preparedStatementCreator
     * @return
     */
    public int update(PreparedStatementCreator preparedStatementCreator, KeyHolder keyHolder) throws DataAccessException {
        myJdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public int update(final String sql) throws DataAccessException {
        return myJdbcTemplate.update(sql);
    }

    /**
     * 批量修改数据库
     *
     * @param sql
     * @param batchPreparedStatementSetter
     * @return
     * @throws DataAccessException
     */
    public int[] batchUpdate(String sql, BatchPreparedStatementSetter batchPreparedStatementSetter) throws DataAccessException {
        return myJdbcTemplate.batchUpdate(sql, batchPreparedStatementSetter);
    }

    /**
     * 批量修改数据库
     *
     * @param sql
     * @param batchArgs
     * @return
     * @throws DataAccessException
     */
    public int[] batchUpdate(String sql, List<Object[]> batchArgs) throws DataAccessException {
        return myJdbcTemplate.batchUpdate(sql, batchArgs);
    }

    /**
     * 批量插入数据
     *
     * @param sql
     * @param batchPreparedStatementSetter
     * @return ids
     * @throws DataAccessException
     */
    public int[] batchInsert(String sql, BatchPreparedStatementSetter batchPreparedStatementSetter) throws DataAccessException {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        myJdbcTemplate.batchUpdate(sql, batchPreparedStatementSetter, keyHolder);
        List<Map<String, Object>> objKeyList = keyHolder.getKeyList();
        if (CollectionUtils.isEmpty(objKeyList)) {
            return new int[0];
        }
        int size = objKeyList.size();
        int[] keys = new int[size];
        for (int i = 0; i < size; i++) {
            keys[i] = Integer.valueOf(String.valueOf((objKeyList.get(i).get(GENERATED_KEY))));
        }
        return keys;
    }

    /**
     * 批量插入数据
     *
     * @param sql
     * @param batchArgs
     * @return ids
     * @throws DataAccessException
     */
    public int[] batchInsert(String sql, List<Object[]> batchArgs) throws DataAccessException {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        myJdbcTemplate.batchUpdate(sql, batchArgs, keyHolder);
        List<Map<String, Object>> objKeyList = keyHolder.getKeyList();
        if (CollectionUtils.isEmpty(objKeyList)) {
            return new int[0];
        }
        int size = objKeyList.size();
        int[] keys = new int[size];
        for (int i = 0; i < size; i++) {
            keys[i] = Integer.valueOf(String.valueOf((objKeyList.get(i).get(GENERATED_KEY))));
        }
        return keys;
    }

    /**
     * 数据库查询，返回结果集list
     *
     * @param sql
     * @param args
     * @param rowMapper
     * @return
     */
    public List queryOnMasterOrSlave(String sql, Object[] args, RowMapper rowMapper, boolean isOnMasterQuery) {
        return myJdbcTemplate.query(sql, args, rowMapper);
    }

    /**
     * 数据库查询，返回结果集list
     *
     * @param sql
     * @param args
     * @param rowMapper
     * @return
     */
    public List query(String sql, Object[] args, RowMapper rowMapper) {
        return myJdbcTemplate.query(sql, args, rowMapper);
    }

    /**
     * 数据库查询，返回结果集List
     *
     * @param sql
     * @param args
     * @return
     * @isOnMasterQuery 当前查询是否在主库上查询, isOnMasterQuery:true,在主库查询,false:在从库查询
     */
    public List query(String sql, Object[] args, RowMapper rowMapper, boolean isOnMasterQuery) {
        return myJdbcTemplate.query(sql, args, rowMapper);
    }

    /**
     * 数据库查询，返回结果集List
     *
     * @param sql
     * @param args
     * @return
     */
    public List<Map<String, Object>> queryForList(String sql, Object[] args) {
        List<Map<String, Object>> resultList = myJdbcTemplate.queryForList(sql, args);
        if (resultList == null) {
            resultList = new ArrayList<Map<String, Object>>();
        }
        return resultList;
    }

    /**
     * 数据库查询，返回结果集List
     *
     * @param sql
     * @param args
     * @return
     * @isOnMasterQuery 当前查询是否在主库上查询, isOnMasterQuery:true,在主库查询,false:在从库查询
     */
    public List<Map<String, Object>> queryForListOnMasterOrSlave(String sql, Object[] args, boolean isOnMasterQuery) {
        List<Map<String, Object>> resultList = myJdbcTemplate.queryForList(sql, args);
        if (resultList == null) {
            resultList = new ArrayList<Map<String, Object>>();
        }
        return resultList;
    }

    /**
     * 数据库查询，返回结果集Map
     *
     * @param sql
     * @param args
     * @return
     */
    public Map<String, Object> queryForMap(String sql, Object[] args) {
        Map<String, Object> resultMap = null;
        try {
            resultMap = myJdbcTemplate.queryForMap(sql, args);
        } catch (EmptyResultDataAccessException e) {
            resultMap = new HashMap<String, Object>();
        }
        return resultMap;
    }

    /**
     * 数据库查询，返回结果
     *
     * @param sql
     * @param requiredType
     * @return
     */
    public <T> T queryForObject(String sql, Class<T> requiredType) throws DataAccessException {
        return myJdbcTemplate.queryForObject(sql, requiredType);
    }

    public <T> T queryForObject(String sql, Object[] args, Class<T> requiredType) throws DataAccessException {
        return myJdbcTemplate.queryForObject(sql, args, requiredType);
    }

    public <T> T queryForObject(String sql, Object[] args, RowMapper<T> rowMapper) throws DataAccessException {
        return myJdbcTemplate.queryForObject(sql, args, rowMapper);
    }

    /**
     * 数据库查询，返回结果集Map
     *
     * @param sql
     * @param args
     * @return
     * @isOnMasterQuery 当前查询是否在主库上查询, isOnMasterQuery:true,在主库查询,false:在从库查询
     */
    public Map<String, Object> queryForMapOnMasterOrSlave(String sql, Object[] args, boolean isOnMasterQuery) {
        Map<String, Object> resultMap = null;
        try {
            resultMap = myJdbcTemplate.queryForMap(sql, args);
        } catch (EmptyResultDataAccessException e) {
            resultMap = new HashMap<String, Object>();
        }
        return resultMap;
    }

    /**
     * 数据库查询，返回原生结果集list<map>
     *
     * @param sql
     * @return
     */
    public List queryList(String sql) {
        return myJdbcTemplate.queryForList(sql);
    }


//    public DataSource getDataSource() {
//        return dataSource;
//    }
//    @Autowired
//    @Required
//    public void setDataSource(DataSource dataSource) {
//        logger.info("mysql init success,dataSource:{}", dataSource);
//        this.dataSource = dataSource;
//        this.masterJdbcTemplate = new JdbcTemplate(this.dataSource);
//    }
//
//    public List<DataSource> getDataSourceSlaves() {
//        return dataSourceSlaves;
//    }
//
//    @Autowired
//    @Required
//    public void setDataSourceSlaves(List<DataSource> dataSourceSlaves) {
//        this.dataSourceSlaves = dataSourceSlaves;
//        slaveJdbcTemplateArr = new JdbcTemplate[dataSourceSlaves.size()];
//        for (int index = 0; index < dataSourceSlaves.size(); index++) {
//        	slaveJdbcTemplateArr[index] = new JdbcTemplate(this.dataSourceSlaves.get(index));
//        }
//    }
//
//	public JdbcTemplate getMasterJdbcTemplate() {
//		return masterJdbcTemplate;
//	}
//
//	public JdbcTemplate[] getSlaveJdbcTemplateArr() {
//		return slaveJdbcTemplateArr;
//	}

    public MyJdbcTemplate getMyJdbcTemplate() {
        return myJdbcTemplate;
    }

    @Autowired
    @Required
    public void setMyJdbcTemplate(MyJdbcTemplate myJdbcTemplate) {
        this.myJdbcTemplate = myJdbcTemplate;
    }
}
