package com.ustcsoft.jt.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PropertyUtil {

	private static final java.util.Properties prop = new java.util.Properties();

	static {
		try {
			prop.load(PropertyUtil.class.getResourceAsStream("/env.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 加载java内部属性及-D属性
		prop.putAll(System.getProperties());
		// 加载环境变量
		prop.putAll(System.getenv());
	}

	public static String getProperty(String key) {
		return prop.getProperty(key, "");
	}
	
	public static Map<String,String> getPropertiesByPrefix(String prefix){
		Map<String,String> map = new HashMap<String,String>();
		Iterator it=prop.entrySet().iterator();
		while(it.hasNext()){
		    Map.Entry entry=(Map.Entry)it.next();
		    String key = (String) entry.getKey();
		    String value = (String) entry.getValue();
		    if(key!=null&&key.startsWith(prefix)){
		    	map.put(key, value);
		    }
		} 
		return map;
	}

}
