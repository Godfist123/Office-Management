package com.as.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class DownFile {

	/**
	 * 文件下载
	 * 会把得到文件返回浏览器,以窗口形式保存
	 * @param fileName
	 * @param request
	 * @return
	 */
    public static ResponseEntity<byte[]> download(String fileName,HttpServletRequest request)  {
    	try {
		//得到对应的物理路径	
    	String realFileName = request.getSession().getServletContext().getRealPath("/")  + Common.UPLOAD + "/"+fileName;
    	//文件
    	File file=new File(realFileName);
    	//转码
        String dfileName = new String(fileName.getBytes("utf-8"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", dfileName);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    	} catch (Exception e) {
			// TODO: handle exception
    		return null;
		}
    }


}
