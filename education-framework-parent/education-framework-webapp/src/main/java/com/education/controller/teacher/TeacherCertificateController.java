package com.education.controller.teacher;

import com.education.framework.common.response.ResultData;
import com.education.framework.model.bo.TeacherCertificateBo;
import com.education.framework.model.po.TeacherCertificate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhoulin
 * @createTime 2018/7/5.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/5.
 * @note
 */
@Controller
@RequestMapping("/teacherCertificate")
public class TeacherCertificateController {

    @RequestMapping(value = "/teacherId",method = RequestMethod.GET)
    public ResultData getByTeacherId(@RequestParam Integer teacherId){
        if (null==teacherId){return ResultData.failed("id不能为空!");}
        TeacherCertificateBo teacherCertificateBo = new TeacherCertificateBo();
        teacherCertificateBo.setTeacherId(1);
        teacherCertificateBo.setCertificateTitle("英语四级");
        teacherCertificateBo.setId(1);
        teacherCertificateBo.setCertificateImg("http://a.jpg");
        teacherCertificateBo.setRegDate(new Date());
        teacherCertificateBo.setDescr("证书描述");
        TeacherCertificateBo teacherCertificateBo1 = new TeacherCertificateBo();
        teacherCertificateBo1.setTeacherId(1);
        teacherCertificateBo1.setCertificateTitle("三好学生");
        teacherCertificateBo1.setId(1);
        teacherCertificateBo1.setCertificateImg("http://b.jpg");
        teacherCertificateBo1.setRegDate(new Date());
        teacherCertificateBo1.setDescr("我是三好学生");
        List<TeacherCertificateBo> list = new ArrayList<TeacherCertificateBo>();
        list.add(teacherCertificateBo);
        list.add(teacherCertificateBo1);
        return ResultData.successed(list);
    }

}
