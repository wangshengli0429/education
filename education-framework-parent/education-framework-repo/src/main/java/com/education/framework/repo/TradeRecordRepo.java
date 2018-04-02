package com.education.framework.repo;

import com.education.framework.model.bo.TradeRecordBo;
import com.education.framework.model.co.TradeRecordCo;
import com.education.framework.model.po.TradeRecord;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class TradeRecordRepo extends BaseDao<TradeRecord,TradeRecordCo,TradeRecordBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

}
