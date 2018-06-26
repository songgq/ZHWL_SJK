package com.ustcsoft.jt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ustcsoft.jt.mybatis.Page;
import com.ustcsoft.jt.vo.SysMenuVO;
import com.ustcsoft.jt.vo.SysRoleMenuVO;
import com.ustcsoft.jt.vo.SysRoleVO;
import com.ustcsoft.jt.vo.SysUserRoleVO;

public interface SysRoleMapper {

	long isCJGLY(@Param("userId") String userId);

	long isZTDWGLY(@Param("userId") String userId);

	List<SysRoleVO> queryAllSysRoleInCurrentOrgPage(@Param("role") SysRoleVO role, @Param("page") Page<SysRoleVO> page);

	List<SysRoleVO> queryAllSysRoleInCurrentOrgNoCJGLYPage(@Param("role") SysRoleVO role,
			@Param("page") Page<SysRoleVO> page);

	List<SysRoleVO> queryAllSysRoleInCurrentOrgNoGLYPage(@Param("role") SysRoleVO role,
			@Param("page") Page<SysRoleVO> page);

	void insertSysRole(SysRoleVO sysRole);

	void updateSysRole(SysRoleVO sysRole);

	void deleteSysRole(String roleId);

	Long findMaxId();

	List selectSysMenusAndObj4RoleAdmin(SysMenuVO _sysMenu);

	List selectSysMenusAndObj4Role(SysMenuVO _sysMenu);

	void deleteSysRoleMenuByRoleId(@Param("roleId") String roleId);

	void deleteSysRoleMenuByRoleIdAndUserId(@Param("opRole") SysRoleVO opRole);

	void insertSysRoleMenu(@Param("roleMenu") SysRoleMenuVO roleMenu);

	long isAdmin(@Param("userId") String userId);

	void insertSysUserRole(@Param("userRole") SysUserRoleVO userRole);
    
	void deleteSysUserRolebyUserId(@Param("userId") String userId);

	void deleteSysUserRolebyUserIdNotCJGLY(@Param("userId") String userId);

	void deleteSysUserRolebyUserIdNotGLY(@Param("userId") String userId);
	@Select("select count(0) from m_role where role_name=#{roleName} ")
	int validataRoleName(@Param("roleName") String roleName);

}
