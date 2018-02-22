package com.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.entity.CityInfo;
import com.service.ICityInfoService;
import com.util.BaseControl;

/**
 * 城市信息操作Controller
 * 
 * @author John
 *
 */
@Controller
@RequestMapping("/cityInfo")
public class CityInfoController extends BaseControl {

	@Resource
	private ICityInfoService iCityInfoService;
	// 初始化JSON
	JSONObject j = null;

	/**
	 * 查询城市列表
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/cityInfo.html")
	@ResponseBody
	public void queryCity() throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 查询城市列表
		List<CityInfo> cityInfos = iCityInfoService.queryCity();

		
		//
		if (cityInfos.size() == 0) {
			// 录入数据
			j.put("cityInfos", false);
		} else {
			// 录入数据
			j.put("cityInfos", cityInfos);
		}
		
		// 返回数据
		response.getWriter().print(j);
	}
	
	/**
	 * 添加城市
	 * 
	 * @param cityInfo
	 * @throws IOException
	 */
	@RequestMapping("/addCity.html")
	@ResponseBody
	public void addCity(CityInfo cityInfo) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 类型ID
		String cityId = String.valueOf(new Date().getTime());
		cityInfo.setCityId(cityId);
		// 添加
		int flag = iCityInfoService.addCity(cityInfo);

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
