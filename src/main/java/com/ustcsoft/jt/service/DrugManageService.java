package com.ustcsoft.jt.service;

/**
 * 药品管理 服务类
 * @author songgq
 *
 */
public interface DrugManageService {

	 Integer batchAdd(byte[] jsonData, String orgCode, String entCode);
}
