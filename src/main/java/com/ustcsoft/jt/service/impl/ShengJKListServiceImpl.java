package com.ustcsoft.jt.service.impl;

import com.ustcsoft.jt.mapper.ShengjkMapper;
import com.ustcsoft.jt.mybatis.Page;
import com.ustcsoft.jt.service.ShengJKListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShengJKListServiceImpl implements ShengJKListService {
	@Autowired
	private ShengjkMapper shengjkMapper;

	@Override
	public Page<Map> getQyxx(int page, int row) {
		Page<Map> pageVO = Page.buildPageRequest(page, row);
		List<Map> list =shengjkMapper.getQyxxPage(pageVO);
		pageVO.setItems(list);

		return pageVO;
	}

	@Override
	public List<Map> getUpQyxx(String startTime,String endTime) {
		List<Map> list =shengjkMapper.getUpQyxx(startTime,endTime);
		return list;
	}
	@Override
	public List<Map> getUpAjxx(String startTime,String endTime) {
		List<Map> list =shengjkMapper.getUpAjxx(startTime,endTime);
		return list;
	}
	@Override
	public List<Map> getUpCfxx(String startTime,String endTime) {
		List<Map> list =shengjkMapper.getUpCfxx(startTime,endTime);
		return list;
	}
	@Override
	public List<Map> getUpHwxx(String startTime,String endTime) {
		List<Map> list =shengjkMapper.getUpHwxx(startTime,endTime);
		return list;
	}

	@Override
	public List<Map> getUpLqjcxx(String startTime, String endTime) {
		List<Map> list =shengjkMapper.getUpLqjcxx(startTime,endTime);
		return list;
	}
	@Override
	public List<Map> getUpLqjcxxPoint(String gId) {
		List<Map> list =shengjkMapper.getUpLqjcxxPoint(gId);
		return list;
	}

	@Override
	public List<Map> getUpLqjcxxH(String startTime, String endTime) {
		//DataSourceHolder.setDataSource(BasicEnums.DataSource_Two);
		List<Map> list =shengjkMapper.getUpLqjcxxH(startTime,endTime);
		//DataSourceHolder.clearDateSource();
		return list;
	}

	@Override
	public List<Map> getUpLqjcxxPointH(String gId) {
		//DataSourceHolder.setDataSource(BasicEnums.DataSource_Two);
		List<Map> list =shengjkMapper.getUpLqjcxxPointH(gId);
		//DataSourceHolder.clearDateSource();
		return list;
	}
}
