package com.education.controller.teacher;

import com.education.framework.common.response.ResultData;
import com.education.framework.model.bo.TeacherSubjectBo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoulin
 * @createTime 2018/7/6.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/6.
 * @note
 */
@Controller
@RequestMapping("/teacherSubject")
public class TeacherSubjectController {

    @RequestMapping(value = "/byTeacherId",method = RequestMethod.GET)
    public ResultData getByTeacherId(@RequestParam Integer teacherId){
        List<TeacherSubjectBo> list = new ArrayList<TeacherSubjectBo>();
        TeacherSubjectBo teacherSubjectBo = new TeacherSubjectBo();
        teacherSubjectBo.setId(1);
        teacherSubjectBo.setTeacherId(1);
        teacherSubjectBo.setGradeCode("a");
        teacherSubjectBo.setSubjectCode("b");
        teacherSubjectBo.setDepartmentCode("c");
        teacherSubjectBo.setPrice(100d);
        list.add(teacherSubjectBo);
        return ResultData.successed(list);
    }

    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public ResultData getById(@RequestParam Integer id){
        TeacherSubjectBo teacherSubjectBo = new TeacherSubjectBo();
        teacherSubjectBo.setId(1);
        teacherSubjectBo.setTeacherId(1);
        teacherSubjectBo.setGradeCode("a");
        teacherSubjectBo.setSubjectCode("b");
        teacherSubjectBo.setDepartmentCode("c");
        teacherSubjectBo.setPrice(100d);
        return ResultData.successed(teacherSubjectBo);
    }



}
