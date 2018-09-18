package com.education.web.controller.teacher;


import com.education.framework.common.base.ApiResult;
import com.education.framework.model.bo.TeacherBo;
import com.education.framework.model.vo.TeacherVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("teacher-web")
public class TeacherWebController {

    @RequestMapping(value = "toTeacherPageList", method = RequestMethod.GET)
    public String toTeacherPageList() {
        return "manager/teacher/teacher-list";
    }

    @ResponseBody
    @RequestMapping(value = "getTeacherPageList", method = RequestMethod.GET)
    public ApiResult getTeacherPageList(String keyword) {
        List<TeacherBo> teacherVoList = new ArrayList<TeacherBo>();
        TeacherBo  t = new TeacherBo();
        t.setName("张涛");
        t.setTelephone("13803949980");
        t.setSex(1);
        t.setAge(18);
        t.setAreas("北京市");
        t.setNativePlace("山西太原");
        t.setEducaion("本科");
        teacherVoList.add(t);
        TeacherBo  t1 = new TeacherBo();
        t.setName("李丽");
        t.setTelephone("13677728890");
        t.setSex(2);
        t.setAge(20);
        t.setAreas("北京市");
        t.setNativePlace("山东济南");
        t.setEducaion("本科");
        teacherVoList.add(t1);

        ApiResult apiResult = new ApiResult();
        apiResult.setData(teacherVoList);
        return apiResult;
    }

}
