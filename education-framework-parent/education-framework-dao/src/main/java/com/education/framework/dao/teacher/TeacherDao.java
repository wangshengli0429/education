package com.education.framework.dao.teacher;

import java.util.List;
import java.util.Map;

import com.education.framework.model.teacher.Teacher;
import com.education.framework.model.teacher.vo.TeacherVo;

/**
 * 
 * <p>TeacherDao.java</p>
 * <p>教师CRUD</p>
 * <p>Company: </p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月8日 下午6:54:56
 * <p>修改者姓名 修改内容说明</p>
 */
public interface TeacherDao {
	
	List<TeacherVo> findAllTeacher(Map<String, Object> map);
	int findTeacherCount(Map<String, Object> map);
	 
	int deleteTeacherById(String id);
	int insertTeacher(Teacher teacher);
	int updateTeacherById(Teacher teacher);
	Teacher queryTeacherById(Map<String, Object> map);
}
