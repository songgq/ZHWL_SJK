package com.ustcsoft.jt.service.impl;

import com.ustcsoft.jt.constant.ApiConstants;
import com.ustcsoft.jt.mapper.DrugManageDetailMapper;
import com.ustcsoft.jt.mapper.DrugManageMapper;
import com.ustcsoft.jt.service.DrugManageService;
import com.ustcsoft.jt.util.JsonUtil;
import com.ustcsoft.jt.vo.DrugManage;
import com.ustcsoft.jt.vo.DrugManageDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugManageServiceImpl implements DrugManageService {
	@Autowired
	private DrugManageMapper drugManageMapper;
	@Autowired
	private DrugManageDetailMapper drugManageDetailMapper;
	public Integer batchAdd(byte[] jsonData,String orgCode,String entCode){
		List<DrugManage> drugManages = null;
		try{
			String jsonStr = new String(jsonData,"UTF-8");
			drugManages=JsonUtil.jsonToList(jsonStr,DrugManage.class);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiConstants.RETURN_JSON_ERROR;
		}
		try{
			drugManageMapper.batchAdd(drugManages,orgCode,entCode);
			drugManageDetailMapper.batchAddDetail(drugManages,orgCode,entCode);
		}catch(Exception e){
			e.printStackTrace();
			return ApiConstants.RETURN_OTHER_ERROR;
		}
		return ApiConstants.RETURN_SUCCESS;
	}
}
