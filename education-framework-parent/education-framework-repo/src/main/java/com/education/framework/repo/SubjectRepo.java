package com.education.framework.repo;

import com.education.framework.model.bo.SubjectBo;
import com.education.framework.model.co.SubjectCo;
import com.education.framework.model.po.Subject;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class SubjectRepo extends BaseDao<Subject,SubjectCo,SubjectBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

    /**
     *  根据code集合集合查询
     * @param codes
     * @return
     */
    public List<SubjectBo> listByCodes(List<String> codes) {
        if (CollectionUtils.isEmpty(codes)){
            return new ArrayList<SubjectBo>();
        }
        StringBuilder sql = new StringBuilder("SELECT * FROM subject t WHERE t.deleted = 0 ");
        sql.append(" and t.code in('");
        sql.append(StringUtils.join(codes,"','"));
        sql.append("');");
        return mysqlClient.query(sql.toString(), new Object[]{}, new BeanPropertyRowMapper<>(SubjectBo.class));
    }



}
