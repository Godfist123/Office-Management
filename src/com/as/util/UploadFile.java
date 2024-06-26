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
public class UploadFile {

	

	//方法:把上传路径写在配置文件configuration.properties中了
	public static String fileUp(MultipartFile files, HttpServletRequest request) {

		// files[i].isEmpty();是否有上传文件
		String newFileName = null;
		try {
			if (files.getSize() != 0) {
				String orignalName = files.getOriginalFilename();// 获取上传文件的原名
				String suffix = orignalName.substring(orignalName.lastIndexOf("."));// 扩展名称
				newFileName = UUID.randomUUID() + suffix;// 新文件名称
				// 准备上传文件
				// String
				// a=request.getSession().getServletContext().getRealPath("/")+"/fileupload/"+newFileName;//得到物理路径
				String a = request.getSession().getServletContext().getRealPath("/") + "/" + Common.UPLOAD + "/"
						+ newFileName;// 得到物理路径
				// J:\tomcat7\apache-tomcat-7.0.90\webapps\demo20180806\/fileupload/4c64b22a-e135-474c-881f-92639982a426.jpg
				// File saveFile=new
				// File(request.getSession().getServletContext().getRealPath("/")+"/fileupload/"+newFileName);
				File saveFile = new File(a);
				// 上传文件
				FileUtils.copyInputStreamToFile(files.getInputStream(), saveFile);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return newFileName;

	}
}
