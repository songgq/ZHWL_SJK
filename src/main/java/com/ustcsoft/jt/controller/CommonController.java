package com.ustcsoft.jt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ustcsoft.jt.mybatis.Page;
import com.ustcsoft.jt.service.CommonService;

@Controller
public class CommonController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private CommonService commonService;

	@RequestMapping("common/fileUpload.do")
	public void fileUpload(
			@RequestParam("file") MultipartFile file,
			HttpServletResponse response) throws IOException {
		logger.info("common/fileUpload.do");

		JSONObject obj = new JSONObject();
		PrintWriter out = null;
		out = response.getWriter();

		if (!file.isEmpty()) {
			if (file != null && StringUtils.hasText(file.getOriginalFilename())) {
				String path = commonService
						.saveFileToServer(file, "D://jrxml/");
				obj.put("path", path);
			}
		} else {

		}
		obj.put("msg", "SUCCESS");
		out.print(obj);
		out.close();
	}

	@RequestMapping("common/buju.do")
	public String bj() {
		return "cwtj/muBanManager";
	}
}
