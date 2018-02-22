package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.entity.DistrictInfo;
import com.service.IDistrictInfoService;
import com.util.BaseControl;

/**
 * 城区信息操作Controller
 * 
 * @author John
 *
 */
@Controller
@RequestMapping("/standard")
public class DistrictInfoController extends BaseControl {

	@Resource
	private IDistrictInfoService iDistrictInfoService;
	// 初始化JSON
	JSONObject j = null;

	/**
	 * 查询城区列表
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/districtInfo.html")
	@ResponseBody
	public void queryDistrict() throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 查询城区列表
		List<DistrictInfo> districtInfo = iDistrictInfoService.queryDistrict();

		
		//
		if (districtInfo.size() == 0) {
			// 录入数据
			j.put("districtInfo", false);
		} else {
			// 录入数据
			j.put("districtInfo", districtInfo);
		}
		
		// 返回数据
		response.getWriter().print(j);
	}
	
	/**
	 * 批量添加城区
	 * 
	 * @param districtInfo
	 * @throws IOException
	 */
	@RequestMapping("/insertDistinct.html")
	@ResponseBody
	public void insertDistinct(DistrictInfo districtInfo) throws IOException {

		System.out.println(districtInfo.getDistrictName());
		System.out.println(districtInfo.getCityId());
		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");
		
		//参数设置
		List<DistrictInfo> list = new ArrayList<DistrictInfo>();

		String str[] = districtInfo.getDistrictName().split(",");
		System.out.println(str.length);
		for(int i=0;i<str.length;i++){
			DistrictInfo districtInfos = new DistrictInfo();
			String districtId = String.valueOf(new Date().getTime()+i);
			districtInfos.setDistrictId(districtId);
			districtInfos.setCityId(districtInfo.getCityId());
			districtInfos.setDistrictName(str[i]);
			list.add(districtInfos);
		}
		//添加
		int flag = iDistrictInfoService.insertDistinct(list);
		
		//
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
