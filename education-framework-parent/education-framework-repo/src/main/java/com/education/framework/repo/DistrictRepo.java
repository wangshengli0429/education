package com.education.framework.repo;

import com.education.framework.model.po.District;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author zhoulin
 * @createTime 2018/7/12.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/12.
 * @note
 */
@Repository
public class DistrictRepo extends BaseDao<District,District,District> {

    @Resource
    private CommonMysqlClient mysqlClient;

}
