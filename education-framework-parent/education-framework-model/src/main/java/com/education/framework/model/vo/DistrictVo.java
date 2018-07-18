package com.education.framework.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhoulin
 * @createTime 2018/7/16.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/16.
 * @note
 */
public class DistrictVo implements Serializable,Cloneable{

    private Integer id;

    private Integer parentId;

    private Integer level;

    private String areaCode;

    private String name;

    private String shortName;

    private List<DistrictVo> districtVos;

    public List<DistrictVo> getDistrictVos() {
        return districtVos;
    }

    public void setDistrictVos(List<DistrictVo> districtVos) {
        this.districtVos = districtVos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
