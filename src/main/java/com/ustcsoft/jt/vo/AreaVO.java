package com.ustcsoft.jt.vo;

import com.ustcsoft.framework.vo.BaseVO;

/**
 * Created by Administrator on 2018/3/20.
 */
public class AreaVO {

    private String areaId;

    private String areaName;

    private String areaLV;

    private String parentAreaId;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaLV() {
        return areaLV;
    }

    public void setAreaLV(String areaLV) {
        this.areaLV = areaLV;
    }

    public String getParentAreaId() {
        return parentAreaId;
    }

    public void setParentAreaId(String parentAreaId) {
        this.parentAreaId = parentAreaId;
    }
}
