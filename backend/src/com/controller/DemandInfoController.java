package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.entity.DemandInfo;
import com.service.IAuthorityInfoService;
import com.service.IDemandInfoService;
import com.util.BaseControl;

/**
 * 需求信息操作Controller
 * 
 * @author John
 *
 */
@Controller
@RequestMapping("/demandInfo")
public class DemandInfoController extends BaseControl {

	@Resource
	private IDemandInfoService iDemandInfoService;
	@Resource
	private IAuthorityInfoService iAuthorityInfoService;
	// 初始化JSON
	JSONObject j = null;
	// 格式化时间
	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH");

	/**
	 * 需求管理列表
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/demandInfo.html")
	@ResponseBody
	public void queryDemand() throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 查询全部需求列表
		List<DemandInfo> demandInfos = iDemandInfoService.queryDemands();
		// 查询未联系需求列表
		List<DemandInfo> noContact = iDemandInfoService.queryNoDemand();

		// 录入数据
		j.put("demandInfos", demandInfos);
		j.put("noContact", noContact);

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 查看详情
	 * 
	 * @param demandId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/queryById.html")
	@ResponseBody
	public void queryById(String demandId) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 查询数据
		DemandInfo demandInfo = iDemandInfoService.queryDetil(demandId);

		// 录入数据
		j.put("demandDetail", demandInfo);

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 修改需求信息
	 * 
	 * @param demandInfo
	 * @return
	 * @throws IOException
	 * @throws ParseException 
	 */
	@RequestMapping("/updateDemand.html")
	@ResponseBody
	public void updateDemand(DemandInfo demandInfo) throws IOException, ParseException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 判断权限
		if (iAuthorityInfoService.checkAuthority(demandInfo.getVisitId(), "editDemand") > 0) {
			// 执行修改
			int flag = iDemandInfoService.updateDemand(demandInfo);

			// 是否修改成功
			if (flag > 0) {
				j.put("message", "success");
			} else {
				j.put("message", "failed");
			}

		} else {
			j.put("message", "failed");
		}

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 修改需求状态
	 * 
	 * @param demandInfo
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/updateStatus.html")
	@ResponseBody
	public void updateDemand(int demandStatus, String demandId, String visitId) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 判断权限
		if (iAuthorityInfoService.checkAuthority(visitId, "editDemand") > 0) {
			// 分割参数
			String str[] = demandId.split(",");
			// 设置参数列表
			List<DemandInfo> list = new ArrayList<DemandInfo>();

			// 设置参数
			for (int i = 0; i < str.length; i++) {
				// 初始化实体
				DemandInfo demandInfo = new DemandInfo();
				demandInfo.setDemandId(str[i]);
				demandInfo.setDemandStatus(demandStatus);
				list.add(demandInfo);
			}

			// 执行修改
			int flag = iDemandInfoService.updateStatus(list);

			// 是否修改成功
			if (flag > 0) {
				j.put("message", "success");
			} else {
				j.put("message", "failed");
			}

		} else {
			j.put("message", "failed");
		}

		// 返回数据
		response.getWriter().print(j);
	}
}
