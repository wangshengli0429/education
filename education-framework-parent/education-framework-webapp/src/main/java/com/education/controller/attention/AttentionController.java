package com.education.controller.attention;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.ResultData;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.common.util.AgeUtils;
import com.education.framework.model.bo.AttentionBo;
import com.education.framework.model.bo.TeacherBo;
import com.education.framework.model.co.AttentionCo;
import com.education.framework.model.constant.AttentionEnum;
import com.education.framework.model.constant.TeacherEnum;
import com.education.framework.service.AttentionApi;
import com.education.framework.service.TeacherApi;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/attention")
public class AttentionController {

    @Resource
    private AttentionApi attentionsApi;

    @Autowired
    private TeacherApi teacherApi;

    /**
     * 添加关注
     * @param attentionBo
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResultData save(@RequestBody AttentionBo attentionBo){
        if (null==attentionBo){return ResultData.failed("attentionBo不能为空!");}
        ApiResponse<Integer> apiResponse = attentionsApi.save(attentionBo);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

    @RequestMapping(value = "/cancel",method = RequestMethod.DELETE)
    public ResultData cancel(AttentionBo attentionBo){
        if (null==attentionBo){return ResultData.failed("attentionBo不能为空!");}
        ApiResponse<Integer> apiResponse = attentionsApi.cancel(attentionBo);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

    @RequestMapping(value = "/studentId",method = RequestMethod.GET)
    public ResultData findByStudentId(AttentionBo attentionBo){
        if (null==attentionBo){return ResultData.failed("attentionBo不能为空!");}
        if (null==attentionBo.getStudentId()){return ResultData.failed("studentId!");}
        AttentionCo attentionCo = new AttentionCo();
        attentionCo.setStudentId(attentionBo.getStudentId());
        attentionCo.setStatus(AttentionEnum.status.status_true.getValue());
        attentionCo
                // 排序有问题，最新的排最前面
        // 排序有问题，最新的排最前面
        // 排序有问题，最新的排最前面
        // 排序有问题，最新的排最前面
        // 排序有问题，最新的排最前面
        // 排序有问题，最新的排最前面
        ApiResponse<List<AttentionBo>> apiResponse = attentionsApi.findByCondition(attentionCo);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        if (CollectionUtils.isNotEmpty(apiResponse.getBody())){
            for (AttentionBo attentionBo1 : apiResponse.getBody()){
                teacherApi.getById()
            }
        }
        return ResultData.successed(apiResponse.getBody());
    }


    public void setTeacherDo(AttentionBo attentionBo, TeacherBo teacherBo){
        try {
            attentionBo.setTeacherName(teacherBo.getSurname()+"老师");
            if (teacherBo.getSex().equals(TeacherEnum.SEX_GIRL)){
                attentionBo.setTeacherGender("女");
            }else {
                attentionBo.setTeacherGender("男");
            }
            // 计算年龄
            attentionBo.setTeacherAge(AgeUtils.getAge(teacherBo.getBirthday()));
        }catch (Exception e){

        }
    }


}
