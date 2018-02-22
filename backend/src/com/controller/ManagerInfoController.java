package com.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.entity.ManagerInfo;
import com.service.IAuthorityInfoService;
import com.service.IManagerInfoService;
import com.util.BaseControl;

/**
 * 管理员信息Controller
 * 
 * @author John
 *
 */
@Controller
@RequestMapping("/manager")
public class ManagerInfoController extends BaseControl {

	@Resource
	private IManagerInfoService iManagerInfoService;
	@Resource
	private IAuthorityInfoService iAuthorityInfoService;
	// 初始化JSON
	JSONObject j = null;

	/**
	 * 登录
	 * 
	 * @param managerId
	 * @param managerPass
	 * @throws IOException
	 */
	@RequestMapping("/isLogin.html")
	@ResponseBody
	public void isLogin(String managerName, String managerPass) throws IOException {

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 初始化JSON
		j = new JSONObject();

		// 查询
		ManagerInfo flag = iManagerInfoService.isLogin(managerName, managerPass);

		// 是否存在用户
		if (flag == null) {
			j.put("message", "failed");
		} else {
			// 录入数据
			j.put("managerInfo", flag);
		}
		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 根据名称查询管理员
	 * 
	 * @param managerId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/queryByName.html")
	@ResponseBody
	public void queryById(String managerName) throws IOException {

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 初始化JSON
		j = new JSONObject();

		// 查询管理员信息
		ManagerInfo managerInfo = iManagerInfoService.queryByName(managerName);

		// 判断
		if (managerInfo == null) {
			j.put("message", "false");
		} else {
			// 录入数据
			j.put("managerInfo", managerInfo);
		}

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 
	 * 查询管理员信息
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/queryManager.html")
	@ResponseBody
	public void queryManager() throws IOException {

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 初始化JSON
		j = new JSONObject();

		// 查询管理员信息
		List<ManagerInfo> managerInfo = iManagerInfoService.queryManager();

		// 判断
		if (managerInfo == null) {
			j.put("error", "false");
		} else {
			// 录入数据
			j.put("managerInfo", managerInfo);
		}

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 添加管理员
	 * 
	 * @param managerInfo
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/addManager.html")
	@ResponseBody
	public void addManager(ManagerInfo managerInfo) throws IOException {

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 初始化JSON
		j = new JSONObject();

		// 判断权限
		if (iAuthorityInfoService.checkAuthority(managerInfo.getVisitId(), "addManager") > 0) {
			// 管理员Id
			String managerId = String.valueOf(new Date().getTime());
			// 设置参数
			managerInfo.setManagerId(managerId);
			// 判断管理员名是否为空
			if (managerInfo.getManagerName().equals("")) {
				managerInfo.setManagerName(managerId);
			} else {
				// 查询管理员是否存在
				ManagerInfo info = iManagerInfoService.isCheck(managerInfo.getManagerName());
				if (info != null) {
					managerInfo.setManagerName(managerId);
				}
			}
			// 执行添加
			int flag = iManagerInfoService.addManager(managerInfo);
			// 添加角色
			int flg = iManagerInfoService.addRole(managerId, managerId, managerInfo.getRoleId());

			// 判断
			if (flag > 0 && flg > 0) {
				// 录入数据
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
	 * 修改管理员信息
	 * 
	 * @param managerInfo
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/updateManager.html")
	@ResponseBody
	public void updateManager(ManagerInfo managerInfo) throws IOException {

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 初始化JSON
		j = new JSONObject();

		// 判断权限
		if (iAuthorityInfoService.checkAuthority(managerInfo.getVisitId(), "editManager") > 0) {
			// 执行修改
			int flag = iManagerInfoService.updateManager(managerInfo);

			// 判断
			if (flag > 0) {
				// 录入数据
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
	 * 个人设置 --- 修改管理员信息
	 * 
	 * @param managerInfo
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/editManager.html")
	@ResponseBody
	public void editManager(ManagerInfo managerInfo) throws IOException {

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 初始化JSON
		j = new JSONObject();

		// 执行修改
		int flag = iManagerInfoService.editManager(managerInfo);

		// 判断
		if (flag > 0) {
			// 录入数据
			j.put("message", "success");
		} else {
			j.put("message", "failed");
		}

		// 返回数据
		response.getWriter().print(j);
	}
}
