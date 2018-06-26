package com.ustcsoft.jt.vo;

import java.util.Date;

/**
* @author mapp
* @date 2018-4-2 17:48:54
*/
public class BGxjdbZy {

        /**  */
        private String id;
        /** 地市 */
        private String dishi;
        /** 区县 */
        private String quxian;
        /** 库点名称 */
        private String kdid;
        /** 购销业务编号 */
        private String gxywbh;
        /** 粮权归属 */
        private String lqgs;
        /** 购销类型 0：收购 1：销售2：轮换 */
        private String gxlx;
        /** 购销数量/吨 */
        private String gxsl;
        /** 已完成数量/吨 */
        private String ywcsl;
        /**  */
        private String kzr;
        /** 联系电话 */
        private String lxdh;
        /** 品种 */
        private String pz;
        /** 品种名称 */
        private String pzmc;
        /** 等级 */
        private String dj;
        /** 性质
            0：最低收购粮价
            1：国家临时备粮 */
        private String xz;
        /** 0:正常
            1：暂停 */
        private String status;
        /** 附件id */
        private String fj;
        /** 开始时间 */
        private Date kssj;
        /** 结束时间 */
        private Date jssj;
        /** 库点名称 */
        private String kdmc;

        public String getId() {
            return id;
        }
        public String getDishi() {
            return dishi;
        }
        public String getQuxian() {
            return quxian;
        }
        public String getKdid() {
            return kdid;
        }
        public String getGxywbh() {
            return gxywbh;
        }
        public String getLqgs() {
            return lqgs;
        }
        public String getGxlx() {
            return gxlx;
        }
        public String getGxsl() {
            return gxsl;
        }
        public String getYwcsl() {
            return ywcsl;
        }
        public String getKzr() {
            return kzr;
        }
        public String getLxdh() {
            return lxdh;
        }
        public String getPz() {
            return pz;
        }
        public String getXz() {
            return xz;
        }
        public String getStatus() {
            return status;
        }
        public String getFj() {
            return fj;
        }
        public Date getKssj() {
            return kssj;
        }
        public Date getJssj() {
            return jssj;
        }

        public void setId(String id) {
            this.id = id;
        }
        public void setDishi(String dishi) {
            this.dishi = dishi;
        }
        public void setQuxian(String quxian) {
            this.quxian = quxian;
        }
        public void setKdid(String kdid) {
            this.kdid = kdid;
        }
        public void setGxywbh(String gxywbh) {
            this.gxywbh = gxywbh;
        }
        public void setLqgs(String lqgs) {
            this.lqgs = lqgs;
        }
        public void setGxlx(String gxlx) {
            this.gxlx = gxlx;
        }
        public void setGxsl(String gxsl) {
            this.gxsl = gxsl;
        }
        public void setYwcsl(String ywcsl) {
            this.ywcsl = ywcsl;
        }
        public void setKzr(String kzr) {
            this.kzr = kzr;
        }
        public void setLxdh(String lxdh) {
            this.lxdh = lxdh;
        }
        public void setPz(String pz) {
            this.pz = pz;
        }
        public void setXz(String xz) {
            this.xz = xz;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        public void setFj(String fj) {
            this.fj = fj;
        }
        public void setKssj(Date kssj) {
            this.kssj = kssj;
        }
        public void setJssj(Date jssj) {
            this.jssj = jssj;
        }
        public String getDj() {
            return dj;
        }
        public void setDj(String dj) {
            this.dj = dj;
        }
        public String getKdmc() {
            return kdmc;
        }
        public void setKdmc(String kdmc) {
            this.kdmc = kdmc;
        }

    public String getPzmc() {
        return pzmc;
    }

    public void setPzmc(String pzmc) {
        this.pzmc = pzmc;
    }
}