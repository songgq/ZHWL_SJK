package com.ustcsoft.jt.service;

import java.util.List;

import com.ustcsoft.framework.vo.UserVO;
import com.ustcsoft.jt.mybatis.Page;
import com.ustcsoft.jt.vo.SysOrgVO;


public interface SysOrgService {

	List<SysOrgVO> searchOrgTree(String node);

	Page<SysOrgVO> searchOrgList(SysOrgVO org, int page, int rows);

	int addOrgInfo(SysOrgVO org);

	int updateOrg(SysOrgVO org,UserVO userInfo);

	void deleteOrg(String orgId);

	SysOrgVO searchOrgById(String orgId);

	/**
	 * 根据机构名称查询机构
	 */
	List<SysOrgVO> queryByName(String orgName);

	/**
	 * 获取去区划下的粮食局信息
	 * @param areaId
	 * @return
	 */
	List<SysOrgVO> getOrgByAreaId(String areaId);

	/**
	 * 获取市级粮食局信息
	 * @return
	 */
	List<SysOrgVO> getCityOrgs();

	/**
	 * 获取附近的粮食局机构
	 */
	List<SysOrgVO> getNearOrgs(String lon, String lat);
}
