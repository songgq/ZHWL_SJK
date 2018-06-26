package com.ustcsoft.jt.vo;

/**
 * 熏蒸_人员 to:b_fumigating_fumigateman
 */
public class FumigatingFumigateman {
    private Integer id;

    private String name;

    private String job;

    private String credentials;

    private String bodystatus;

    private String division;

    private String isoutworker;

    private String remarks;

    private Integer fumigating_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials == null ? null : credentials.trim();
    }

    public String getBodystatus() {
        return bodystatus;
    }

    public void setBodystatus(String bodystatus) {
        this.bodystatus = bodystatus == null ? null : bodystatus.trim();
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division == null ? null : division.trim();
    }

    public String getIsoutworker() {
        return isoutworker;
    }

    public void setIsoutworker(String isoutworker) {
        this.isoutworker = isoutworker == null ? null : isoutworker.trim();
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
}