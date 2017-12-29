package com.education.framework.dao.student;

import java.util.List;
import java.util.Map;

import com.education.framework.model.student.Student;

public interface StudentDao {
	/**
	 * 查询所有学生
	 * @param map
	 * @return
	 */
	List<Student> findAllStudent(Map<String, Object> map);
	int findStudentCount(Map<String, Object> map);
	/**
	 * 删除学生
	 * @param id
	 * @return
	 */
	int deleteStudentById(String id);
	int insertStudent(Student student);
	int updateStrudentById(Student student);
	Student queryStudentById(Map<String, Object> map);
	
}
