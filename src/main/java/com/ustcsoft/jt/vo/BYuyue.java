package com.ustcsoft.jt.vo;

import com.ustcsoft.framework.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import springfox.documentation.annotations.ApiIgnore;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * @author mapp
 * @date 2018-4-3 9:43:09
 */
@ApiModel(value = "预约信息实体", description = "预约信息实体")
public class BYuyue extends BaseVO {

    @ApiModelProperty(hidden = true)
    private String id;
    @ApiModelProperty(value = "购销计划Id", name = "gxjhId")
    private String gxid;
    @ApiModelProperty(value = "粮食品种", name = "lspz", example = "01")
    private String lspz;
    @ApiModelProperty(value = "预约时间", name = "yysj", example = "2018-04-03")
    private Date yysj;
    @ApiModelProperty(value = "预约数量", name = "yysl", example = "100")
    private String yysl;
    @ApiModelProperty(value = "卖粮人姓名", name = "mlrxm", example = "张三")
    private String mlrxm;
    @ApiModelProperty(value = "卖粮人手机号", name = "mlrsjh", example = "18726158888")
    private String mlrsjh;
    @ApiModelProperty(value = "承运人姓名", name = "cyrxm", example = "赵四")
    private String cyrxm;
    @ApiModelProperty(value = "承运人手机号", name = "cyrsjh", example = "18726158888")
    private String cyrsjh;
    @ApiModelProperty(value = "承运人身份证号码", name = "cyrsfz", example = "")
    private String cyrsfz;
    @ApiModelProperty(value = "运粮车牌号", name = "ylcph", example = "")
    private String ylcph;
    /** 预约状态 */
    @ApiModelProperty(hidden = true)
    private String status;
    /** 实际入库量 */
    @ApiModelProperty(hidden = true)
    private String sjrkl;


    public String getId() {
        return id;
    }

    public String getLspz() {
        return lspz;
    }

    public Date getYysj() {
        return yysj;
    }

    public String getYysl() {
        return yysl;
    }

    public String getMlrxm() {
        return mlrxm;
    }

    public String getMlrsjh() {
        return mlrsjh;
    }

    public String getCyrxm() {
        return cyrxm;
    }

    public String getCyrsjh() {
        return cyrsjh;
    }

    public String getCyrsfz() {
        return cyrsfz;
    }

    public String getYlcph() {
        return ylcph;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLspz(String lspz) {
        this.lspz = lspz;
    }

    public void setYysj(String yysj) throws ParseException {
        this.yysj = DateUtils.parseDate(yysj, new String[]{"yyyy-MM-dd"});
    }

    public void setYysl(String yysl) {
        this.yysl = yysl;
    }

    public void setMlrxm(String mlrxm) {
        this.mlrxm = mlrxm;
    }

    public void setMlrsjh(String mlrsjh) {
        this.mlrsjh = mlrsjh;
    }

    public void setCyrxm(String cyrxm) {
        this.cyrxm = cyrxm;
    }

    public void setCyrsjh(String cyrsjh) {
        this.cyrsjh = cyrsjh;
    }

    public void setCyrsfz(String cyrsfz) {
        this.cyrsfz = cyrsfz;
    }

    public void setYlcph(String ylcph) {
        this.ylcph = ylcph;
    }

    public String getGxid() {
        return gxid;
    }

    public void setGxid(String gxid) {
        this.gxid = gxid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSjrkl() {
        return sjrkl;
    }

    public void setSjrkl(String sjrkl) {
        this.sjrkl = sjrkl;
    }

}