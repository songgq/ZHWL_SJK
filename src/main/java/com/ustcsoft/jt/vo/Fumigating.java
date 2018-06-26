package com.ustcsoft.jt.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 熏蒸数据 to:b_fumigating
 */
public class Fumigating {
    private Integer id;

    private String application_date;

    private String liable_man;

    private String telephone;

    private String drug_name;

    private String drug_kind;

    private String expiry_date;

    private BigDecimal receive_count;

    private String receive_units;

    private BigDecimal use_count;

    private String use_units;

    private String store_place;

    private String receive_man;

    private String receive_time;

    private String fumigate_type;

    private String type_name;

    private String residues_treated;

    private String warn_distance;

    private String conserve_time;

    private String conserver;

    private String write_man;

    private String write_tel;

    private String write_email;

    private String original_id;

    private String email;

    private String orgCode;

    private String entCode;
    private String conserve_advice;

    private String remarks;
    private List<FumigatingFumigateman> fumigateman;
    private List<FumigatingFumigateobj> fumigateobj;
    public String getConserve_advice() {
        return conserve_advice;
    }

    public void setConserve_advice(String conserve_advice) {
        this.conserve_advice = conserve_advice == null ? null : conserve_advice.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplication_date() {
        return application_date;
    }

    public void setApplication_date(String application_date) {
        this.application_date = application_date == null ? null : application_date.trim();
    }

    public String getLiable_man() {
        return liable_man;
    }

    public void setLiable_man(String liable_man) {
        this.liable_man = liable_man == null ? null : liable_man.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name == null ? null : drug_name.trim();
    }

    public String getDrug_kind() {
        return drug_kind;
    }

    public void setDrug_kind(String drug_kind) {
        this.drug_kind = drug_kind == null ? null : drug_kind.trim();
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date == null ? null : expiry_date.trim();
    }

    public BigDecimal getReceive_count() {
        return receive_count;
    }

    public void setReceive_count(BigDecimal receive_count) {
        this.receive_count = receive_count;
    }

    public String getReceive_units() {
        return receive_units;
    }

    public void setReceive_units(String receive_units) {
        this.receive_units = receive_units == null ? null : receive_units.trim();
    }

    public BigDecimal getUse_count() {
        return use_count;
    }

    public void setUse_count(BigDecimal use_count) {
        this.use_count = use_count;
    }

    public String getUse_units() {
        return use_units;
    }

    public void setUse_units(String use_units) {
        this.use_units = use_units == null ? null : use_units.trim();
    }

    public String getStore_place() {
        return store_place;
    }

    public void setStore_place(String store_place) {
        this.store_place = store_place == null ? null : store_place.trim();
    }

    public String getReceive_man() {
        return receive_man;
    }

    public void setReceive_man(String receive_man) {
        this.receive_man = receive_man == null ? null : receive_man.trim();
    }

    public String getReceive_time() {
        return receive_time;
    }

    public void setReceive_time(String receive_time) {
        this.receive_time = receive_time == null ? null : receive_time.trim();
    }

    public String getFumigate_type() {
        return fumigate_type;
    }

    public void setFumigate_type(String fumigate_type) {
        this.fumigate_type = fumigate_type == null ? null : fumigate_type.trim();
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name == null ? null : type_name.trim();
    }

    public String getResidues_treated() {
        return residues_treated;
    }

    public void setResidues_treated(String residues_treated) {
        this.residues_treated = residues_treated == null ? null : residues_treated.trim();
    }

    public String getWarn_distance() {
        return warn_distance;
    }

    public void setWarn_distance(String warn_distance) {
        this.warn_distance = warn_distance == null ? null : warn_distance.trim();
    }

    public String getConserve_time() {
        return conserve_time;
    }

    public void setConserve_time(String conserve_time) {
        this.conserve_time = conserve_time == null ? null : conserve_time.trim();
    }

    public String getConserver() {
        return conserver;
    }

    public void setConserver(String conserver) {
        this.conserver = conserver == null ? null : conserver.trim();
    }

    public String getWrite_man() {
        return write_man;
    }

    public void setWrite_man(String write_man) {
        this.write_man = write_man == null ? null : write_man.trim();
    }

    public String getWrite_tel() {
        return write_tel;
    }

    public void setWrite_tel(String write_tel) {
        this.write_tel = write_tel == null ? null : write_tel.trim();
    }

    public String getWrite_email() {
        return write_email;
    }

    public void setWrite_email(String write_email) {
        this.write_email = write_email == null ? null : write_email.trim();
    }

    public String getOriginal_id() {
        return original_id;
    }

    public void setOriginal_id(String original_id) {
        this.original_id = original_id == null ? null : original_id.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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

    public List<FumigatingFumigateman> getFumigateman() {
        return fumigateman;
    }

    public void setFumigateman(List<FumigatingFumigateman> fumigateman) {
        this.fumigateman = fumigateman;
    }

    public List<FumigatingFumigateobj> getFumigateobj() {
        return fumigateobj;
    }

    public void setFumigateobj(List<FumigatingFumigateobj> fumigateobj) {
        this.fumigateobj = fumigateobj;
    }
}