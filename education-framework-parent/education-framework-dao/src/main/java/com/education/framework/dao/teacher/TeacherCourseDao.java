package com.education.framework.dao.teacher;

import java.util.List;
import java.util.Map;

import com.education.framework.model.po.TeacherSubject;

/**
 * 
 * <p>TeacherCourseDao.java</p>
 * <p>教师课程CRUD</p>
 * <p>Company: </p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月8日 下午6:54:56
 * <p>修改者姓名 修改内容说明</p>
 */
public interface TeacherCourseDao {
	
	List<TeacherSubject> findAllTeacherCourse(Map<String, Object> map);
	int findTeacherCourseCount(Map<String, Object> map);
	/**
	 * 删除学生
	 * @param id
	 * @return
	 */
	int deleteTeacherCourseById(String id);
	int insertTeacherCourse(TeacherSubject teacherCourse);
	int updateStrudentById(TeacherSubject teacherCourse);
	TeacherSubject queryTeacherCourseById(Map<String, Object> map);
}
