package com.education.app.controller.basicdata;


import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.ResultData;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.bo.BasicDataBo;
import com.education.framework.model.bo.DictionaryBo;
import com.education.framework.model.bo.GradeBo;
import com.education.framework.model.bo.SubjectBo;
import com.education.framework.model.constant.DictionaryEnum;
import com.education.framework.model.constant.SubjectEnum;
import com.education.framework.model.po.Dictionary;
import com.education.framework.model.po.Subject;
import com.education.framework.service.DictionaryApi;
import com.education.framework.service.GradeApi;
import com.education.framework.service.SubjectApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/subject")
public class SubjectController{

    @Autowired
    private SubjectApi subjectApi;

    @Autowired
    private GradeApi gradeApi;

    @Autowired
    private DictionaryApi dictionaryApi;

    /**
     * 根据学部查询科目和年级
     * @param departmentCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getByDepartmentCode",method = RequestMethod.GET)
    public ResultData getByDepartmentCode(@RequestParam String departmentCode){
        BasicDataBo basicDataBo = new BasicDataBo();
        basicDataBo.setDepartmentCode(departmentCode);
        ApiResponse<List<SubjectBo>> subApiResponse = subjectApi.listByDepartmentCode(departmentCode);
        if (ApiRetCode.SUCCESS_CODE == subApiResponse.getRetCode()){
            basicDataBo.setSubjectBos(subApiResponse.getBody());
        }
        ApiResponse<List<GradeBo>> gradApiResponse = gradeApi.listByDepartmentCode(departmentCode);
        if (ApiRetCode.SUCCESS_CODE == gradApiResponse.getRetCode()){
            basicDataBo.setGradeBos(gradApiResponse.getBody());
        }
        return ResultData.successed(basicDataBo);
    }

    /**
     * 默认查询全学部，以及小学学部下的年级和科目
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/basicData",method = RequestMethod.GET)
    public ResultData getBasicData(){
        BasicDataBo basicDataBo = new BasicDataBo();
        Dictionary dictionary = new Dictionary();
        dictionary.setStatus(DictionaryEnum.status.ENABLE.getValue());
        dictionary.setType(SubjectEnum.DEPARTMENT_TYPE);
        ApiResponse<List<DictionaryBo>> apiResponse = dictionaryApi.getListByCondition(dictionary);
        if (ApiRetCode.SUCCESS_CODE == apiResponse.getRetCode()){
            basicDataBo.setDepartmentBos(apiResponse.getBody());
        }
        String departmentCode = SubjectEnum.departmentCode.xiaoxue.getValue();
        ApiResponse<List<SubjectBo>> subApiResponse = subjectApi.listByDepartmentCode(departmentCode);
        if (ApiRetCode.SUCCESS_CODE == subApiResponse.getRetCode()){
            basicDataBo.setSubjectBos(subApiResponse.getBody());
        }
        ApiResponse<List<GradeBo>> gradApiResponse = gradeApi.listByDepartmentCode(departmentCode);
        if (ApiRetCode.SUCCESS_CODE == gradApiResponse.getRetCode()){
            basicDataBo.setGradeBos(gradApiResponse.getBody());
        }
        return ResultData.successed(basicDataBo);
    }



}
