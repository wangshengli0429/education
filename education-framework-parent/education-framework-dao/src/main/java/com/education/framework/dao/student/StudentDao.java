package com.education.framework.dao.student;

import java.util.List;
import java.util.Map;

import com.education.framework.model.student.Student;
import com.education.framework.model.student.vo.StudentVo;
/**
 * 
 * <p>StudentDao.java</p>
 * <p>学生CRUD</p>
 * <p>Company:</p>
 * @author wangsl
 * @version V1.0
 * @Date 2018年1月8日 下午6:54:15
 * <p>修改者姓名 修改内容说明</p>
 */
public interface StudentDao {
	/**
	 * 查询所有学生
	 * @param map
	 * @return
	 */
	List<StudentVo> findAllStudent(Map<String, Object> map);
	int findStudentCount(Map<String, Object> map);
	/**
	 * 删除学生
	 * @param id
	 * @return
	 */
	int deleteStudentById(String id);
	int insertStudent(Student student);
	int updateStrudentById(Student student);
	int updateStrudentById(String id);
	Student queryStudentById(Map<String, Object> map);
	
}
