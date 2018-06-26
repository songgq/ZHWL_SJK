package com.ustcsoft.jt.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ustcsoft.jt.mapper.SysUserMapper;
import com.ustcsoft.jt.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {
	@Resource
	private SysUserMapper sysUserMapper;
	

	@Override
	public String saveFileToServer(MultipartFile multifile, String path) throws IOException{
		 // 创建目录  
        File dir = new File(path);  
        if (!dir.exists()) {  
            dir.mkdir();  
        }  
        // 读取文件流并保持在指定路径  
        InputStream inputStream = null;  
        OutputStream outputStream = null;  
        try{
        	inputStream = multifile.getInputStream();  
        	outputStream = new FileOutputStream(path  
                    + multifile.getOriginalFilename()); 
			 byte[] buffer = multifile.getBytes();  
			 int bytesum = 0;  
			 int byteread = 0;  
			 while ((byteread = inputStream.read(buffer)) != -1) {  
			     bytesum += byteread;  
			     outputStream.write(buffer, 0, byteread);  
			     outputStream.flush();  
			 } 
        }finally{
        	if(outputStream!=null){
        		outputStream.close(); 
        	}
        	if(inputStream!=null){
        		inputStream.close();
        	}
        }
        
          
  
        return path + multifile.getOriginalFilename();  
	}

	

}
