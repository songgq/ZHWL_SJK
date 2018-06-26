package com.ustcsoft.jt.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import com.ustcsoft.jt.constant.Constant;
import com.ustcsoft.jt.mapper.BGxjdbZyMapper;
import com.ustcsoft.jt.util.DistanceUtil;
import com.ustcsoft.jt.vo.BGxjdbZy;
import com.ustcsoft.jt.vo.MKdxxb;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.ustcsoft.framework.vo.UserVO;
import com.ustcsoft.jt.mapper.SysOrgMapper;
import com.ustcsoft.jt.mybatis.Page;
import com.ustcsoft.jt.service.SysOrgService;
import com.ustcsoft.jt.util.CommonUtils;
import com.ustcsoft.jt.vo.SysOrgVO;

@Service
public class SysOrgServiceImpl implements SysOrgService {

	@Resource
	private SysOrgMapper sysOrgMapper;
	@Resource
	private BGxjdbZyMapper bGxjdbZyMapper;

	/**
	 * 检索组织树
	 */
	public List<SysOrgVO> searchOrgTree(String node) {
		// 管理
		List<SysOrgVO> list = sysOrgMapper.searchOrgTree(CommonUtils.getSearchId(node));
		for (SysOrgVO vo : list) {
			vo.setParentId(CommonUtils.getParentId(vo.getOrgId()));
		}
		return list;
	}

	/**
	 * 检索组织列表
	 */
	public Page<SysOrgVO> searchOrgList(SysOrgVO org, int page, int rows) {
		Page<SysOrgVO> pageVO = Page.buildPageRequest(page, rows);
		org.setSearchId(CommonUtils.getSearchId(org.getOrgId()));
		if(!StringUtils.isEmpty(org.getOrgName())){
			org.setOrgName("%" + org.getOrgName() + "%");
		}
		List<SysOrgVO> list = sysOrgMapper.searchOrgListPage(org, pageVO);
		pageVO.setItems(list);
		return pageVO;
	}

	/**
	 * 添加组织
	 */
	public int addOrgInfo(SysOrgVO org) {
		int count = sysOrgMapper.validataOrgName(org.getOrgName());
		if (count == 0) {
			// 获取最大的上级单位的为父亲id孩子id的最大值(业务爸爸生了一个业务儿子)
			String searchId = CommonUtils.getSearchId(org.getOrgId());
			String maxId = sysOrgMapper.findMaxId(searchId);
			maxId = maxId.substring(0, searchId.length() + 2);
			String id = String.valueOf(Long.parseLong(maxId) + 1);
			String busId = StringUtils.rightPad(id, org.getOrgId().length(), "0");
			org.setOrgId(busId);
			sysOrgMapper.addOrgInfo(org);
			return 0;
		} else {
			return 1;
		}

	}

	/**
	 * 更新组织
	 */
	public int updateOrg(SysOrgVO org, UserVO userInfo) {
		int count = sysOrgMapper.validataOrgNameOfUpdate(org.getOrgName(), org.getOrgId());
		if (count == 0) {
			sysOrgMapper.updateOrg(org);
			return 0;
		} else {
			return 1;
		}

	}

	/**
	 * 根据id 删除对应的组织
	 */
	public void deleteOrg(String orgIds_str) {
		String[] orgIds = orgIds_str.split(",");
		String delId = "";
		for (int i = 0; i < orgIds.length; i++) {
			delId = CommonUtils.getSearchId(orgIds[i]);
			sysOrgMapper.deleteOrg(delId);
		}

	}

	@Override
	public List<SysOrgVO> queryByName(String orgName) {
		return sysOrgMapper.queryByName(orgName);
	}

	@Override
	public SysOrgVO searchOrgById(String orgId) {

		return sysOrgMapper.selectByOrgId(orgId);
	}

	@Override
	public List<SysOrgVO> getOrgByAreaId(String areaId) {
		return sysOrgMapper.getOrgByAreaId(areaId);
	}

	@Override
	public List<SysOrgVO> getCityOrgs() {
		return sysOrgMapper.getCityOrgs();
	}

	@Override
	public List<SysOrgVO> getNearOrgs(String lon, String lat) {
		List<SysOrgVO> sysOrgVOList = sysOrgMapper.getNearOrgs();
		SysOrgVO sysOrgVO = null;
		Iterator<SysOrgVO> iterator = sysOrgVOList.iterator();
		while (iterator.hasNext()) {
			sysOrgVO = iterator.next();
			double distance = DistanceUtil.GetDistance(NumberUtils.toDouble(lon), NumberUtils.toDouble(lat),
					NumberUtils.toDouble(sysOrgVO.getLng()), NumberUtils.toDouble(sysOrgVO.getLat()));
			if (distance > 15) {
				iterator.remove();
			}
		}

		return sysOrgVOList;
	}
}
