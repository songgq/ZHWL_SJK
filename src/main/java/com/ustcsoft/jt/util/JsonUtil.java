package com.ustcsoft.jt.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class JsonUtil {
	private final static DeserializationFeature PR1 = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
	private final static SerializationFeature PR2 = SerializationFeature.FAIL_ON_EMPTY_BEANS;
	//属性名不加引号
	private final static Feature PR3 = Feature.ALLOW_UNQUOTED_FIELD_NAMES;
	//解析单引号
	private final static Feature PR4 = Feature.ALLOW_SINGLE_QUOTES;

	/**
	 * 对象转json
	 * @param o
	 * @return
	 */
	public static String objectToJson(Object o){
		try{
			ObjectMapper mapper = new ObjectMapper();
			mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm"));
			mapper.configure(PR1,false);
			mapper.configure(PR2,false);
			return mapper.writeValueAsString(o);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * json转集合(单引号json)
	 * @param json
	 * @param class1
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public static <T> T[] jsonToArray(String json,Class<T[]> class1) throws Exception{
		if(json != null && json != "" && json.trim().indexOf("[") != 0){
			json = "[" + json + "]";
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(PR3,true);
		mapper.configure(PR4,true);
		return mapper.readValue(json,class1);
	}

	/**
	 * json转list
	 * @param json
	 * @param class1
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public static <T> List<T> jsonToList(String json,Class<T> class1) throws Exception{
		if(json != null && json != "" && json.trim().indexOf("[") != 0){
			json = "[" + json + "]";
		}
		ObjectMapper mapper = new ObjectMapper();
		//mapper.configure(PR3,true);
		//mapper.configure(PR4,true);
		return mapper.readValue(json,
		    mapper.getTypeFactory().constructParametricType(ArrayList.class,class1));
	}

	public static Map jsonToMap(String json) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		//mapper.configure(PR3,true);
		//mapper.configure(PR4,true);
		return mapper.readValue(json,HashMap.class);
	}

}
