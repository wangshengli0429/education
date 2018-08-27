package com.education.controller.student;

import java.util.HashMap;
import java.util.Map;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.ResultData;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.common.util.AgeUtils;
import com.education.framework.model.base.Page;
import com.education.framework.model.bo.StudentBo;
import com.education.framework.model.constant.TeacherEnum;
import com.education.framework.model.po.Student;
import com.education.framework.service.StudentApi;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.education.framework.common.base.ApiResult;
import com.education.framework.common.util.Const;
import com.google.common.collect.Maps;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentApi studentApi;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResultData save(@RequestBody StudentBo studentBo){
        if (null==studentBo){return ResultData.failed("studentBo不能为空!");}
        if (null==studentBo.getUserId()){return ResultData.failed("userId不能为空!");}
        ApiResponse<Integer> apiResponse = studentApi.save(studentBo);
        return ApiRetCode.SUCCESS_CODE == apiResponse.getRetCode()?ResultData.successed(apiResponse.getMessage(),apiResponse.getBody()):ResultData.failed(apiResponse.getMessage());
    }

    /**
     * 个人中心
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public ResultData getById(@RequestParam Integer id){
        if (null==id){return ResultData.failed("id不能为空!");}
        ApiResponse<StudentBo> apiResponse = studentApi.getById(id);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        studentHandle(apiResponse.getBody());
        return ResultData.successed(apiResponse.getBody());
    }

    private void studentHandle(StudentBo studentBo) {
        try {
            // 计算年龄
            studentBo.setAge(AgeUtils.getAge(studentBo.getBirthday()));
        }catch (Exception e){

        }
    }


    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResultData updateById(@RequestBody StudentBo studentBo){
        if (null==studentBo){return ResultData.failed("studentBo不能为空!");}
        if (null==studentBo.getId()){return ResultData.failed("id不能为空!");}
        ApiResponse<Integer> apiResponse = studentApi.updateById(studentBo);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

	
}
