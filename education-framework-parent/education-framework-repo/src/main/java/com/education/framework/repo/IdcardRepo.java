package com.education.framework.repo;

import com.education.framework.model.bo.IdcardBo;
import com.education.framework.model.co.IdcardCo;
import com.education.framework.model.po.Idcard;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author zhoulin
 * @createTime 2018/7/10.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/10.
 * @note
 */
@Repository
public class IdcardRepo extends BaseDao<Idcard,IdcardCo,IdcardBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

}
