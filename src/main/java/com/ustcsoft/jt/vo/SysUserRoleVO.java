package com.ustcsoft.jt.vo;

import com.ustcsoft.framework.vo.BaseVO;

/**
 * 用户角色关系VO
 * @author lc
 *
 */
public class SysUserRoleVO extends BaseVO{
	private static final long serialVersionUID = -8467699174700723417L;
	private String userId;
    private String roleId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
    
}
