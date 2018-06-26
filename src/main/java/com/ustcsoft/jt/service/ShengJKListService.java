package com.ustcsoft.jt.service;


import com.ustcsoft.jt.mybatis.Page;

import java.util.List;
import java.util.Map;

/**
 *
 * @author songgq
 *
 */
public interface ShengJKListService {

	Page<Map> getQyxx(int page, int row) ;
	List<Map> getUpQyxx(String startTime, String endTime);
	List<Map> getUpAjxx(String startTime,String endTime);
	List<Map> getUpCfxx(String startTime,String endTime);
	List<Map> getUpHwxx(String startTime,String endTime);
	List<Map> getUpLqjcxx(String startTime,String endTime);
	List<Map> getUpLqjcxxPoint(String gId);

	List<Map> getUpLqjcxxH(String startTime,String endTime);
	List<Map> getUpLqjcxxPointH(String gId);
}
