package com.ustcsoft.jt.service;

/**
 * 熏蒸处理 服务类
 * @author songgq
 *
 */
public interface FumigatingService {

	 Integer batchAdd(byte[] jsonData, String orgCode, String entCode);
}
