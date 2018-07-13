package com.education.framework.service.impl;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.po.District;
import com.education.framework.repo.DistrictRepo;
import com.education.framework.service.DistrictApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhoulin
 * @createTime 2018/7/12.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/12.
 * @note
 */
@Service
public class DistrictServiceImpl implements DistrictApi{

    @Resource
    private DistrictRepo districtRepo;

    @Override
    public ApiResponse<District> getById(Integer id) {
        District district = districtRepo.getById(id);
        return ApiResponse.success(district);
    }

    @Override
    public ApiResponse<List<District>> getListByCondition(District district) {
        List<District> list = districtRepo.getListByCondition(district);
        return ApiResponse.success(list);
    }

    @Override
    public ApiResponse<Integer> updateById(District district) {
        int row = districtRepo.updateById(district);
        return ApiResponse.success(row);
    }



}
