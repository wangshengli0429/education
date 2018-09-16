package com.education.app.controller.idcard;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.ResultData;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.bo.IdcardBo;
import com.education.framework.service.IdcardApi;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhoulin
 * @createTime 2018/7/10.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/10.
 * @note
 */
@RestController
@RequestMapping("/idcard")
public class IdcardController {

    @Resource
    private IdcardApi idcardApi;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResultData save(@RequestBody IdcardBo idcardBo){
        if (null==idcardBo){return ResultData.failed("idcardBo不能为空!");}
        ApiResponse<Integer> apiResponse = idcardApi.save(idcardBo);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

    @ResponseBody
    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public ResultData getById(@RequestParam Integer id){
        if (null==id){return ResultData.failed("id不能为空!");}
        ApiResponse<IdcardBo> apiResponse = idcardApi.getById(id);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

    @ResponseBody
    @RequestMapping(value = "/getByUserId",method = RequestMethod.GET)
    public ResultData getByUserId(@RequestParam Integer userId){
        if (null==userId){return ResultData.failed("userId不能为空!");}
        ApiResponse<IdcardBo> apiResponse = idcardApi.getByUserId(userId);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResultData updateById(@RequestBody IdcardBo idcardBo){
        if (null==idcardBo){return ResultData.failed("idcardBo不能为空!");}
        if (null==idcardBo.getId()){return ResultData.failed("id不能为空!");}
        ApiResponse<Integer> apiResponse = idcardApi.updateById(idcardBo);
        if (ApiRetCode.SUCCESS_CODE != apiResponse.getRetCode()){
            return ResultData.failed(apiResponse.getMessage());
        }
        return ResultData.successed(apiResponse.getBody());
    }


}
