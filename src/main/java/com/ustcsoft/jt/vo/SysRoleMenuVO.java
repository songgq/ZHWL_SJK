package com.ustcsoft.jt.vo;

import com.ustcsoft.framework.vo.BaseVO;

public class SysRoleMenuVO extends BaseVO{
	private static final long serialVersionUID = 6317979848931222825L;
		private String roleId;
	    private String menuId;
		public String getRoleId() {
			return roleId;
		}
		public void setRoleId(String roleId) {
			this.roleId = roleId;
		}
		public String getMenuId() {
			return menuId;
		}
		public void setMenuId(String menuId) {
			this.menuId = menuId;
		}
	    

}
