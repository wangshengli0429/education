package com.education.framework.dao.teacher;

import java.util.List;
import java.util.Map;

import com.education.framework.model.teacher.TeacherTime;

/**
 * 
 * <p>TeacherTimeDao.java</p>
 * <p>教师授课时间CRUD</p>
 * <p>Company: </p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月8日 下午6:54:56
 * <p>修改者姓名 修改内容说明</p>
 */
public interface TeacherTimeDao {
	
	List<TeacherTime> findAllTeacherTime(Map<String, Object> map);
	int findTeacherTimeCount(Map<String, Object> map);
	 
	int deleteTeacherTimeById(String id);
	int insertTeacherTime(TeacherTime teacherTime);
	int updateTeacherTimeById(TeacherTime teacherTime);
	TeacherTime queryTeacherTimeById(Map<String, Object> map);
}
