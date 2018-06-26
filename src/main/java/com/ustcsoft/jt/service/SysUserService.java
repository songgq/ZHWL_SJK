package com.ustcsoft.jt.service;

import com.ustcsoft.framework.vo.UserVO;
import com.ustcsoft.jt.mybatis.Page;
import com.ustcsoft.jt.vo.AppUser;
import com.ustcsoft.jt.vo.SysUserVO;



public interface SysUserService {

	Page<SysUserVO> findUserList(SysUserVO sysUser,int page,int rows);

	int addUser(SysUserVO sysUser);

	int updateUser(SysUserVO sysUser);

	void deleteUser(SysUserVO sysUser);

	void resetUser(SysUserVO sysUser);

	SysUserVO findUserByOrgId(String orgId);

	/**
	 * app内网用户
	 * @param username
	 * @return
	 */
	UserVO loadUserByUsername(String username);

	/**
	 * app外网用户
	 */
	AppUser loadAppUserByUsername(String username);
}
