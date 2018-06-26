package com.ustcsoft.jt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ustcsoft.framework.vo.UserVO;
import com.ustcsoft.jt.mybatis.Page;
import com.ustcsoft.jt.service.SysMenuService;
import com.ustcsoft.jt.service.SysOrgService;
import com.ustcsoft.jt.service.SysRoleService;
import com.ustcsoft.jt.service.SysUserService;
import com.ustcsoft.jt.vo.SysMenuVO;
import com.ustcsoft.jt.vo.SysOrgVO;
import com.ustcsoft.jt.vo.SysRoleVO;
import com.ustcsoft.jt.vo.SysUserVO;

@RestController
public class SystemRestController extends AbstractRestController {

	@Resource
	private SysRoleService sysRoleService;
	@Resource
	private SysMenuService sysMenuService;
	@Resource
	private SysOrgService sysOrgService;
	@Resource
	private SysUserService sysUserService;

	/**
	 * 查询用户常用菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("sysMenu/findSysMenuTreeAll.do")
	public List<SysMenuVO> findSysMenuTreeAll() throws Exception {
		UserVO userInfo = getCurrentUser();
		return sysMenuService.selectPurviewMenuAll(userInfo.getUserId());
	}

	/**
	 * 获取角色列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("sysRole/findRoleList.do")
	public Page<SysRoleVO> findRoleList(@RequestParam(value = "roleName", required = false) String roleName,
			@RequestParam(value = "roleType", required = false) String roleType,
			@RequestParam(value = "roleHy", required = false) String roleHy,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "rows", defaultValue = "10") int rows,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "sord", required = false) String sord) throws Exception {
		SysRoleVO role = new SysRoleVO();
		role.setRoleName(roleName);
		UserVO userInfo = getCurrentUser();
		role.setCreaterOrgId(userInfo.getOrgId());
		role.setRoleHy(roleHy);
		role.setRoleType(roleType);

		return sysRoleService.queryAllSysRoleInCurrentOrg(role, userInfo.getUserId().toString(), page, rows);
	}

	/**
	 * 查询菜单详细
	 * 
	 * @param node
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("sysMenu/findUserMenuByMENU_ID.do")
	public SysMenuVO findUserMenuByMENU_ID(@RequestParam("node") String node) throws Exception {
		return sysMenuService.querySysMenu(node);
	}

	/**
	 * 新增系统功能
	 * 
	 */
	@RequestMapping("sysMenu/insertSysMenu.do")
	public int insertSysMenu(SysMenuVO sysMenuVO, String menuId, String menuName, String type, String busiCode,
			String delFlg, String menuIco, String menuUrl, String helpUrl, String isPop) {
		return sysMenuService.insertSysMenu(sysMenuVO);

	}

	/**
	 * 修改系统功能
	 * 
	 */
	@RequestMapping("sysMenu/updateSysMenu.do")
	public int updateSysMenu(SysMenuVO sysMenuVO, @RequestParam("menuId") String menuId) {
		return sysMenuService.updateSysMenu(sysMenuVO);

	}

	/**
	 * 删除系统功能
	 */
	@RequestMapping("sysMenu/deleteSysMenu.do")
	public int deleteSysMenu(@RequestParam("node") String node) {
		sysMenuService.deleteSysMenu(node);
		return 0;
	}

	/**
	 * 删除角色
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("sysRole/deleteRole.do")
	public int deleteRole(@RequestParam("roleId") String roleId) throws Exception {
		sysRoleService.deleteSysRole(roleId);
		return 0;
	}

	/**
	 * 查询系统菜单及页面对象-角色授权(一次性加载树)
	 * 
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping("sysRole/findSysMenuOrObjectTreeAll4Role.do")
	public List<SysMenuVO> findSysMenuOrObjectTreeAll4Role(
			@RequestParam(value = "roleId", required = false) String roleId,
			@RequestParam(value = "node", required = false) String node) throws Exception {
		SysMenuVO _sysMenu = new SysMenuVO();
		_sysMenu.setParentId("0");
		_sysMenu.setRoleId(roleId);
		UserVO userInfo = getCurrentUser();
		_sysMenu.setUserId(userInfo.getUserId().toString());

		return sysRoleService.selectSysMenus(userInfo.getUserId().toString(), _sysMenu);
	}

	@RequestMapping("sysMenu/findAllSysMenuTree.do")
	public List<SysMenuVO> findAllSysMenuTree() {
		return sysMenuService.findAllSysMenuTree();
	}

	/**
	 * 设置角色-授权
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("sysRole/setRole.do")
	public int setRole(@RequestParam("roleId") String roleId, @RequestParam("menuIds") String menuIds) {
		if (!menuIds.equals("")) {
			UserVO userInfo = getCurrentUser();
			this.sysRoleService.setRole(userInfo, menuIds, roleId);
		}
		return 0;
	}

	/**
	 * 设置用户角色
	 * 
	 * @return
	 */
	@RequestMapping("sysUserRole/setUserRole.do")
	public int setUserRole(@RequestParam(value = "roleId") String roleId,
			@RequestParam(value = "userId") String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("roleId", roleId);
		map.put("userId", userId);
		sysRoleService.setUserRole(map);
		return 0;
	}

	/**
	 * 检索组织树
	 * 
	 * @param documentId
	 * @param roleType1
	 */
	@RequestMapping("deptorg/searchOrgTree.do")
	public List<SysOrgVO> searchOrgTree(@RequestParam(value = "node") String node) {
		return sysOrgService.searchOrgTree(node);
	}

	/**
	 * 检索组织列表(业务)
	 */
	@RequestMapping("deptorg/initOrgList.do")
	public Page<SysOrgVO> searchOrgList(SysOrgVO org,
			@RequestParam(value = "orgName", required = false) String orgName,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "rows", defaultValue = "10") int rows,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "sord", required = false) String sord) {
		if (StringUtils.isEmpty(org.getOrgId())) {
			org.setOrgId(getCurrentUser().getOrgId());
		}
		return sysOrgService.searchOrgList(org, page, rows);
	}

	/**
	 * 检索组织(不带page查找)
	 */
	@RequestMapping("deptorg/searchOrg.do")
	public SysOrgVO searchOrg(@RequestParam(value = "orgId", required = true) String orgId) {
		return sysOrgService.searchOrgById(orgId);
	}

	/**
	 * 删除组织
	 * 
	 * @param businessId
	 * @return
	 */
	@RequestMapping("deptorg/deleteOrg.do")
	public int deleteOrg(@RequestParam(value = "orgIds", required = true) String orgIds) {
		sysOrgService.deleteOrg(orgIds);
		return 0;
	}

	/**
	 * 查询用户列表
	 */
	@RequestMapping("sysUser/findUserList.do")
	public Page<SysUserVO> findUserList(SysUserVO sysUser, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "rows", defaultValue = "10") int rows,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "sord", required = false) String sord) {
		UserVO userInfo = getCurrentUser();
		if (StringUtils.isEmpty(sysUser.getOrgId())) {
			sysUser.setOrgId(userInfo.getOrgId());
		}
		sysUser.setUserId(userInfo.getUserId().toString());
		return sysUserService.findUserList(sysUser, page, rows);

	}

	/**
	 * 根据OrgId查询用户VO
	 */
	@RequestMapping("sysUser/findUserByOrgId.do")
	public SysUserVO findUserByOrgId(@RequestParam(value = "orgId") String orgId) {
		SysUserVO sysUserVO = sysUserService.findUserByOrgId(orgId);
		if (sysUserVO.getDuLiZhiFa() != null) {
			switch (sysUserVO.getDuLiZhiFa()) {
			case "0":
				sysUserVO.setDuLiZhiFa("否");
				break;
			case "1":
				sysUserVO.setDuLiZhiFa("是");
				break;
			}
		}
		if (sysUserVO.getStatus() != null) {
			switch (sysUserVO.getStatus()) {
			case "00":
				sysUserVO.setStatus("停用");
				break;
			case "01":
				sysUserVO.setStatus("启用");
				break;
			}
		}
		if (sysUserVO.getOrgLv() != null) {
			switch (sysUserVO.getOrgLv()) {
			case "01":
				sysUserVO.setOrgLv("省厅");
				break;
			case "02":
				sysUserVO.setOrgLv("省行业局");
				break;
			case "03":
				sysUserVO.setOrgLv("市局");
				break;
			case "04":
				sysUserVO.setOrgLv("市行业局");
				break;
			case "05":
				sysUserVO.setOrgLv("县/区局");
				break;
			case "06":
				sysUserVO.setOrgLv("县/区行业局");
				break;
			case "07":
				sysUserVO.setOrgLv("基层站所/分局/高速路政大队");
				break;
			}
		}
		if (sysUserVO.getTradeType() != null) {
			switch (sysUserVO.getTradeType()) {
			case "00":
				sysUserVO.setTradeType("交通主管部门");
				break;
			case "01":
				sysUserVO.setTradeType("公路");
				break;
			case "02":
				sysUserVO.setTradeType("运管");
				break;
			case "03":
				sysUserVO.setTradeType("海事");
				break;
			case "04":
				sysUserVO.setTradeType("质监");
				break;
			case "05":
				sysUserVO.setTradeType("港航");
				break;
			case "06":
				sysUserVO.setTradeType("通用");
				break;
			}
		}
		return sysUserVO;
	}

	/**
	 * 删除用户
	 */
	@RequestMapping("sysUser/deleteUser.do")
	public int deleteUser(SysUserVO sysUser, @RequestParam(value = "userId") String userId) {
		sysUserService.deleteUser(sysUser);
		return 0;

	}

	/**
	 * 重置用户密码
	 */
	@RequestMapping("sysUser/resetUser.do")
	public int resetUser(SysUserVO sysUser, @RequestParam(value = "userId") String userId) {
		sysUserService.resetUser(sysUser);
		return 0;

	}

}
