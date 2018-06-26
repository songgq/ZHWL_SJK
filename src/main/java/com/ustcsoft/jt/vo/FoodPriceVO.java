package com.ustcsoft.jt.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author mapp
 * @des 粮食质价VO
 * @date 2018/4/11
 */
@ApiModel(value = "质价入参实体", description = "质价入参实体")
public class FoodPriceVO implements Serializable {


    /** 粮食品种 */
    @ApiModelProperty(value = "粮食品种", name = "foodType", example = "01")
    private String foodType;
    /** 总重 */
    @ApiModelProperty(value = "总重", name = "weight", example = "1000")
    private String weight;

    //############################## 小麦 ################################################
    /** 水分 */
    @ApiModelProperty(value = "小麦水分", name = "waterContent", example = "12")
    private String waterContent;
    /** 杂质率 */
    @ApiModelProperty(value = "小麦杂质率", name = "impurityRate", example = "5")
    private String impurityRate ;
    /** 不完善颗粒率 */
    @ApiModelProperty(value = "小麦不完善颗粒率", name = "imperfectionRate", example = "14")
    private String imperfectionRate;
    /** 容量 */
    @ApiModelProperty(value = "小麦容重", name = "capacity", example = "645")
    private String capacity;

    //############################## 中晚籼稻 ################################################
    /** 出糙率 */
    @ApiModelProperty(value = "中晚籼稻出糙率", name = "capacity", example = "75")
    private String ccl;
    @ApiModelProperty(value = "中晚籼稻整精米率", name = "zjml", example = "46")
    private String zjml;
    /** 中晚籼稻水分 */
    @ApiModelProperty(value = "中晚籼稻水分", name = "zwxdsf", example = "4")
    private String zwxdsf;
    /** 中晚籼稻杂质 */
    @ApiModelProperty(value = "中晚籼稻杂质", name = "zwxdzz", example = "1")
    private String zwxdzz;
    /** 中晚籼稻黄粒米 */
    @ApiModelProperty(value = "中晚籼稻黄粒米", name = "zwxdhlmhl", example = "1")
    private String zwxdhlmhl;
    /** 谷外糙米含量 */
    @ApiModelProperty(value = "中晚籼稻谷外糙米含量", name = "zwxdgwcm", example = "1")
    private String zwxdgwcm;
    /** 互混率 */
    @ApiModelProperty(value = "中晚籼稻互混率", name = "zwxdhhl", example = "5")
    private String zwxdhhl;

    //##################################### 粳稻 ##################################################
    @ApiModelProperty(value = "粳稻出糙率", name = "jdccl", example = "81")
    private String jdccl;
    @ApiModelProperty(value = "粳稻整精米率", name = "jdzjml", example = "60")
    private String jdzjml;
    @ApiModelProperty(value = "粳稻水分", name = "jdsf", example = "12")
    private String jdsf;
    @ApiModelProperty(value = "粳稻杂质率", name = "jdzz", example = "1")
    private String jdzz;
    @ApiModelProperty(value = "粳稻黄粒米", name = "jdhlm", example = "1")
    private String jdhlm;
    @ApiModelProperty(value = "粳稻谷外糙米含量", name = "jdgwcm", example = "1")
    private String jdgwcm;
    @ApiModelProperty(value = "粳稻互混率", name = "jdhhl", example = "5")
    private String jdhhl;

    //############################################ 玉米 ################################################
    @ApiModelProperty(value = "玉米容重", name = "ymrz", example = "720")
    private String ymrz;
    @ApiModelProperty(value = "玉米水分", name = "ymsf", example = "5")
    private String ymsf;
    @ApiModelProperty(value = "玉米不完善粒总量", name = "ymzlbwsl", example = "5")
    private String ymzlbwsl;
    @ApiModelProperty(value = "玉米不完善粒生霉素", name = "ymzlbwsl", example = "2")
    private String ymsmsbwsl;
    @ApiModelProperty(value = "玉米杂质", name = "ymzlbwsl", example = "1")
    private String ymzz;


    public String getYmrz() {
        return ymrz;
    }

    public void setYmrz(String ymrz) {
        this.ymrz = ymrz;
    }

    public String getYmsf() {
        return ymsf;
    }

    public void setYmsf(String ymsf) {
        this.ymsf = ymsf;
    }

    public String getYmzlbwsl() {
        return ymzlbwsl;
    }

    public void setYmzlbwsl(String ymzlbwsl) {
        this.ymzlbwsl = ymzlbwsl;
    }

    public String getYmsmsbwsl() {
        return ymsmsbwsl;
    }

    public void setYmsmsbwsl(String ymsmsbwsl) {
        this.ymsmsbwsl = ymsmsbwsl;
    }

    public String getYmzz() {
        return ymzz;
    }

    public void setYmzz(String ymzz) {
        this.ymzz = ymzz;
    }

    public String getJdccl() {
        return jdccl;
    }

    public void setJdccl(String jdccl) {
        this.jdccl = jdccl;
    }

    public String getJdzjml() {
        return jdzjml;
    }

    public void setJdzjml(String jdzjml) {
        this.jdzjml = jdzjml;
    }

    public String getJdsf() {
        return jdsf;
    }

    public void setJdsf(String jdsf) {
        this.jdsf = jdsf;
    }

    public String getJdzz() {
        return jdzz;
    }

    public void setJdzz(String jdzz) {
        this.jdzz = jdzz;
    }

    public String getJdhlm() {
        return jdhlm;
    }

    public void setJdhlm(String jdhlm) {
        this.jdhlm = jdhlm;
    }

    public String getJdgwcm() {
        return jdgwcm;
    }

    public void setJdgwcm(String jdgwcm) {
        this.jdgwcm = jdgwcm;
    }

    public String getJdhhl() {
        return jdhhl;
    }

    public void setJdhhl(String jdhhl) {
        this.jdhhl = jdhhl;
    }

    public String getZjml() {
        return zjml;
    }

    public void setZjml(String zjml) {
        this.zjml = zjml;
    }

    public String getCcl() {
        return ccl;
    }

    public void setCcl(String ccl) {
        this.ccl = ccl;
    }

    public String getZwxdsf() {
        return zwxdsf;
    }

    public void setZwxdsf(String zwxdsf) {
        this.zwxdsf = zwxdsf;
    }

    public String getZwxdzz() {
        return zwxdzz;
    }

    public void setZwxdzz(String zwxdzz) {
        this.zwxdzz = zwxdzz;
    }

    public String getZwxdhlmhl() {
        return zwxdhlmhl;
    }

    public void setZwxdhlmhl(String zwxdhlmhl) {
        this.zwxdhlmhl = zwxdhlmhl;
    }

    public String getZwxdgwcm() {
        return zwxdgwcm;
    }

    public void setZwxdgwcm(String zwxdgwcm) {
        this.zwxdgwcm = zwxdgwcm;
    }

    public String getZwxdhhl() {
        return zwxdhhl;
    }

    public void setZwxdhhl(String zwxdhhl) {
        this.zwxdhhl = zwxdhhl;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWaterContent() {
        return waterContent;
    }

    public void setWaterContent(String waterContent) {
        this.waterContent = waterContent;
    }

    public String getImpurityRate() {
        return impurityRate;
    }

    public void setImpurityRate(String impurityRate) {
        this.impurityRate = impurityRate;
    }

    public String getImperfectionRate() {
        return imperfectionRate;
    }

    public void setImperfectionRate(String imperfectionRate) {
        this.imperfectionRate = imperfectionRate;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
