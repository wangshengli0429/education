package com.education.framework.repo;

import com.education.framework.model.bo.OrderAppointmentBo;
import com.education.framework.model.co.OrderAppointmentCo;
import com.education.framework.model.po.OrderAppointment;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class OrderAppointmentRepo extends BaseDao<OrderAppointment,OrderAppointmentCo,OrderAppointmentBo> {

    @Resource
    private CommonMysqlClient mysqlClient;
}
