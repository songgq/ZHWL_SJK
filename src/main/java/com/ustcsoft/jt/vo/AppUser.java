package com.ustcsoft.jt.vo;

import java.io.Serializable;

/**
* @author mapp
* @date 2018-3-28 12:28:54
*/
public class AppUser implements Serializable{

        /**  */
        private String id;
        /**  */
        private String username;
        /**  */
        private String password;
        /**  */
        private String realname;
        /**  */
        private String status;
        /**  */
        private String phonenum;
        /**  */
        private String dizhi;
        /**  */
        private String idcard;

        public String getId() {
            return id;
        }
        public String getUsername() {
            return username;
        }
        public String getPassword() {
            return password;
        }
        public String getRealname() {
            return realname;
        }
        public String getStatus() {
            return status;
        }
        public String getPhonenum() {
            return phonenum;
        }
        public String getDizhi() {
            return dizhi;
        }
        public String getIdcard() {
            return idcard;
        }

        public void setId(String id) {
            this.id = id;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public void setRealname(String realname) {
            this.realname = realname;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        public void setPhonenum(String phonenum) {
            this.phonenum = phonenum;
        }
        public void setDizhi(String dizhi) {
            this.dizhi = dizhi;
        }
        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }
}