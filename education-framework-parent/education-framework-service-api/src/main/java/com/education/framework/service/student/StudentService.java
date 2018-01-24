package com.education.framework.service.student;

import java.util.Map;

import com.education.framework.common.base.ApiResult;
import com.education.framework.model.student.Student;


public interface StudentService {
	 /**
     * 查询学生
     * 
     * @param map
     * @return
     */
	ApiResult findAllStudent(Map<String, Object> map);
   
    /**
     * 根据ID查询学生
     * 
     * @param map
     * @return
     */
    ApiResult queryStudentById(Map<String, Object> map);

    /**
     * 添加父菜单
     * 
     * @param student
     * @return
     */
     ApiResult insertStudent(Student student);

    
    /**
     * 修改学生
     * 
     * @param student
     * @return
     */
    ApiResult updateStudent(Student student);
    ApiResult updateStrudentById(String id);
    /**
     * 删除学生
     * 
     * @param id
     * @return
     */
    ApiResult deleteStudent(String id);

   
}
