package com.as.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author 小陈
 * 
 */
public class UploadsFile {

	/**
	 * 上传后的文件名称
	 */
	private static String fileUrl;
	
	/**
	 * 文件大小
	 */
	private static double fileSize;

	

	//方法:把上传路径写在配置文件configuration.properties中了
	public static String getFileUrl() {
		return fileUrl;
	}



	public static void setFileUrl(String fileUrl) {
		UploadsFile.fileUrl = fileUrl;
	}



	public static double getFileSize() {
		return fileSize;
	}



	public static void setFileSize(double fileSize) {
		UploadsFile.fileSize = fileSize;
	}



	public static void fileUp(MultipartFile files, HttpServletRequest request) {

		// files[i].isEmpty();是否有上传文件
		String newFileName = null;
		try {
			if (files.getSize() != 0) {
				fileSize=files.getSize()/(1024*1024);//MB
				String orignalName = files.getOriginalFilename();// 获取上传文件的原名
				String suffix = orignalName.substring(orignalName.lastIndexOf("."));// 扩展名称
				newFileName = UUID.randomUUID() + suffix;// 新文件名称
					String a = request.getSession().getServletContext().getRealPath("/") + "/" + Common.UPLOAD + "/"
						+ newFileName;// 得到物理路径
					File saveFile = new File(a);
				// 上传文件
				FileUtils.copyInputStreamToFile(files.getInputStream(), saveFile);
				fileUrl=newFileName;//文件名称
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		

	}
}
