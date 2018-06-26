package com.ustcsoft.jt.service;

import java.util.List;

import com.ustcsoft.jt.vo.SysMenuVO;

public interface SysMenuService {

	List<SysMenuVO> selectPurviewMenuAll(Long userId);
	
	/**
	 *  查询菜单详细
	 */

	SysMenuVO querySysMenu(String node);
	
	/**
	 * 新增系统功能
	 * 
	 */
	int insertSysMenu(SysMenuVO sysMenuVO);
	
	/**
	 * 修改系统功能
	 * 
	 */
    int updateSysMenu(SysMenuVO sysMenuVO);

    /**
	 * 删除系统功能
	 */
	void deleteSysMenu(String node);

	List<SysMenuVO> findAllSysMenuTree();
}
