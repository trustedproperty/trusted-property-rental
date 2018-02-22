package com.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.entity.AuthorityInfo;
import com.service.IAuthorityInfoService;
import com.util.BaseControl;

/**
 * 城市信息操作Controller
 * 
 * @author John
 *
 */
@Controller
@RequestMapping("/authorityInfo")
public class AuthorityInfoController extends BaseControl {

	@Resource
	private IAuthorityInfoService iAuthorityInfoService;
	// 初始化JSON
	JSONObject j = null;

	/**
	 * 查询管理员权限
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/queryAuthorityInfo.html")
	@ResponseBody
	public void queryAuthorityInfo(String managerId) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 查询权限列表
		List<AuthorityInfo> authorityInfos = iAuthorityInfoService.queryAuthority(managerId);

		//
		if (authorityInfos.size() == 0) {
			// 录入数据
			j.put("authorityInfos", false);
		} else {
			// 录入数据
			j.put("authorityInfos", authorityInfos);
		}

		// 返回数据
		response.getWriter().print(j);
	}
}
