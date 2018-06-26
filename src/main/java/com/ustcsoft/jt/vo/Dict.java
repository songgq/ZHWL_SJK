package com.ustcsoft.jt.vo;

import java.io.Serializable;

/**
* @author mapp
 *@des 字典
* @date 2018-4-4 13:45:44
*/
public class Dict implements Serializable {

        /**  */
        private String id;
        /** 字典编码 */
        private String code;
        /** 字典值 */
        private String value;
        /** 字典类型ID */
        private String dictTypeId;
        /** 0:禁用 1 启用 */
        private String status;

        /** 名称 */
        private String name;

        /** 粮食价格 */
        private String lsjg;

        public String getLsjg() {
            return lsjg;
        }

        public void setLsjg(String lsjg) {
            this.lsjg = lsjg;
        }

        public String getId() {
            return id;
        }
        public String getCode() {
            return code;
        }
        public String getValue() {
            return value;
        }
        public String getDictTypeId() {
            return dictTypeId;
        }
        public String getStatus() {
            return status;
        }

        public void setId(String id) {
            this.id = id;
        }
        public void setCode(String code) {
            this.code = code;
        }
        public void setValue(String value) {
            this.value = value;
        }
        public void setDictTypeId(String dictTypeId) {
            this.dictTypeId = dictTypeId;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
}