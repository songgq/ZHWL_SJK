package com.ustcsoft.jt.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
* @author mapp
* @date 2018-3-1 15:08:19
*/
public class BZhiBiao {

        /**  */
        private String id;
        /**  */
        private String pid;
        /**  */
        private String value;
        /**  */
        private String hangci;
        /** 状态 0：已删除  1：未删除 */
        private String status;
        /**  */
        private String creater;
        /**  */
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date createtime;
        /**  */
        private String updater;
        /**  */
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date updatetime;
        /** 级别 */
        private String jibie;

        public String getJibie() {
            return jibie;
        }

        public void setJibie(String jibie) {
            this.jibie = jibie;
        }

        public String getId() {
            return id;
        }
        public String getPid() {
            return pid;
        }
        public String getValue() {
            return value;
        }
        public String getHangci() {
            return hangci;
        }
        public String getStatus() {
            return status;
        }
        public String getCreater() {
            return creater;
        }
        public Date getCreatetime() {
            return createtime;
        }
        public String getUpdater() {
            return updater;
        }
        public Date getUpdatetime() {
            return updatetime;
        }

        public void setId(String id) {
            this.id = id;
        }
        public void setPid(String pid) {
            this.pid = pid;
        }
        public void setValue(String value) {
            this.value = value;
        }
        public void setHangci(String hangci) {
            this.hangci = hangci;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        public void setCreater(String creater) {
            this.creater = creater;
        }
        public void setCreatetime(Date createtime) {
            this.createtime = createtime;
        }
        public void setUpdater(String updater) {
            this.updater = updater;
        }
        public void setUpdatetime(Date updatetime) {
            this.updatetime = updatetime;
        }
}