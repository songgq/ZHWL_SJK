package com.ustcsoft.jt.vo;

import com.ustcsoft.framework.vo.BaseVO;

public class SysRoleVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	private String roleId;
	private String roleName;
	private String remark;
	private String delflg;
	private String roleCode;
	private String flag;
	
	// 创建者组织机构ID
	private String createrOrgId;
	// 创建者用户ID
	private String ceraterUserId;
	// 创建者组织机构
	private String createrOrgName;
	// 创建者用户
	private String ceraterUserName;
	
	// 当前操作该角色的用户ID
	private String operaterId;
	
	// 是否是系统角色  1是（所有人可见），0不是（非所有人可见）
	private String isSysRole;
	/*
	 * 用户角色
	 * 0：系统管理，1：许可业务，2：处罚业务，3：领导审批，4，特殊角色
	 */
	private String roleType;
	/*
	 * 所属行业
	 * 00：交通主管部门，01：公路，02：运管，03:海事，04：质监，05：港航，06：通用
	 */
	private String roleHy;

	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setDelflg(String delflg) {
		this.delflg = delflg;
	}
	public String getDelflg() {
		return delflg;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getCreaterOrgId() {
		return createrOrgId;
	}
	public void setCreaterOrgId(String createrOrgId) {
		this.createrOrgId = createrOrgId;
	}
	public String getCeraterUserId() {
		return ceraterUserId;
	}
	public void setCeraterUserId(String ceraterUserId) {
		this.ceraterUserId = ceraterUserId;
	}
	public String getOperaterId() {
		return operaterId;
	}
	public void setOperaterId(String operaterId) {
		this.operaterId = operaterId;
	}
	public String getCreaterOrgName() {
		return createrOrgName;
	}
	public void setCreaterOrgName(String createrOrgName) {
		this.createrOrgName = createrOrgName;
	}
	public String getCeraterUserName() {
		return ceraterUserName;
	}
	public void setCeraterUserName(String ceraterUserName) {
		this.ceraterUserName = ceraterUserName;
	}
	public String getIsSysRole() {
		return isSysRole;
	}
	public void setIsSysRole(String isSysRole) {
		this.isSysRole = isSysRole;
	}
	public String getRoleHy() {
		return roleHy;
	}
	public void setRoleHy(String roleHy) {
		this.roleHy = roleHy;
	}

}