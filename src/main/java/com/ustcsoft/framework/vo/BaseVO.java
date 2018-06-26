package com.ustcsoft.framework.vo;

import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基本VO
 */
public class BaseVO implements Serializable{

	private static final long serialVersionUID = 2051472917667444164L;
	@ApiModelProperty(hidden = true)
	private String delFlg;
	@ApiModelProperty(hidden = true)
	private String creater;
	@ApiModelProperty(hidden = true)
	private Timestamp createTime;
	@ApiModelProperty(hidden = true)
	private String updater;
	@ApiModelProperty(hidden = true)
	private Timestamp updateTime;
	@ApiModelProperty(hidden = true)
	private String createrTimeStr;
	@ApiModelProperty(hidden = true)
	private String updaterTimeStr;
	private Long rowVersion;
	@ApiModelProperty(hidden = true)
	private String jsonStr;
	@ApiModelProperty(hidden = true)
	private String userOrgId;
	@ApiModelProperty(hidden = true)
	private String userDeptId;
	@ApiModelProperty(hidden = true)
	private SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Long getRowVersion() {
		return rowVersion;
	}

	public void setRowVersion(Long rowVersion) {
		this.rowVersion = rowVersion;
	}

	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}

	public void setCreaterTimeStr(String createrTimeStr) {
		this.createrTimeStr = createrTimeStr;
	}

	public void setUpdaterTimeStr(String updaterTimeStr) {
		this.updaterTimeStr = updaterTimeStr;
	}

	public String getCreaterTimeStr() {
		if (this.createTime != null) {
			return dateformat.format(getCreateTime());
		}
		return "";
	}

	public String getUpdaterTimeStr() {
		if (this.updateTime != null) {
			return dateformat.format(getUpdateTime());
		}
		return "";
	}

	public String getUserOrgId() {
		return userOrgId;
	}

	public void setUserOrgId(String userOrgId) {
		this.userOrgId = userOrgId;
	}

	public String getUserDeptId() {
		return userDeptId;
	}

	public void setUserDeptId(String userDeptId) {
		this.userDeptId = userDeptId;
	}
}