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
import com.entity.FacilityInfo;
import com.service.IFacilityInfoService;
import com.util.BaseControl;

/**
 * 设备设施信息操作Controller
 *
 * @author John
 *
 */
@Controller
@RequestMapping("/facilityInfo")
public class FacilityInfoController extends BaseControl {

	@Resource
	private IFacilityInfoService iFacilityInfoService;
	// 初始化JSON
	JSONObject j = null;

	/**
	 * 查询设施列表
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/facilityInfo.html")
	@ResponseBody
	public void queryFacility() throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 查询城市列表
		List<FacilityInfo> facilityInfos = iFacilityInfoService.queryFacility();

		// 录入数据
		j.put("facilityInfos", facilityInfos);

		// 返回数据
		response.getWriter().print(j);
	}
	
	/**
	 * 添加設備
	 * 
	 * @param facilityInfo
	 * @throws IOException
	 */
	@RequestMapping("/addFacility.html")
	@ResponseBody
	public void addFacility(FacilityInfo facilityInfo) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		//設施ID
		String facilityId = String.valueOf(new Date().getTime());
		facilityInfo.setFacilityId(facilityId);
		//添加
		int flag = iFacilityInfoService.addFacility(facilityInfo);
		
		//成功
		if(flag>0){
			// 录入数据
			j.put("message", true);
		}else{
			// 录入数据
			j.put("message", false);
		}

		// 返回数据
		response.getWriter().print(j);
	}
	
	
	/**
	 * 批量添加设施
	 * 
	 * @param facilityName
	 * @throws IOException
	 */
	@RequestMapping("/insertFacility.html")
	@ResponseBody
	public void insertFacility(String  facilityName) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		//设置参数
		List<FacilityInfo> list = new ArrayList<FacilityInfo>();
		
		String str[] = facilityName.split(",");
		
		for(int i=0;i<str.length;i++){
			FacilityInfo facilityInfo = new FacilityInfo();
			//設施ID
			String facilityId = String.valueOf(new Date().getTime()+i);
			facilityInfo.setFacilityId(facilityId);
			facilityInfo.setFacilityName(str[i]);
			list.add(facilityInfo);
		}
		
		//添加
		int flag = iFacilityInfoService.insertFacility(list);
		
		//成功
		if(flag>0){
			// 录入数据
			j.put("message", true);
		}else{
			// 录入数据
			j.put("message", false);
		}

		// 返回数据
		response.getWriter().print(j);
	}
}
