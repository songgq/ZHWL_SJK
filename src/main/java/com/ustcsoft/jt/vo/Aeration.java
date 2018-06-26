package com.ustcsoft.jt.vo;

import java.util.List;

/**
 * 机械通风信息 to:b_aeration
 */
public class Aeration {
    private Integer id;

    private String storehouse;

    private String house;

    private String allocation;

    private String liable_man;

    private String aeration_type_code;

    private String aeration_mode_code;

    private String aeration_machine_code;

    private String aeration_machine;

    private String aerationgoal_code;

    private String goods_kinds;

    private String goods_height;

    private String blowing_intype;

    private String sum_electricity;

    private String sum_blowing_rate;

    private String blowernet_drag;

    private String unit_blowing_rate;

    private String max_grAdient_degree_begin;

    private String max_grAdient_degree_end;

    private String max_grAdient_water_begin;

    private String max_grAdient_water_end;

    private String degree;

    private String humidity;

    private String executiveDate;

    private String recordRegdate;

    private String blowingBegintime;

    private String blowingEndtime;

    private String original_id;

    private String remarks;

    private String orgCode;

    private String entCode;

    private List<AerationJob> aerationjob;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStorehouse() {
        return storehouse;
    }

    public void setStorehouse(String storehouse) {
        this.storehouse = storehouse == null ? null : storehouse.trim();
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house == null ? null : house.trim();
    }

    public String getAllocation() {
        return allocation;
    }

    public void setAllocation(String allocation) {
        this.allocation = allocation == null ? null : allocation.trim();
    }

    public String getLiable_man() {
        return liable_man;
    }

    public void setLiable_man(String liable_man) {
        this.liable_man = liable_man == null ? null : liable_man.trim();
    }

    public String getAeration_type_code() {
        return aeration_type_code;
    }

    public void setAeration_type_code(String aeration_type_code) {
        this.aeration_type_code = aeration_type_code == null ? null : aeration_type_code.trim();
    }

    public String getAeration_mode_code() {
        return aeration_mode_code;
    }

    public void setAeration_mode_code(String aeration_mode_code) {
        this.aeration_mode_code = aeration_mode_code == null ? null : aeration_mode_code.trim();
    }

    public String getAeration_machine_code() {
        return aeration_machine_code;
    }

    public void setAeration_machine_code(String aeration_machine_code) {
        this.aeration_machine_code = aeration_machine_code == null ? null : aeration_machine_code.trim();
    }

    public String getAeration_machine() {
        return aeration_machine;
    }

    public void setAeration_machine(String aeration_machine) {
        this.aeration_machine = aeration_machine == null ? null : aeration_machine.trim();
    }

    public String getAerationgoal_code() {
        return aerationgoal_code;
    }

    public void setAerationgoal_code(String aerationgoal_code) {
        this.aerationgoal_code = aerationgoal_code == null ? null : aerationgoal_code.trim();
    }

    public String getGoods_kinds() {
        return goods_kinds;
    }

    public void setGoods_kinds(String goods_kinds) {
        this.goods_kinds = goods_kinds == null ? null : goods_kinds.trim();
    }

    public String getGoods_height() {
        return goods_height;
    }

    public void setGoods_height(String goods_height) {
        this.goods_height = goods_height == null ? null : goods_height.trim();
    }

    public String getBlowing_intype() {
        return blowing_intype;
    }

    public void setBlowing_intype(String blowing_intype) {
        this.blowing_intype = blowing_intype == null ? null : blowing_intype.trim();
    }

    public String getSum_electricity() {
        return sum_electricity;
    }

    public void setSum_electricity(String sum_electricity) {
        this.sum_electricity = sum_electricity == null ? null : sum_electricity.trim();
    }

    public String getSum_blowing_rate() {
        return sum_blowing_rate;
    }

    public void setSum_blowing_rate(String sum_blowing_rate) {
        this.sum_blowing_rate = sum_blowing_rate == null ? null : sum_blowing_rate.trim();
    }

    public String getBlowernet_drag() {
        return blowernet_drag;
    }

    public void setBlowernet_drag(String blowernet_drag) {
        this.blowernet_drag = blowernet_drag == null ? null : blowernet_drag.trim();
    }

    public String getUnit_blowing_rate() {
        return unit_blowing_rate;
    }

    public void setUnit_blowing_rate(String unit_blowing_rate) {
        this.unit_blowing_rate = unit_blowing_rate == null ? null : unit_blowing_rate.trim();
    }

    public String getMax_grAdient_degree_begin() {
        return max_grAdient_degree_begin;
    }

    public void setMax_grAdient_degree_begin(String max_grAdient_degree_begin) {
        this.max_grAdient_degree_begin = max_grAdient_degree_begin == null ? null : max_grAdient_degree_begin.trim();
    }

    public String getMax_grAdient_degree_end() {
        return max_grAdient_degree_end;
    }

    public void setMax_grAdient_degree_end(String max_grAdient_degree_end) {
        this.max_grAdient_degree_end = max_grAdient_degree_end == null ? null : max_grAdient_degree_end.trim();
    }

    public String getMax_grAdient_water_begin() {
        return max_grAdient_water_begin;
    }

    public void setMax_grAdient_water_begin(String max_grAdient_water_begin) {
        this.max_grAdient_water_begin = max_grAdient_water_begin == null ? null : max_grAdient_water_begin.trim();
    }

    public String getMax_grAdient_water_end() {
        return max_grAdient_water_end;
    }

    public void setMax_grAdient_water_end(String max_grAdient_water_end) {
        this.max_grAdient_water_end = max_grAdient_water_end == null ? null : max_grAdient_water_end.trim();
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity == null ? null : humidity.trim();
    }

    public String getExecutiveDate() {
        return executiveDate;
    }

    public void setExecutiveDate(String executiveDate) {
        this.executiveDate = executiveDate == null ? null : executiveDate.trim();
    }

    public String getRecordRegdate() {
        return recordRegdate;
    }

    public void setRecordRegdate(String recordRegdate) {
        this.recordRegdate = recordRegdate == null ? null : recordRegdate.trim();
    }

    public String getBlowingBegintime() {
        return blowingBegintime;
    }

    public void setBlowingBegintime(String blowingBegintime) {
        this.blowingBegintime = blowingBegintime == null ? null : blowingBegintime.trim();
    }

    public String getBlowingEndtime() {
        return blowingEndtime;
    }

    public void setBlowingEndtime(String blowingEndtime) {
        this.blowingEndtime = blowingEndtime == null ? null : blowingEndtime.trim();
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

    public String getEntCode() {
        return entCode;
    }

    public void setEntCode(String entCode) {
        this.entCode = entCode;
    }

    public List<AerationJob> getAerationjob() {
        return aerationjob;
    }

    public void setAerationjob(List<AerationJob> aerationjob) {
        this.aerationjob = aerationjob;
    }
}