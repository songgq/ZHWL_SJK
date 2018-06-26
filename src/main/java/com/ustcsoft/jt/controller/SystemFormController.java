package com.ustcsoft.jt.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ustcsoft.framework.vo.UserVO;
import com.ustcsoft.jt.service.SysOrgService;
import com.ustcsoft.jt.service.SysRoleService;
import com.ustcsoft.jt.service.SysUserService;
import com.ustcsoft.jt.vo.SysOrgVO;
import com.ustcsoft.jt.vo.SysRoleVO;
import com.ustcsoft.jt.vo.SysUserVO;

@RestController
public class SystemFormController extends AbstractRestController{
	@Resource
	private SysOrgService sysOrgService;
	@Resource
	private SysRoleService sysRoleService;
	
	@Resource
	private SysUserService sysUserService;

	/**
	 * 添加组织
	 * 
	 * @param org
	 * @param orgName
	 * @return
	 */
	@RequestMapping("deptorg/insertOrg.do")
	@ResponseBody
	public int insertOrg(SysOrgVO org, HttpServletResponse response) {
		return sysOrgService.addOrgInfo(org);
	}

	
	@RequestMapping("deptorg/updateOrg.do")
	@ResponseBody
	public int updateOrg(SysOrgVO org) {
		UserVO userInfo = getCurrentUser();
		return sysOrgService.updateOrg(org,userInfo);
	}
	
	
	
	/**
	 * 新增角色/更新角色
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("sysRole/edit.do")
	@ResponseBody
	public int addRole(SysRoleVO sysRole) throws Exception {
		UserVO userInfo = getCurrentUser();
		return sysRoleService.editRole(sysRole, userInfo);
	}
	
	
	/**
	 * 增加用户
	 */
	@RequestMapping("sysUser/addUser.do")
	@ResponseBody
	public int addUser(SysUserVO sysUser) {
		return sysUserService.addUser(sysUser);

	}
	
	/**
	 * 更新用户
	 */
	@RequestMapping("sysUser/updateUser.do")
	@ResponseBody
	public int updateUser(SysUserVO sysUser) {
		return sysUserService.updateUser(sysUser);

	}
	
}
