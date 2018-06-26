package com.ustcsoft.jt.util;

import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.SimpleFormatter;

public class CommonUtils {

	public static String getParentId(String id) {
		String temp = id.replaceAll("(00)+$", "");
		return StringUtils.rightPad(temp.substring(0, temp.length() - 2),
				id.length(), "0");
	}

	public static String getSearchId(String id) {
		if (StringUtils.isEmpty(id)) {
			return id;
		}
		String temp = id.replaceAll("(00)+$", "") + "%";
		return temp;
	}

	public static String getChildId(String id, int i) {
		String temp = id.replaceAll("(00)+$", "");
		String temp2 = StringUtils.rightPad(temp.substring(0, temp.length()),
				temp.length() + 2, "0");
		long child = Long.parseLong(temp2) + i;
		String childId = StringUtils.rightPad(String.valueOf(child),
				id.length(), "0");
		return childId;
	}

	public static String getUUDI() {
		return UUID.randomUUID().toString();
	}

	public static void main(String[] args) {
		System.out.println(getSearchId("3402000000000000"));
	}

	/**
	 * 接口需求日期格式 pattern:yyyyMMddHHmmss
	 * @param date
	 * @return
	 */
	public static String getFormatterDataStr(Date date) {
		SimpleDateFormat simpleFormatter=new SimpleDateFormat("yyyyMMddHHmmss");
		return simpleFormatter.format(date);
	}
}
