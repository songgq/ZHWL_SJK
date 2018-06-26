package com.ustcsoft.jt.vo;

/**
 * 通风作业 to:b_aeration_job
 */
public class AerationJob {
    private Integer id;

    private String outside_degree;

    private String outside_humidity;

    private String begin_goods_degree;

    private String end_goods_degree;

    private String begin_goods_water;

    private String end_goods_water;
    private int aeration_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOutside_degree() {
        return outside_degree;
    }

    public void setOutside_degree(String outside_degree) {
        this.outside_degree = outside_degree == null ? null : outside_degree.trim();
    }

    public String getOutside_humidity() {
        return outside_humidity;
    }

    public void setOutside_humidity(String outside_humidity) {
        this.outside_humidity = outside_humidity == null ? null : outside_humidity.trim();
    }

    public String getBegin_goods_degree() {
        return begin_goods_degree;
    }

    public void setBegin_goods_degree(String begin_goods_degree) {
        this.begin_goods_degree = begin_goods_degree == null ? null : begin_goods_degree.trim();
    }

    public String getEnd_goods_degree() {
        return end_goods_degree;
    }

    public void setEnd_goods_degree(String end_goods_degree) {
        this.end_goods_degree = end_goods_degree == null ? null : end_goods_degree.trim();
    }

    public String getBegin_goods_water() {
        return begin_goods_water;
    }

    public void setBegin_goods_water(String begin_goods_water) {
        this.begin_goods_water = begin_goods_water == null ? null : begin_goods_water.trim();
    }

    public String getEnd_goods_water() {
        return end_goods_water;
    }

    public void setEnd_goods_water(String end_goods_water) {
        this.end_goods_water = end_goods_water == null ? null : end_goods_water.trim();
    }

    public int getAeration_id() {
        return aeration_id;
    }

    public void setAeration_id(int aeration_id) {
        this.aeration_id = aeration_id;
    }
}