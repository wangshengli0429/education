package com.education.framework.repo;

import com.education.framework.model.bo.OrderBo;
import com.education.framework.model.co.OrderCo;
import com.education.framework.model.po.Orders;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class OrderRepo extends BaseDao<Orders,OrderCo,OrderBo> {

    @Resource
    private CommonMysqlClient mysqlClient;
}
