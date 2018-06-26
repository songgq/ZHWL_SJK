package com.ustcsoft.jt.vo;

import java.io.Serializable;

/**
 * @author mapp
 * @des
 * @date 2018/4/13
 */
public class PriceVO implements Serializable {

    private String dj;

    private String danJ;

    private String mz;

    private String zl;

    private String jz;

    private String zj;

    public String getDj() {
        return dj;
    }

    public void setDj(String dj) {
        this.dj = dj;
    }

    public String getDanJ() {
        return danJ;
    }

    public void setDanJ(String danJ) {
        this.danJ = danJ;
    }

    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }

    public String getZl() {
        return zl;
    }

    public void setZl(String zl) {
        this.zl = zl;
    }

    public String getJz() {
        return jz;
    }

    public void setJz(String jz) {
        this.jz = jz;
    }

    public String getZj() {
        return zj;
    }

    public void setZj(String zj) {
        this.zj = zj;
    }
}
