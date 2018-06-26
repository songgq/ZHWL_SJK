package com.ustcsoft.jt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrameController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 不指定responsebody 返回页面VIEW
	@RequestMapping("frameJsp.do")
	public String frameJsp() {
		logger.info("frameJsp.do");
		return "frameJsp";
	}

	/**
	 * 首页
	 */
	@RequestMapping("/welcome.do")
	public String welcome() {
		return "welcome";
	}

}
