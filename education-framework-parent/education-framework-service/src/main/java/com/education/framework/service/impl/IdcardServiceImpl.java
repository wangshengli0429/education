package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.model.bo.IdcardBo;
import com.education.framework.model.co.IdcardCo;
import com.education.framework.model.constant.IdcardEnum;
import com.education.framework.repo.IdcardRepo;
import com.education.framework.service.IdcardApi;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoulin
 * @createTime 2018/7/10.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/10.
 * @note
 */
@Service
public class IdcardServiceImpl implements IdcardApi{

    @Autowired
    private IdcardRepo idcardRepo;

    @Override
    public ApiResponse<IdcardBo> getById(Integer id) {
        if (null==id){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        IdcardBo idcardBo = idcardRepo.getById(id);
        return ApiResponse.success(idcardBo);
    }

    @Override
    public ApiResponse<IdcardBo> getByUserId(Integer userId) {
        if (null==userId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"userId不能为空!");}
        IdcardCo idcardCo = new IdcardCo();
        idcardCo.setUserId(userId);
        List<IdcardBo> list = idcardRepo.getListByCondition(idcardCo);
        IdcardBo idcardBo = null;
        if (CollectionUtils.isNotEmpty(list)){
            idcardBo = list.get(0);
        }
        return ApiResponse.success(idcardBo);
    }

    @Override
    public ApiResponse<Integer> countByUserId(Integer userId) {
        if (null==userId){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"userId不能为空!");}
        IdcardCo idcardCo = new IdcardCo();
        idcardCo.setUserId(userId);
        int count = idcardRepo.countByCondition(idcardCo);
        return ApiResponse.success(count);
    }

    @Override
    public ApiResponse<Integer> save(IdcardBo idcardBo) {
        if (null==idcardBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"idcardBo不能为空!");}
        if (null==idcardBo.getUserId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"userId不能为空!");}
        IdcardCo idcardCo = new IdcardCo();
        idcardCo.setUserId(idcardBo.getUserId());
        int count = idcardRepo.countByCondition(idcardCo);
        if (count>0){return ApiResponse.fail(ApiRetCode.FETCH_DATA_FAIL,"该用户数据已存在!");}
        int id =idcardRepo.saveSelective(idcardBo);
        return ApiResponse.success(id);
    }

    @Override
    public ApiResponse<Integer> updateById(IdcardBo idcardBo) {
        if (null==idcardBo){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"idcardBo不能为空!");}
        if (null==idcardBo.getId()){return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"id不能为空!");}
        IdcardBo idcardBo1 = idcardRepo.getById(idcardBo.getId());
        if (null==idcardBo1){
            return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"数据不存在");
        }
        if (idcardBo1.getStatus().equals(IdcardEnum.status.check_pass.getValue())){
            return ApiResponse.fail(ApiRetCode.PARAMETER_ERROR,"身份证审核已通过，不允许修改");
        }
        int row = idcardRepo.updateById(idcardBo);
        return ApiResponse.success(row);
    }

}
