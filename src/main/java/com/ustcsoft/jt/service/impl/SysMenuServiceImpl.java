package com.ustcsoft.jt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.ustcsoft.jt.mapper.SysMenuMapper;
import com.ustcsoft.jt.service.SysMenuService;
import com.ustcsoft.jt.vo.SysMenuVO;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Resource
	private SysMenuMapper sysMenuMapper;

	/**
	 * 查询用户常用菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<SysMenuVO> selectPurviewMenuAll(Long userId) {
		return sysMenuMapper.selectPurviewMenuAll(userId);
	}

	/**
	 * 查询菜单详细
	 */
	public SysMenuVO querySysMenu(String node) {

		return sysMenuMapper.querySysMenu(node);
	}

	/**
	 * 新增系统功能
	 * 
	 */
	public int insertSysMenu(SysMenuVO sysMenuVO) {
		String startmenuId = sysMenuVO.getMenuId().replaceAll("(00)+$", "");
		String maxId = sysMenuMapper.selectMaxId(startmenuId + "%");
		if (sysMenuVO.getMenuId().equals("0")) {
			sysMenuVO.setIsLeaf("0");
			sysMenuVO.setParentId("0");
			sysMenuVO.setState("open");
			sysMenuVO.setIsPop("");
			int temp = Integer.parseInt(maxId.substring(0, 2)) + 1;
			if (temp >= 10) {
				sysMenuVO.setMenuId(StringUtils.rightPad(String.valueOf(temp),
						10, "0"));
			} else if (temp < 10) {
				sysMenuVO.setMenuId("0"
						+ StringUtils.rightPad(String.valueOf(temp), 9, "0"));
			}

		} else {

			int insertMenuId = Integer.parseInt(maxId.substring(1,
					startmenuId.length() + 2)) + 1;
			String menuIdStr = StringUtils.rightPad(startmenuId.substring(0, 1)
					+ String.valueOf(insertMenuId), 10, "0");
			sysMenuVO.setMenuId(menuIdStr);

			if (startmenuId.length() == 2) {
				sysMenuVO.setIsLeaf("1");
				sysMenuVO.setParentId(StringUtils
						.rightPad(startmenuId, 10, "0"));
				sysMenuVO.setMenuUrl(sysMenuVO.getMenuUrl().trim());
			} else {
				sysMenuVO.setParentId(StringUtils
						.rightPad(startmenuId, 10, "0"));
				sysMenuVO.setMenuUrl(sysMenuVO.getMenuUrl().trim());
				sysMenuVO.setIsLeaf(String.valueOf(startmenuId.length() / 4));
			}
		}
		int count=sysMenuMapper.validateMenuName(sysMenuVO.getMenuName());
		if(count==0){
			sysMenuMapper.insertSysMenu(sysMenuVO);
			return 0;
		}else{
			return 1;
		}
		

	}

	/**
	 * 修改系统功能
	 * 
	 */
	public int updateSysMenu(SysMenuVO sysMenuVO) {
		if (!"".equals(sysMenuVO.getMenuUrl().trim())) {
			sysMenuVO.setMenuUrl(sysMenuVO.getMenuUrl().trim());
			sysMenuVO.setIsLeaf("1");

			if (sysMenuVO.getIsPop() == null) {
				sysMenuVO.setIsPop("N");
			}
		} else {
			sysMenuVO.setIsLeaf("0");
			sysMenuVO.setIsPop("");

		}
		int count=sysMenuMapper.validateMenuNameOfUpdate(sysMenuVO.getMenuName(),sysMenuVO.getMenuId());
		if(count==0){
			sysMenuMapper.updateSysMenu(sysMenuVO);
			return 0;
		}else{
			return 1;
		}
		
	}

	/**
	 * 删除系统功能
	 */
	public void deleteSysMenu(String node) {
		String nodeId = node.substring(0, 4);
		sysMenuMapper.deleteSysMenu(nodeId + "%");

	}

	/**
	 * 系统菜单树（all）
	 */
	public List<SysMenuVO> findAllSysMenuTree() {

		List<SysMenuVO> list = sysMenuMapper.findAllSysMenuTree();
		SysMenuVO menu = new SysMenuVO();
		menu.setMenuId("0");
		menu.setMenuName("系统功能菜单");
		menu.setState("open");
		list.add(0, menu);
		return list;
	}

}
