package com.ustcsoft.jt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ustcsoft.jt.vo.SysMenuVO;
import com.ustcsoft.jt.vo.SysObjVO;

public interface SysMenuMapper {

	List<SysMenuVO> selectPurviewMenuAll(@Param("userId") Long userId);

	List<SysMenuVO> selectSysMenusByParentId(@Param("node") String node);

	SysMenuVO querySysMenu(@Param("node") String node);

	List<SysObjVO> selectSysObjsByParentId(@Param("node") String node);

	void insertSysMenu(@Param("sysMenuVO") SysMenuVO sysMenuVO);

	void updateSysMenu(SysMenuVO sysMenuVO);

	void deleteSysMenu(String node);

	String selectMaxId(String startmenuId);

	@Select("SELECT a.menu_id,a.parent_id,a.menu_name, 'open' state FROM M_menu a")
	List<SysMenuVO> findAllSysMenuTree();
	@Select("select count(*) from M_menu a where a.menu_name=#{menuName} ")
	int validateMenuName(String menuName);
	@Select("select count(*) from M_menu a where a.menu_name=#{menuName} and a.menu_name!=(select menu_name from M_menu where menu_id=#{menuId} ) ")
	int validateMenuNameOfUpdate(@Param("menuName") String menuName,@Param("menuId") String menuId);

}
