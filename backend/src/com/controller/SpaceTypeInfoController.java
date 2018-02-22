package com.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.entity.SpaceTypeInfo;
import com.service.ISpaceTypeInfoService;
import com.util.BaseControl;

/**
 * 场地类型操作Controller
 * 
 * @author John
 *
 */
@Controller
@RequestMapping("/spaceTypeInfo")
public class SpaceTypeInfoController extends BaseControl {

	@Resource
	private ISpaceTypeInfoService iSpaceTypeInfoService;
	// 初始化JSON
	JSONObject j = null;

	/**
	 * 查询场地类型列表
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/spaceTypeInfo.html")
	@ResponseBody
	public void querySpaceType() throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 查询城市列表
		List<SpaceTypeInfo> spaceTypeInfos = iSpaceTypeInfoService.queryType();

		// 录入数据
		j.put("spaceTypeInfos", spaceTypeInfos);

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 添加场地类型
	 * 
	 * @param spaceTypeInfo
	 * @throws IOException
	 */
	@RequestMapping("/addSpaceType.html")
	@ResponseBody
	public void addSpaceType(SpaceTypeInfo spaceTypeInfo) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 类型ID
		String spaceTypeId = String.valueOf(new Date().getTime());
		spaceTypeInfo.setSpaceTypeId(spaceTypeId);
		// 添加
		int flag = iSpaceTypeInfoService.addSpaceType(spaceTypeInfo);

		// 成功
		if (flag > 0) {
			// 录入数据
			j.put("message", true);
		} else {
			// 录入数据
			j.put("message", false);
		}

		// 返回数据
		response.getWriter().print(j);
	}
}
