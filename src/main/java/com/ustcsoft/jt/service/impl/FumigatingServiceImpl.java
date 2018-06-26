package com.ustcsoft.jt.service.impl;

import com.ustcsoft.jt.constant.ApiConstants;
import com.ustcsoft.jt.mapper.FumigatingFumigatemanMapper;
import com.ustcsoft.jt.mapper.FumigatingFumigateobjMapper;
import com.ustcsoft.jt.mapper.FumigatingMapper;
import com.ustcsoft.jt.service.FumigatingService;
import com.ustcsoft.jt.util.JsonUtil;
import com.ustcsoft.jt.vo.Fumigating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FumigatingServiceImpl implements FumigatingService {
	@Autowired
	private FumigatingMapper fumigatingMapper;
	@Autowired
	private FumigatingFumigatemanMapper fumigatingFumigatemanMapper;
	@Autowired
	private FumigatingFumigateobjMapper fumigatingFumigateobjMapper;
	public Integer batchAdd(byte[] jsonData,String orgCode,String entCode){
		List<Fumigating> fumigatings = null;
		try{
			String jsonStr = new String(jsonData,"UTF-8");
			fumigatings=JsonUtil.jsonToList(jsonStr,Fumigating.class);
		} catch (Exception e) {
			e.printStackTrace();
			return ApiConstants.RETURN_JSON_ERROR;
		}
		try{
			fumigatingMapper.batchAdd(fumigatings,orgCode,entCode);
			fumigatingFumigatemanMapper.batchAddFumigateman(fumigatings,orgCode,entCode);
			fumigatingFumigateobjMapper.batchAddFumigateobj(fumigatings,orgCode,entCode);
		}catch(Exception e){
			e.printStackTrace();
			return ApiConstants.RETURN_OTHER_ERROR;
		}
		return ApiConstants.RETURN_SUCCESS;
	}
}
