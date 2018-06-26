package com.ustcsoft.jt.vo;

import com.ustcsoft.framework.vo.BaseVO;

import java.util.Date;
import java.util.List;

/**
* @author mapp
* @date 2018-3-1 16:36:06
*/
public class BMuBan extends BaseVO {

    /**  */
    private String id;
    /**  */
    private String mbmc;
    /**
     * 0: 未发布 1：已发布 2:已删除
     */
    private String status;
    /**
     * 模板对应的指标值
     */
    private List<BZhiBiao> zhiBiaos;

    public List<BZhiBiao> getZhiBiaos() {
        return zhiBiaos;
    }

    public void setZhiBiaos(List<BZhiBiao> zhiBiaos) {
        this.zhiBiaos = zhiBiaos;
    }

    public String getId() {
        return id;
    }

    public String getMbmc() {
        return mbmc;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMbmc(String mbmc) {
        this.mbmc = mbmc;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

