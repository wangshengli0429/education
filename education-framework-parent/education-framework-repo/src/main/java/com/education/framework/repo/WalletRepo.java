package com.education.framework.repo;

import com.education.framework.model.bo.WalletBo;
import com.education.framework.model.co.WalletCo;
import com.education.framework.model.po.Wallet;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class WalletRepo extends BaseDao<Wallet,WalletCo,WalletBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

}
