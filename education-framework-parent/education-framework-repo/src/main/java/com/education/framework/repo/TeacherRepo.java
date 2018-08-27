package com.education.framework.repo;

import com.education.framework.model.bo.TeacherBo;
import com.education.framework.model.co.TeacherCo;
import com.education.framework.model.constant.TeacherEnum;
import com.education.framework.model.po.Teacher;
import com.education.framework.model.vo.TeacherVo;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class TeacherRepo extends BaseDao<Teacher,TeacherCo,TeacherBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

    static final String BASE_COLUMN =  " t.id AS id,t.surname AS name, " +
            " t.user_id AS userId,t.birthday AS birthday, " +
            " t.sex AS sex,t.university AS university, " +
            " t.educaion AS educaion,t.major AS major, " +
            " t.photo AS photo,t.attention_count AS attentionCount, " +
            " t.order_count AS orderCount,t.comment_count AS commentCount, " +
            " d.area AS areas,GROUP_CONCAT(ts.subject_name SEPARATOR '、') AS subjects ";


    public List<TeacherVo> listByTeacher(TeacherCo teacherCo) {
        StringBuilder sql = new StringBuilder("SELECT " + BASE_COLUMN + " FROM teacher t  ");
        sql.append(" LEFT JOIN teacher_subject ts ON t.id = ts.teacher_id ");
        sql.append(" LEFT JOIN district d ON d.area_code = t.dictrict ");
        sql.append(" WHERE t.deleted =0  ");
        sql.append(" AND t.authentication = "+ TeacherEnum.authentication.pass.getValue());
        sql.append(" AND ts.deleted = 0 ");
        //params
        List<Object> parm = new ArrayList<>();
        //处理查询条件
        handleCondition(sql, teacherCo, parm);
        sql.append(" GROUP BY t.id ");
        //处理排序条件
        handleSort(sql, teacherCo);
        //分页条件
        if (teacherCo.getPageNum() != null && teacherCo.getPageSize() != null) {
            sql.append(" limit " + (teacherCo.getPageNum() - 1) * teacherCo.getPageSize() + "," + teacherCo.getPageSize());
        }else {
            sql.append(" limit 0,20 ");
        }
        sql.append(";");
        //执行查询
        List<TeacherVo> sqlResult = mysqlClient.query(sql.toString(), parm.toArray(), new BeanPropertyRowMapper<>(TeacherVo.class));
        return sqlResult;
    }

    /**
     * 根据查询条件统计总数
     * @param teacherCo
     * @return
     */
    public int countByTeacher(TeacherCo teacherCo) {
        //sql
        StringBuilder sql = new StringBuilder("SELECT COUNT(DISTINCT ct.id) AS count FROM( ");
        sql.append(" SELECT t.id AS id FROM teacher t ");
        sql.append(" LEFT JOIN teacher_subject ts ON t.id = ts.teacher_id ");
        sql.append(" LEFT JOIN district d ON d.area_code = t.dictrict ");
        sql.append(" WHERE t.deleted =0  ");
        sql.append(" AND t.authentication = "+ TeacherEnum.authentication.pass.getValue());
        sql.append(" AND ts.deleted = 0 ");
        //params
        List<Object> parm = new ArrayList<>();
        //处理查询条件
        handleCondition(sql, teacherCo, parm);
        sql.append(" GROUP BY t.id ");
        sql.append(") ct;");
        //step 3:查询结果集
        Map<String, Object> queryForMap = mysqlClient.queryForMap(sql.toString(), parm.toArray());
        int ret = MapUtils.getIntValue(queryForMap, "count");
        return ret;
    }


    /**
     * 处理查询条件
     *
     * @param sql
     * @param teacherCo
     * @param parm
     */
    private void handleCondition(StringBuilder sql, TeacherCo teacherCo, List<Object> parm) {
        if(null != teacherCo.getSubjectCode()){
            sql.append(" AND ts.subject_code = ? ");
            parm.add(teacherCo.getSubjectCode());
        }
        if (null != teacherCo.getGradeCode()){
            sql.append(" AND ts.grade_code = ? ");
            parm.add(teacherCo.getGradeCode());
        }
        if(null != teacherCo.getDepartmentCode()){
            sql.append(" AND ts.department_code = ? ");
            parm.add(teacherCo.getDepartmentCode());
        }
        if (null != teacherCo.getDictrict()){
            sql.append(" AND t.dictrict = ? ");
            parm.add(teacherCo.getDictrict());
        }
    }

    /**
     * 处理排序条件
     *
     * @param sql
     *
     */
    private void handleSort(StringBuilder sql, TeacherCo teacherCo) {

        if (null ==teacherCo.getSortOrder()){
            sql.append(" ORDER BY t.update_time desc,t.id desc ");
        }else if (teacherCo.getSortOrder().equals(TeacherCo.ZONGHE)){
            sql.append(" ORDER BY t.update_time desc,t.id desc ");
        }else if (teacherCo.getSortOrder().equals(TeacherCo.COMMENT_DESC)){
            sql.append(" ORDER BY t.comment_count desc,t.id desc ");
        }else if (teacherCo.getSortOrder().equals(TeacherCo.ORDER_DESC)){
            sql.append(" ORDER BY t.order_count desc,t.id desc ");
        }

    }



}
