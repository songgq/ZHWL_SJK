package com.ustcsoft.jt.service;

/**
 * 机械通风信息 服务类
 * @author songgq
 *
 */
public interface AerationService {

	 Integer batchAdd(byte[] jsonData, String orgCode, String entCode);
}
