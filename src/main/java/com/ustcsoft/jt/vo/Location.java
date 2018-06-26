package com.ustcsoft.jt.vo;

import java.io.Serializable;

/**
 * @author mapp
 * @des 经纬度
 * @date 2018/4/17
 */
public class Location implements Serializable{

    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
