package com.ustcsoft.jt.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.ustcsoft.framework.vo.UserVO;
import com.ustcsoft.jt.mapper.*;
import com.ustcsoft.jt.vo.AppUser;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ustcsoft.jt.mybatis.Page;
import com.ustcsoft.jt.service.SysUserService;
import com.ustcsoft.jt.util.CommonUtils;
import com.ustcsoft.jt.util.MD5Util;
import com.ustcsoft.jt.vo.SysUserRoleVO;
import com.ustcsoft.jt.vo.SysUserVO;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Resource
	private SysUserMapper sysUserMapper;
	@Resource
	private UserMapper userMapper;

	@Resource
	private SysRoleMapper sysRoleMapper;

	@Resource
	private SysOrgMapper sysOrgMapper;
	@Resource
	private AppUserMapper appUserMapper;

	/**
	 * 查询用户列表
	 */
	public Page<SysUserVO> findUserList(SysUserVO sysUser,
			int page, int rows) {

		Page<SysUserVO> pageVO = Page.buildPageRequest(page, rows);
		List<SysUserVO> list = new ArrayList<SysUserVO>();
		long rsum = sysRoleMapper.isAdmin(sysUser.getUserId());
		if(!StringUtils.isEmpty(sysUser.getUserName())){
			sysUser.setUserName("%" + sysUser.getUserName() + "%");
		}
		if(!StringUtils.isEmpty(sysUser.getName())){
			sysUser.setName("%" + sysUser.getName() + "%");
		}
		if(!StringUtils.isEmpty(sysUser.getIdNo())){
			sysUser.setIdNo("%" + sysUser.getIdNo() + "%");
		}
		if(!StringUtils.isEmpty(sysUser.getTel())){
			sysUser.setTel("%" + sysUser.getTel() + "%");
		}
		if (rsum >= 1L) {
			sysUser.setSearchOrgId(CommonUtils.getSearchId(sysUser.getOrgId()));
			list = sysUserMapper.selectOrgUserPage(sysUser, pageVO);
		} else {
			list = sysUserMapper.selectOrgUserNotAdminPage(sysUser, pageVO);
		}
		pageVO.setItems(list);
		return pageVO;
	}

	/**
	 * 增加用户
	 */
	public int addUser(SysUserVO sysUser) {
		String userName=sysUser.getUserName();
		int c1=sysUserMapper.validateUserName(userName);
		if(c1==0){
			String maxUserId = sysUserMapper.findMaxUserId();
			String userId = String.valueOf(Long.parseLong(maxUserId) + 1);
			sysUser.setUserId(userId);
			sysUser.setLoginType("1");
			sysUser.setUserPwd(MD5Util.MD5("888888"));
			sysUserMapper.insertSysUser(sysUser);
			// 给新增用户添加默认角色 固定角色Id ：1000000000000002
			String uid = sysUser.getUserId();
			String fid = "1000000000000002";
			SysUserRoleVO userRole = new SysUserRoleVO();
			userRole.setUserId(uid);
			userRole.setRoleId(fid);
			sysRoleMapper.insertSysUserRole(userRole);
			return 0;
		}else{
			return 1;
		}
		
	}

	/**
	 * 更新用户
	 */
	public int updateUser(SysUserVO sysUser) {
		int c=sysUserMapper.validateUserNameOfUpdate(sysUser.getUserName(), sysUser.getUserId());
		if(c==0){
			sysUserMapper.updateUser(sysUser);
			return 0;
		}else{
			return 1;
		}
		

	}

	/**
	 * 删除用户
	 */
	public void deleteUser(SysUserVO sysUser) {
		String[] userIds=sysUser.getUserId().split(",");
		for(int i=0;i<userIds.length;i++){
			sysUser.setUserId(userIds[i]);
			sysUserMapper.deleteSysUserRoleByUserId(sysUser);
			sysUserMapper.deleteSysUser(sysUser);
		}
		
	}

	/**
	 * 重置密码
	 */
	public void resetUser(SysUserVO sysUser) {
		String passWord = MD5Util.MD5("888888");
		sysUser.setUserPwd(passWord);
		String[] userIds=sysUser.getUserId().split(",");
		for(int i=0;i<userIds.length;i++){
			sysUser.setUserId(userIds[i]);
			sysUserMapper.resetPassword(sysUser);
		}
	}

	@Override
	public SysUserVO findUserByOrgId(String orgId) {
		return sysUserMapper.findUserByOrgId(orgId);
	}

	@Override
	public UserVO loadUserByUsername(String username) {
		return userMapper.loadUserByUsername(username);
	}

	@Override
	public AppUser loadAppUserByUsername(String username) {
		return appUserMapper.loadAppUserByUsername(username);
	}
}
