package com.ustcsoft.jt.service.impl;

import com.ustcsoft.jt.constant.ApiConstants;
import com.ustcsoft.jt.mapper.AerationJobMapper;
import com.ustcsoft.jt.mapper.AerationMapper;
import com.ustcsoft.jt.service.AerationService;
import com.ustcsoft.jt.util.JsonUtil;
import com.ustcsoft.jt.vo.Aeration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AerationServiceImpl implements AerationService {
	@Autowired
	private AerationMapper aerationMapper;
	@Autowired
	private AerationJobMapper aerationJobMapper;
	public Integer batchAdd(byte[] jsonData,String orgCode,String entCode){
		List<Aeration> aerations = null;
		try{
			String jsonStr = new String(jsonData,"UTF-8");
			aerations=JsonUtil.jsonToList(jsonStr,Aeration.class);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiConstants.RETURN_JSON_ERROR;
		}
		try{
			aerationMapper.batchAdd(aerations,orgCode,entCode);
			aerationJobMapper.batchAddAerationJob(aerations,orgCode,entCode);

		}catch(Exception e){
			e.printStackTrace();
			return ApiConstants.RETURN_OTHER_ERROR;
		}
		return ApiConstants.RETURN_SUCCESS;
	}
}
