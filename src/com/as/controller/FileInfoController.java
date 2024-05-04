package com.as.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.as.domain.DepartInfo;
import com.as.domain.Employee;
import com.as.domain.FileInfo;
import com.as.service.DepartInfoService;
import com.as.service.EmployeeService;
import com.as.service.FileInfoService;
import com.as.util.DownFile;
import com.as.util.Pages;

/**
 * 	部门模块的控制层
 * @author 小陈
 *
 */
@Controller
@RequestMapping("/fileinfo")
public class FileInfoController extends BaseController{

	// 依赖注入
	@Autowired
	private FileInfoService fileInfoService;
	@Autowired
	private EmployeeService employeeService ;
	@Autowired
	private DepartInfoService departInfoService;
	
	/**
	 * 列表页面显示
	 * @param currPage
	 * @param fileInfo
	 * @return
	 */
	@RequestMapping("/list")
//	@ResponseBody // ajax方法,测试用
	public ModelAndView list(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, FileInfo fileinfo) {
		
		//模糊查询为空时,页数1/0, limit出错
		if(currPage==0) currPage=1;
		
		Pages<FileInfo> pages = this.fileInfoService.list(currPage, fileinfo);
		//查询下拉列表的员工
		Pages<Employee> employee=this.employeeService.list(-1, new Employee());
		//查询下拉列表的部门
		Pages<DepartInfo> departInfo=this.departInfoService.list(-1, new DepartInfo());
		
		ModelAndView mv = new ModelAndView("fileinfo/list");

		//链式写法
		mv.addObject("pages", pages)
		.addObject("fileinfo", fileinfo)
		.addObject("employee", employee)
		.addObject("departInfo", departInfo);

		return mv;
	}
	
	/**
	 * 新增页面显示
	 * @return
	 */
	@GetMapping("/append")
	public ModelAndView append() {
		
		ModelAndView mv=new ModelAndView("fileinfo/append");
		return mv;
	}
	
	/**
	 * 新增页面处理
	 * @param fileInfo
	 * @return
	 */
	@PostMapping("/append")
	public ModelAndView append(FileInfo fileInfo,MultipartFile file) {
		
		this.fileInfoService.append(fileInfo, file, request);
		ModelAndView mv=new ModelAndView("redirect:list");
		
		return mv;
	}
	
	/**
	 * 下载次数增加
	 * @param fileInfo
	 * @return
	 */
	@GetMapping("/modify") 
	public ModelAndView modify(Integer fileid) {
		
		this.fileInfoService.modify(fileid);
		ModelAndView mv=new ModelAndView("redirect:/fileinfo/list");
		
		return mv;
	}
	
	/**
	 * 删除
	 * @param fileid
	 * @return
	 */
	@GetMapping("/remove")
	public ModelAndView remove(Integer fileid) {
		
		this.fileInfoService.remove(fileid);
		ModelAndView mv=new ModelAndView("redirect:/fileinfo/list");
		
		return mv;
	}
	
	/**
	 * 批量删除
	 * @param fileid
	 * @return
	 */
	@GetMapping("/removes")
	public ModelAndView removes(Integer[] fileids) {
		
		this.fileInfoService.removes(fileids);
		ModelAndView mv=new ModelAndView("redirect:/fileinfo/list");
		
		return mv;
	}
	
	/**
	 * 查看详情
	 * @param fileid
	 * @return
	 */
	@GetMapping("/detail")
	public ModelAndView detail(Integer fileid) {
		
		FileInfo fileInfo=this.fileInfoService.selectById(fileid);
		ModelAndView mv=new ModelAndView("fileinfo/detail");
		mv.addObject("fileInfo", fileInfo);
		
		return mv;
	}
	
	/**
	 * 下载方法
	 * @param filename
	 * @return
	 */
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(String filename) {
		
		//下载文件的方法
		ResponseEntity<byte[]> file=DownFile.download(filename, request);
		return file;
	}

}
