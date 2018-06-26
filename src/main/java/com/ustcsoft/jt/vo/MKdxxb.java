package com.ustcsoft.jt.vo;

import java.util.ArrayList;
import java.util.List;

/**
* @author mapp
* @date 2018-4-2 17:23:18
*/
public class MKdxxb {

        /**  */
        private String id;
        /** 库点名称 */
        private String kdmc;
        /** 库点简介 */
        private String kdjj;
        /** 库点地址 */
        private String lkdz;
        /** 所在市 */
        private String szs;
        /** 所在县 */
        private String szx;
        /** 联系电话 */
        private String tel;

        private String lng;
        private String lat;

         /**  距离 */
        private String jl;

        /**  库点购销计划列表 */
        private List<BGxjdbZy> gxjdbZyList = new ArrayList<>();

        public String getJl() {
            return jl;
        }

        public void setJl(String jl) {
            this.jl = jl;
        }

        public List<BGxjdbZy> getGxjdbZyList() {
            return gxjdbZyList;
        }

        public void setGxjdbZyList(List<BGxjdbZy> gxjdbZyList) {
            this.gxjdbZyList = gxjdbZyList;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }


        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

    public String getId() {
            return id;
        }
        public String getKdmc() {
            return kdmc;
        }
        public String getKdjj() {
            return kdjj;
        }
        public String getLkdz() {
            return lkdz;
        }
        public String getSzs() {
            return szs;
        }
        public String getSzx() {
            return szx;
        }
        public String getTel() {
            return tel;
        }

        public void setId(String id) {
            this.id = id;
        }
        public void setKdmc(String kdmc) {
            this.kdmc = kdmc;
        }
        public void setKdjj(String kdjj) {
            this.kdjj = kdjj;
        }
        public void setLkdz(String lkdz) {
            this.lkdz = lkdz;
        }
        public void setSzs(String szs) {
            this.szs = szs;
        }
        public void setSzx(String szx) {
            this.szx = szx;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
}