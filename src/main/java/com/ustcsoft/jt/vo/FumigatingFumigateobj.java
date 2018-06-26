package com.ustcsoft.jt.vo;

import java.math.BigDecimal;

/**
 * 熏蒸_对象 to: b_fumigating_fumigateobj
 */
public class FumigatingFumigateobj {
    private Integer id;

    private String storehouse_id;//
    private String storehouse_gb_code;
    private String storehouse_name;//
    private String warehouse_id;//
    private String warehouse_gb_code;
    private String warehouse_name;//

    private String grain_kind;

    private String kind_name;

    private BigDecimal grain_count;

    private String packingmode_code;
    private String packingmode;//
    private String pest;

    private String pest_density;

    private String putin_time;

    private String fumigate_lasttiime;

    private String fumigate_plantime;

    private String plandrug_count;

    private String plandrug_count_unit;

    private String remarks;

    private Integer fumigating_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStorehouse_gb_code() {
        return storehouse_gb_code;
    }

    public void setStorehouse_gb_code(String storehouse_gb_code) {
        this.storehouse_gb_code = storehouse_gb_code == null ? null : storehouse_gb_code.trim();
    }

    public String getWarehouse_gb_code() {
        return warehouse_gb_code;
    }

    public void setWarehouse_gb_code(String warehouse_gb_code) {
        this.warehouse_gb_code = warehouse_gb_code == null ? null : warehouse_gb_code.trim();
    }

    public String getGrain_kind() {
        return grain_kind;
    }

    public void setGrain_kind(String grain_kind) {
        this.grain_kind = grain_kind == null ? null : grain_kind.trim();
    }

    public String getKind_name() {
        return kind_name;
    }

    public void setKind_name(String kind_name) {
        this.kind_name = kind_name == null ? null : kind_name.trim();
    }

    public BigDecimal getGrain_count() {
        return grain_count;
    }

    public void setGrain_count(BigDecimal grain_count) {
        this.grain_count = grain_count;
    }

    public String getPackingmode_code() {
        return packingmode_code;
    }

    public void setPackingmode_code(String packingmode_code) {
        this.packingmode_code = packingmode_code == null ? null : packingmode_code.trim();
    }

    public String getPest() {
        return pest;
    }

    public void setPest(String pest) {
        this.pest = pest == null ? null : pest.trim();
    }

    public String getPest_density() {
        return pest_density;
    }

    public void setPest_density(String pest_density) {
        this.pest_density = pest_density == null ? null : pest_density.trim();
    }

    public String getPutin_time() {
        return putin_time;
    }

    public void setPutin_time(String putin_time) {
        this.putin_time = putin_time == null ? null : putin_time.trim();
    }

    public String getFumigate_lasttiime() {
        return fumigate_lasttiime;
    }

    public void setFumigate_lasttiime(String fumigate_lasttiime) {
        this.fumigate_lasttiime = fumigate_lasttiime == null ? null : fumigate_lasttiime.trim();
    }

    public String getFumigate_plantime() {
        return fumigate_plantime;
    }

    public void setFumigate_plantime(String fumigate_plantime) {
        this.fumigate_plantime = fumigate_plantime == null ? null : fumigate_plantime.trim();
    }

    public String getPlandrug_count() {
        return plandrug_count;
    }

    public void setPlandrug_count(String plandrug_count) {
        this.plandrug_count = plandrug_count == null ? null : plandrug_count.trim();
    }

    public String getPlandrug_count_unit() {
        return plandrug_count_unit;
    }

    public void setPlandrug_count_unit(String plandrug_count_unit) {
        this.plandrug_count_unit = plandrug_count_unit == null ? null : plandrug_count_unit.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getFumigating_id() {
        return fumigating_id;
    }

    public void setFumigating_id(Integer fumigating_id) {
        this.fumigating_id = fumigating_id;

    }

    public String getStorehouse_id() {
        return storehouse_id;
    }

    public void setStorehouse_id(String storehouse_id) {
        this.storehouse_id = storehouse_id;
    }

    public String getStorehouse_name() {
        return storehouse_name;
    }

    public void setStorehouse_name(String storehouse_name) {
        this.storehouse_name = storehouse_name;
    }

    public String getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(String warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public String getPackingmode() {
        return packingmode;
    }

    public void setPackingmode(String packingmode) {
        this.packingmode = packingmode;
    }
}