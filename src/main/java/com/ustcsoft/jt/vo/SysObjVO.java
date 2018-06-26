package com.ustcsoft.jt.vo;

import com.ustcsoft.framework.vo.BaseVO;

public class SysObjVO extends BaseVO
{
    private static final long serialVersionUID = 1L;
    private Long objId;
    private String objCode;
    private String objName;
    private String busiCode;
    private Long menuId;
    private Long roleId;
    private String flag;
    
	public Long getObjId() {
		return objId;
	}
	public void setObjId(Long objId) {
		this.objId = objId;
	}
	public String getObjCode() {
		return objCode;
	}
	public void setObjCode(String objCode) {
		this.objCode = objCode;
	}
	public String getObjName() {
		return objName;
	}
	public void setObjName(String objName) {
		this.objName = objName;
	}
	public String getBusiCode() {
		return busiCode;
	}
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getFlag() {
		return flag;
	}
}