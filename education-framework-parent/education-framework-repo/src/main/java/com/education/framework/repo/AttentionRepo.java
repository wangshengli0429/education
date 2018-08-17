package com.education.framework.repo;

import com.education.framework.model.bo.AttentionBo;
import com.education.framework.model.co.AttentionCo;
import com.education.framework.model.po.Attention;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author zhoulin
 * @createTime 2018/7/9.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/9.
 * @note
 */
@Repository
public class AttentionRepo extends BaseDao<Attention,AttentionCo,AttentionBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

}
