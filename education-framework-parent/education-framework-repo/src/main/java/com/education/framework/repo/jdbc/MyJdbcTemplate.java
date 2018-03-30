package com.education.framework.repo.jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.nativejdbc.NativeJdbcExtractor;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by yangtao on 2016/11/12.
 */
public class MyJdbcTemplate extends JdbcTemplate {
    private NativeJdbcExtractor nativeJdbcExtractor;

    private DataSource masterDataSource;
    private DataSource[] slaveDataSources;
    private Random random = new Random();

    public MyJdbcTemplate(){

    }

    public MyJdbcTemplate(DataSource masterDataSourceOnly){
        setMasterDataSource(masterDataSourceOnly);
        setSlaveDataSources(masterDataSourceOnly);
        this.afterPropertiesSet();
    }

    public MyJdbcTemplate(DataSource masterDataSource,DataSource... slaveDataSources) {
        setMasterDataSource(masterDataSource);
        setSlaveDataSources(slaveDataSources);
        this.afterPropertiesSet();
    }

    //获取从库的dataSource、如果没有获取主库
    public DataSource getDataSource() {
        if(slaveDataSources!=null){
            return getSlaveDataSource();
        }else{
            return getMasterDataSource();
        }
    }

    //指定获取主库或从库的dataSource
    public DataSource getDataSource(boolean useMaster) {
        if(useMaster){
            return getMasterDataSource();
        }else{
            return getSlaveDataSource();
        }
    }

    public DataSource getMasterDataSource() {
        return masterDataSource;
    }

    public void setMasterDataSource(DataSource masterDataSource) {
        this.masterDataSource = masterDataSource;
    }

    public DataSource getSlaveDataSource() {
        if(slaveDataSources.length > 1){
            int idx = random.nextInt(slaveDataSources.length);
            return slaveDataSources[idx];
        }
        return slaveDataSources[0];
    }

    public void setSlaveDataSources(DataSource... slaveDataSources) {
        this.slaveDataSources = slaveDataSources;
    }

    private static String getSql(Object sqlProvider) {
        return sqlProvider instanceof SqlProvider ?((SqlProvider)sqlProvider).getSql():null;
    }

    private static boolean useMasterDataSource(String sql){
        boolean ret = sql == null;
        if(!ret){
            String tempSql = sql.toLowerCase();
            if(tempSql.indexOf("select") == -1){//非select的都走主库
                ret = true;
            }else if(tempSql.indexOf("insert") != -1 //insert *** select
                    || tempSql.indexOf("update") != -1 //update *** in (select ***)
                    || tempSql.indexOf("delete") != -1){ //delete *** in (select ***)
                ret = true;
            }
        }
        return ret;
    }

    public <T> T execute(ConnectionCallback<T> action) throws DataAccessException {
        Assert.notNull(action, "Callback object must not be null");
        String sql = getSql(action);
        boolean useMaster = useMasterDataSource(sql);
        Connection con = DataSourceUtils.getConnection(this.getDataSource(useMaster));

        Object var4;
        try {
            Connection ex;
            if(this.nativeJdbcExtractor != null) {
                ex = this.nativeJdbcExtractor.getNativeConnection(con);
            } else {
                ex = this.createConnectionProxy(con);
            }

            var4 = action.doInConnection(ex);
        } catch (SQLException var8) {
            DataSourceUtils.releaseConnection(con, this.getDataSource(useMaster));
            con = null;
            throw this.getExceptionTranslator().translate("ConnectionCallback", sql, var8);
        } finally {
            DataSourceUtils.releaseConnection(con, this.getDataSource(useMaster));
        }

        return (T) var4;
    }

    public <T> T execute(StatementCallback<T> action) throws DataAccessException {
        Assert.notNull(action, "Callback object must not be null");
        String sql = getSql(action);
        boolean useMaster = useMasterDataSource(sql);
        Connection con = DataSourceUtils.getConnection(this.getDataSource(useMaster));
        Statement stmt = null;

        Object var7;
        try {
            Connection ex = con;
            if(this.nativeJdbcExtractor != null && this.nativeJdbcExtractor.isNativeConnectionNecessaryForNativeStatements()) {
                ex = this.nativeJdbcExtractor.getNativeConnection(con);
            }

            stmt = ex.createStatement();
            this.applyStatementSettings(stmt);
            Statement stmtToUse = stmt;
            if(this.nativeJdbcExtractor != null) {
                stmtToUse = this.nativeJdbcExtractor.getNativeStatement(stmt);
            }

            Object result = action.doInStatement(stmtToUse);
            this.handleWarnings(stmt);
            var7 = result;
        } catch (SQLException var11) {
            JdbcUtils.closeStatement(stmt);
            stmt = null;
            DataSourceUtils.releaseConnection(con, this.getDataSource(useMaster));
            con = null;
            throw this.getExceptionTranslator().translate("StatementCallback", sql, var11);
        } finally {
            JdbcUtils.closeStatement(stmt);
            DataSourceUtils.releaseConnection(con, this.getDataSource(useMaster));
        }

        return (T) var7;
    }

    public <T> T execute(PreparedStatementCreator psc, PreparedStatementCallback<T> action) throws DataAccessException {
        Assert.notNull(psc, "PreparedStatementCreator must not be null");
        Assert.notNull(action, "Callback object must not be null");
        String sql = getSql(psc);
        if(this.logger.isDebugEnabled()) {
            this.logger.debug("Executing prepared SQL statement" + (sql != null?" [" + sql + "]":""));
        }

        boolean useMaster = useMasterDataSource(sql);
        Connection con1 = DataSourceUtils.getConnection(this.getDataSource(useMaster));
        PreparedStatement ps = null;

        Object var8;
        try {
            Connection ex = con1;
            if(this.nativeJdbcExtractor != null && this.nativeJdbcExtractor.isNativeConnectionNecessaryForNativePreparedStatements()) {
                ex = this.nativeJdbcExtractor.getNativeConnection(con1);
            }

            ps = psc.createPreparedStatement(ex);
            this.applyStatementSettings(ps);
            PreparedStatement sql1 = ps;
            if(this.nativeJdbcExtractor != null) {
                sql1 = this.nativeJdbcExtractor.getNativePreparedStatement(ps);
            }

            Object result = action.doInPreparedStatement(sql1);
            this.handleWarnings((Statement)ps);
            var8 = result;
        } catch (SQLException var12) {
            if(psc instanceof ParameterDisposer) {
                ((ParameterDisposer)psc).cleanupParameters();
            }

            psc = null;
            JdbcUtils.closeStatement(ps);
            ps = null;
            DataSourceUtils.releaseConnection(con1, this.getDataSource(useMaster));
            con1 = null;
            throw this.getExceptionTranslator().translate("PreparedStatementCallback", sql, var12);
        } finally {
            if(psc instanceof ParameterDisposer) {
                ((ParameterDisposer)psc).cleanupParameters();
            }

            JdbcUtils.closeStatement(ps);
            DataSourceUtils.releaseConnection(con1, this.getDataSource(useMaster));
        }

        return (T) var8;
    }

    public <T> T execute(CallableStatementCreator csc, CallableStatementCallback<T> action) throws DataAccessException {
        Assert.notNull(csc, "CallableStatementCreator must not be null");
        Assert.notNull(action, "Callback object must not be null");
        String sql = getSql(csc);
        if(this.logger.isDebugEnabled()) {
            this.logger.debug("Calling stored procedure" + (sql != null?" [" + sql + "]":""));
        }

        boolean useMaster = useMasterDataSource(sql);
        Connection con1 = DataSourceUtils.getConnection(this.getDataSource(useMaster));
        CallableStatement cs = null;

        Object var8;
        try {
            Connection ex = con1;
            if(this.nativeJdbcExtractor != null) {
                ex = this.nativeJdbcExtractor.getNativeConnection(con1);
            }

            cs = csc.createCallableStatement(ex);
            this.applyStatementSettings(cs);
            CallableStatement sql1 = cs;
            if(this.nativeJdbcExtractor != null) {
                sql1 = this.nativeJdbcExtractor.getNativeCallableStatement(cs);
            }

            Object result = action.doInCallableStatement(sql1);
            this.handleWarnings((Statement)cs);
            var8 = result;
        } catch (SQLException var12) {
            if(csc instanceof ParameterDisposer) {
                ((ParameterDisposer)csc).cleanupParameters();
            }

            csc = null;
            JdbcUtils.closeStatement(cs);
            cs = null;
            DataSourceUtils.releaseConnection(con1, this.getDataSource(useMaster));
            con1 = null;
            throw this.getExceptionTranslator().translate("CallableStatementCallback", sql, var12);
        } finally {
            if(csc instanceof ParameterDisposer) {
                ((ParameterDisposer)csc).cleanupParameters();
            }

            JdbcUtils.closeStatement(cs);
            DataSourceUtils.releaseConnection(con1, this.getDataSource(useMaster));
        }

        return (T) var8;
    }

    @Override
    public <T> T queryForObject(String sql, Object[] args, RowMapper<T> rowMapper) throws DataAccessException {
        List<T> results = query(sql, args, new RowMapperResultSetExtractor<T>(rowMapper, 1));
        return MyDataAccessUtils.requiredSingleResult(results);
    }

    public int[] batchUpdate(String sql, List<Object[]> batchArgs,KeyHolder generatedKeyHolder) throws DataAccessException {
        return batchUpdate(sql, batchArgs, new int[0], generatedKeyHolder);
    }

    public int[] batchUpdate(String sql, List<Object[]> batchArgs, int[] argTypes,KeyHolder generatedKeyHolder) throws DataAccessException {
        return BatchUpdateGeneratedKeysUtils.executeKeysBatchUpdate(sql, batchArgs, argTypes, this, generatedKeyHolder);
    }

    public int[] batchUpdate(final String sql,
                             final BatchPreparedStatementSetter pss, final KeyHolder generatedKeyHolder)
            throws DataAccessException {

        return (int[]) execute(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                        return conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    }
                },
                new PreparedStatementCallback() {
                    public Object doInPreparedStatement(PreparedStatement ps) throws SQLException {
                        try {
                            int batchSize = pss.getBatchSize();
                            InterruptibleBatchPreparedStatementSetter ipss =
                                    (pss instanceof InterruptibleBatchPreparedStatementSetter ?
                                            (InterruptibleBatchPreparedStatementSetter) pss : null);
                            if (JdbcUtils.supportsBatchUpdates(ps.getConnection())) {
                                for (int i = 0; i < batchSize; i++) {
                                    pss.setValues(ps, i);
                                    if (ipss != null && ipss.isBatchExhausted(i)) {
                                        break;
                                    }
                                    ps.addBatch();
                                }
                                int[] rowsAffected = ps.executeBatch();
                                List generatedKeys = generatedKeyHolder.getKeyList();
                                generatedKeys.clear();
                                ResultSet keys = ps.getGeneratedKeys();
                                if (keys != null) {
                                    try {
                                        RowMapper rowMapper = getColumnMapRowMapper();
                                        RowMapperResultSetExtractor rse = new RowMapperResultSetExtractor(rowMapper, 1);
                                        generatedKeys.addAll((List) rse.extractData(keys));
                                    } finally {
                                        JdbcUtils.closeResultSet(keys);
                                    }
                                }
                                if (logger.isDebugEnabled()) {
                                    logger.debug("SQL update affected " + rowsAffected + " rows and returned " + generatedKeys.size() + " keys");
                                }
                                return rowsAffected;
                            } else {
                                List rowsAffected = new ArrayList();
                                for (int i = 0; i < batchSize; i++) {
                                    pss.setValues(ps, i);
                                    if (ipss != null && ipss.isBatchExhausted(i)) {
                                        break;
                                    }
                                    rowsAffected.add(new Integer(ps.executeUpdate()));
                                }
                                int[] rowsAffectedArray = new int[rowsAffected.size()];
                                for (int i = 0; i < rowsAffectedArray.length; i++) {
                                    rowsAffectedArray[i] = ((Integer) rowsAffected.get(i)).intValue();
                                }
                                return rowsAffectedArray;
                            }
                        } finally {
                            if (pss instanceof ParameterDisposer) {
                                ((ParameterDisposer) pss).cleanupParameters();
                            }
                        }
                    }
                });
    }
}
