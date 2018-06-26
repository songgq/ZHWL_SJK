package com.ustcsoft.jt.service;

import java.util.List;
import java.util.Map;

import com.ustcsoft.framework.vo.UserVO;
import com.ustcsoft.jt.mybatis.Page;
import com.ustcsoft.jt.vo.SysMenuVO;
import com.ustcsoft.jt.vo.SysRoleVO;

public interface SysRoleService {

	void deleteSysRole(String roleId);
	
	Page<SysRoleVO> queryAllSysRoleInCurrentOrg(SysRoleVO role,String userId,int page, int rows);

	List<SysMenuVO> selectSysMenus(String userId,SysMenuVO _sysMenu);

    int editRole(SysRoleVO sysRole,UserVO userInfo);

    void setRole(UserVO userInfo, String menuIds,String roleId);

	void setUserRole(Map<String, String> map);


}
