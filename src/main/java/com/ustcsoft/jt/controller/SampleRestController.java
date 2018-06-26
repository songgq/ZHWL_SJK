package com.ustcsoft.jt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController extends AbstractRestController{

	@RequestMapping(value = "getDataOfEcharts.do", method = RequestMethod.GET)
	public Map<String, List> getDataOfEcharts() {
		Map<String, List> map = new HashMap<String, List>();
		List<String> categories = new ArrayList<String>();
		categories.add("衬衫");
		categories.add("羊毛衫");
		categories.add("雪纺衫");
		categories.add("裤子");
		categories.add("高跟鞋");
		categories.add("袜子");
		List<Integer> data = new ArrayList<Integer>();
		data.add(5);
		data.add(10);
		data.add(36);
		data.add(42);
		data.add(23);
		data.add(10);
		map.put("categories",categories);
		map.put("data",data);
		return map;
	}
}
