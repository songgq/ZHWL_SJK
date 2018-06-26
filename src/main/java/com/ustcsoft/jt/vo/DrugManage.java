package com.ustcsoft.jt.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 药品管理 to:b_drug_manage
 */
public class DrugManage {
    private Integer id;
    /** 药品编码 */
    private String drug_code;
    /** 药品名称 */
    private String drug_name;
    /** 药品剂型 */
    private String drug_type;
    /** 单位 */
    private String units;
    /** 规格描述 */
    private String specifications;
    /** 购入数量 */
    private BigDecimal buy_count;
    /** 领取数量 */
    private BigDecimal receive_count;
    /** 剩余数量 */
    private BigDecimal surplus_count;
    /** 生产日期yyyyMMddHHmmss */
    private String production_date;
    /** 过期日期yyyyMMddHHmmss  */
    private String expire_date;
    /** 监管责任人 */
    private String control_man;
    /** */
    private String batch_id;
    /** 原始记录id */
    private String original_id;
    /** 备注 */
    private String remarks;
    /** 库点国标编码 */
    private String orgCode;
    /** 企业组织机构代码 */
    private String entCode;
    private List<DrugManageDetail> detail;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrug_code() {
        return drug_code;
    }

    public void setDrug_code(String drug_code) {
        this.drug_code = drug_code == null ? null : drug_code.trim();
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name == null ? null : drug_name.trim();
    }

    public String getDrug_type() {
        return drug_type;
    }

    public void setDrug_type(String drug_type) {
        this.drug_type = drug_type == null ? null : drug_type.trim();
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public BigDecimal getBuy_count() {
        return buy_count;
    }

    public void setBuy_count(BigDecimal buy_count) {
        this.buy_count = buy_count;
    }

    public BigDecimal getReceive_count() {
        return receive_count;
    }

    public void setReceive_count(BigDecimal receive_count) {
        this.receive_count = receive_count;
    }

    public BigDecimal getSurplus_count() {
        return surplus_count;
    }

    public void setSurplus_count(BigDecimal surplus_count) {
        this.surplus_count = surplus_count;
    }

    public String getProduction_date() {
        return production_date;
    }

    public void setProduction_date(String production_date) {
        this.production_date = production_date == null ? null : production_date.trim();
    }

    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date == null ? null : expire_date.trim();
    }

    public String getControl_man() {
        return control_man;
    }

    public void setControl_man(String control_man) {
        this.control_man = control_man == null ? null : control_man.trim();
    }

    public String getOriginal_id() {
        return original_id;
    }

    public void setOriginal_id(String original_id) {
        this.original_id = original_id == null ? null : original_id.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public List<DrugManageDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<DrugManageDetail> detail) {
        this.detail = detail;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public String getEntCode() {
        return entCode;
    }

    public void setEntCode(String entCode) {
        this.entCode = entCode;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }
}