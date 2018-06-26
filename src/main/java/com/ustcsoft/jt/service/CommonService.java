package com.ustcsoft.jt.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface CommonService {
	public String saveFileToServer(MultipartFile multifile, String path) throws IOException;

}
