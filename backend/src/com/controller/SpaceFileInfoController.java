package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.entity.SpaceFileInfo;
import com.service.ISpaceFileInfoService;
import com.util.BaseControl;

/**
 * 場地文件信息操作Controller
 * 
 * @author John
 *
 */
@Controller
@RequestMapping("/spaceFile")
public class SpaceFileInfoController extends BaseControl {

	@Resource
	private ISpaceFileInfoService iSpaceFileInfoService;
	// 初始化JSON
	JSONObject j = null;

	/**
	 * 上传文件
	 * 
	 * @param file
	 * @param model
	 * @param newMore
	 * @throws IOException
	 */
	@RequestMapping("/uploadFile.html")
	@ResponseBody
	public void upload(@RequestParam(value = "file", required = false) MultipartFile file, String newFile,
			String spaceId) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		//获取根目录
		File f = new File(session.getServletContext().getRealPath("/")); 
		// 得到文件上传目录
		String path = f.getParent()+"/upload/changdipai/images/document";
		
		// 获取上传文件名
		String fileName = file.getOriginalFilename();
		// 声明实体
		SpaceFileInfo spaceFileInfo = new SpaceFileInfo();
		// 文件Id
		String fileId = String.valueOf(new Date().getTime());

		// 原名称里倒数第一个”.”在哪里
		int i = fileName.lastIndexOf(".");
		// 取得后缀，及”.”后面的字符
		String ext = fileName.substring(i + 1);

		// 判断是否修改名字
		if (newFile != null) {
			// 拼凑而成
			fileName = newFile + new Date().getTime() + "." + ext;
		} else {
			newFile = fileName;
			fileName = fileName + new Date().getTime() + "." + ext;
		}

		// 添加到根目录
		File targetFile = new File(path, fileName);

		// 判断是否存在
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 设置参数
		spaceFileInfo.setFileId(fileId);
		spaceFileInfo.setFile(fileName);
		spaceFileInfo.setFileName(newFile);
		spaceFileInfo.setSpaceId(spaceId);

		// 保存
		try {
			// 写入文件
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 执行添加
		int flag = iSpaceFileInfoService.addFile(spaceFileInfo);

		// 判断是否添加成功
		if (flag > 0) {
			j.put("message", "success");
		} else {
			j.put("message", "failed");
		}

		// 返回数据
		response.getWriter().println(j);
	}
}
