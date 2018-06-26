package com.ustcsoft.jt.vo;

/**
 * 药品管理详情to:b_drug_manage_detail
 * Created by Administrator on 2018/5/9.
 */
public class DrugManageDetail {
    private int id;
    /** 业务类型 */
    private String business_type;
    /** 业务类型名称 */
    private String business_typename;
    /** 业务数量 */
    private String business_count;
    /** 结存数量 */
    private String balance_count;
    /** 空瓶处理数量 */
    private String emptyhanding_count;
    /** 领购人 */
    private String business_man;
    /** 业务时间yyyyMMddHHmmss */
    private String business_time;
    /** 业务原因 */
    private String business_cause;

    private String production_date;
    private String expire_date;
    private String drug_id;
    private String control_man;
    private String use_man;

    /** 备注 */
    private String remarks;
    /** 药品管理id */
    private int durgManageId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(String business_type) {
        this.business_type = business_type;
    }

    public String getBusiness_typename() {
        return business_typename;
    }

    public void setBusiness_typename(String business_typename) {
        this.business_typename = business_typename;
    }

    public String getBusiness_count() {
        return business_count;
    }

    public void setBusiness_count(String business_count) {
        this.business_count = business_count;
    }

    public String getBalance_count() {
        return balance_count;
    }

    public void setBalance_count(String balance_count) {
        this.balance_count = balance_count;
    }

    public String getEmptyhanding_count() {
        return emptyhanding_count;
    }

    public void setEmptyhanding_count(String emptyhanding_count) {
        this.emptyhanding_count = emptyhanding_count;
    }

    public String getBusiness_man() {
        return business_man;
    }

    public void setBusiness_man(String business_man) {
        this.business_man = business_man;
    }

    public String getBusiness_time() {
        return business_time;
    }

    public void setBusiness_time(String business_time) {
        this.business_time = business_time;
    }

    public String getBusiness_cause() {
        return business_cause;
    }

    public void setBusiness_cause(String business_cause) {
        this.business_cause = business_cause;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getDurgManageId() {
        return durgManageId;
    }

    public void setDurgManageId(int durgManageId) {
        this.durgManageId = durgManageId;
    }

    public String getProduction_date() {
        return production_date;
    }

    public void setProduction_date(String production_date) {
        this.production_date = production_date;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public String getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(String drug_id) {
        this.drug_id = drug_id;
    }

    public String getControl_man() {
        return control_man;
    }

    public void setControl_man(String control_man) {
        this.control_man = control_man;
    }

    public String getUse_man() {
        return use_man;
    }

    public void setUse_man(String use_man) {
        this.use_man = use_man;
    }
}
