package com.ustcsoft.jt.vo;

import java.io.Serializable;

/**
 * @author mapp
 * @des 购销结果出参
 * @date 2018/4/3
 */
public class YuYueJGVO implements Serializable{

    /** 购销业务编号 */
    private String gxywbh;

    /** 排队人数 */
    private int pdrs;

    /** 库点名称 */
    private String kdmc;

    /** 预约状态 */
    private String status;

    public String getGxywbh() {
        return gxywbh;
    }

    public void setGxywbh(String gxywbh) {
        this.gxywbh = gxywbh;
    }

    public int getPdrs() {
        return pdrs;
    }

    public void setPdrs(int pdrs) {
        this.pdrs = pdrs;
    }

    public String getKdmc() {
        return kdmc;
    }

    public void setKdmc(String kdmc) {
        this.kdmc = kdmc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
