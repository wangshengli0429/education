package com.education.controller.basicdata;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.common.response.ResultData;
import com.education.framework.common.response.constants.ApiRetCode;
import com.education.framework.common.util.BaseMapper;
import com.education.framework.model.po.District;
import com.education.framework.model.vo.DistrictVo;
import com.education.framework.service.DistrictApi;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhoulin
 * @createTime 2018/7/16.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/16.
 * @note
 */
@Controller
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private DistrictApi districtApi;

    @Autowired
    private BaseMapper baseMapper;

    /**
     * 查询 城市 默认到（市）
     * @return
     */
    @RequestMapping(value = "/cityTree",method = RequestMethod.GET)
    public ResultData getCityTree(){
        District condition = new District();
        condition.setLevel(1);
        List<District> districtList01 = districtApi.getListByCondition(condition).getBody();
        condition.setLevel(2);
        List<District> districtList02 = districtApi.getListByCondition(condition).getBody();
        List<District> districtBos = Lists.newArrayList();
        districtBos.addAll(districtList01);
        districtBos.addAll(districtList02);
        List<DistrictVo> districtVos = Lists.newArrayList();
        this.poTpVo(districtBos,districtVos);
        if (CollectionUtils.isNotEmpty(districtVos)){
            Iterator<DistrictVo> iter = districtVos.iterator();
            while (iter.hasNext()){
                DistrictVo districtVo = iter.next();
                if (districtVo.getParentId()>0){
                    iter.remove();
                    createTree(districtVo,districtVos);
                }
            }
        }
        return ResultData.successed(districtVos);
    }



    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public ResultData getById(Integer id){
        if (null==id){return ResultData.failed("id不能为空!");}
        District district = districtApi.getById(id).getBody();
        return ResultData.successed(district);
    }

    @RequestMapping(value = "/getByParentId",method = RequestMethod.GET)
    public ResultData getByParentId(Integer parentId){
        if (null==parentId){return ResultData.failed("parentId不能为空!");}
        District condition = new District();
        condition.setParentId(parentId);
        List<District> districtList = districtApi.getListByCondition(condition).getBody();
        List<DistrictVo> districtVos = Lists.newArrayList();
        this.poTpVo(districtList,districtVos);
        return ResultData.successed(districtVos);
    }



    public void poTpVo(List<District> districts,List<DistrictVo> districtVos){
        if (CollectionUtils.isNotEmpty(districts)){
            for (District district:districts){
                DistrictVo districtVo = baseMapper.map(district,DistrictVo.class);
                districtVos.add(districtVo);
            }
        }
    }

    /**
     * 递归创建树
     *
     */
    private void createTree(DistrictVo districtVo,List<DistrictVo> districtVos) {
        if (null!=districtVo && CollectionUtils.isNotEmpty(districtVos)){
            for (DistrictVo district01 : districtVos){
                if (null==districtVo){break;}
                if (districtVo.getParentId().equals(district01.getId())){
                    if (CollectionUtils.isNotEmpty(district01.getDistrictVos())){
                        district01.getDistrictVos().add(districtVo);
                    }else {
                        List<DistrictVo> districtBoList = new ArrayList<>();
                        districtBoList.add(districtVo);
                        district01.setDistrictVos(districtBoList);
                    }
                    districtVo = null;
                }
                createTree(districtVo,district01.getDistrictVos());
            }
        }
    }



}
