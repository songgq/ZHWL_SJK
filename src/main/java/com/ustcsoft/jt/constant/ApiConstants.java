package com.ustcsoft.jt.constant;

/**
 * 接口常量类
 */
public class ApiConstants {
	/* ========================上报数据类型 开始========================= */
	/** 1：仓房货位信息 */
	public static final int DATA_TYPE_HOUSE_LOCATION = 1;
	/** 2：实时库存数据 */
	public static final int DATA_TYPE_ACTUAL_STOCK = 2;
	/** 3：出入库业务流水数据 */
	public static final int DATA_TYPE_OUT_IN_STORAGE = 3;
	/** 4：粮情数据 */
	public static final int DATA_TYPE_GRAIN = 4;
	/** 5：质检化验信息 */
	public static final int DATA_TYPE_QUALITY_TESTING = 5;
	/** 6: 气体数据 */
	public static final int DATA_TYPE_GAS = 6;
	/** 7：虫情数据 */
	public static final int DATA_TYPE_INSECT_PEST = 7;
	/** 8：库点使用情况数据 */
	public static final int DATA_TYPE_SYSTEM_USE = 8;
	/** 9：药品使用信息数据 */
	public static final int DATA_TYPE_BRUG_MANAGE = 9;
	/** 10：熏蒸数据 */
	public static final int DATA_TYPE_FUMIGATING = 10;
	/** 11：通风数据 */
	public static final int DATA_TYPE_AERATION= 11;
	/** 12：设备数据 */
	public static final int DATA_TYPE_EQUIPMENT = 12;
	/** 17：视频追溯信息 */
	public static final int DATA_TYPE_VIDEO_RETRIEVAL = 17;

	/** 18：廒间配置信息 */
	public static final int DATA_TYPE_WAREHOUSE_CONFIG = 18;
	/* ========================上报数据类型 结束========================= */
	/* ========================返回值类型 开始========================= */
	/** 0：上传成功 */
	public static final int RETURN_SUCCESS = 0;
	/** 1：该单位没有上传的授权 或库仓廒信息不存在 */
	public static final int RETURN_NO_PERMIT = 1;
	/** 3：json 数据格式不合法，解析失败 */
	public static final int RETURN_JSON_ERROR = 3;
	/** 13：没有数据 */
	public static final int RETURN_DATA_NULL = 13;
	/** 94：接口未开放 */
	public static final int RETURN_INTERFACE_NOT_OPEN = 94;
	/** 98：关键字为空 */
	public static final int RETURN_KEYWORD_NULL = 98;
	/** 99：其他错误 */
	public static final int RETURN_OTHER_ERROR = 99;
	/* ========================返回值类型 结束========================= */

	public static final String LIANGQING_USER = "WLY";
	public static final String LIANGQING_PWD = "adminliangshiju@2018";
	public static final String LIANGQING_URL = "jdbc:sqlserver://172.10.8.11:1433;DataBaseName=LQDB";

}
