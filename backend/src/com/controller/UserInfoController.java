package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.entity.UserInfo;
import com.service.IUserInfoService;
import com.util.BaseControl;
import com.util.SendMessageUtil;

/**
 * 用户信息操作Controller
 * 
 * @author John
 *
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController extends BaseControl {

	@Resource
	private IUserInfoService iUserInfoService;
	// 初始化JSON
	JSONObject j = null;

	/**
	 * 用户登录
	 * 
	 * @param userAccount
	 * @param userPass
	 * @throws IOException
	 */
	@RequestMapping("/login.html")
	@ResponseBody
	public void isLogin(String userAccount, String userPass) throws IOException {

		// 初始化JSON
		j = new JSONObject();

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 登录验证
		UserInfo userInfo = iUserInfoService.isLogin(userAccount, userPass);

		// 判断是否登录成功
		if (userInfo != null) {
			// 存入数据
			j.put("userInfo", userInfo);
		} else {
			j.put("message", "false");
		}

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 发送验证码
	 * 
	 * @param userPhone
	 * @throws Exception
	 */
	@RequestMapping("/sendCode.html")
	@ResponseBody
	public void sendCode(String userPhone) throws Exception {

		// 初始化JSON
		j = new JSONObject();
		// 返回结果集
		List<HashMap<String, String>> loginStatus = new ArrayList<HashMap<String, String>>();
		// 单个键值
		HashMap<String, String> statusMap = new HashMap<String, String>();
		// 验证码
		String check = SendMessageUtil.randString();

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 发送短信接口
		String returnMessage = SendMessageUtil.batchSend(userPhone, check);

		// 获得返回状态码
		String a_status = returnMessage.substring(returnMessage.indexOf(",") + 1, returnMessage.length());
		String status = a_status.substring(0, a_status.indexOf("\n"));

		// 添加数据
		statusMap.put("status", status);
		// 保存在session中 验证码
		session.setAttribute("check", check);
		// 执行本步操作的当前时间
		session.setAttribute("beginTime", new Date().getTime());

		// 添加进结果集
		loginStatus.add(statusMap);

		// 录入数据
		j.put("loginStatus", loginStatus);

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 验证码登录
	 * 
	 * @param userPhone
	 * @param inputCheck
	 * @throws Exception
	 */
	@RequestMapping("/codeLogin.html")
	@ResponseBody
	public void codeLogin(String userPhone, String inputCheck) throws Exception {

		// 初始化JSON
		j = new JSONObject();

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 获取验证码
		String check = (String) session.getAttribute("check");
		// 获取开始时间
		long beginTime = (Long) session.getAttribute("beginTime");
		// 获取当前时间
		long nowTime = new Date().getTime();
		// 得到有效期
		long mins = nowTime - beginTime;
		// 比较数
		long num = 60000;

		// 查询用户是否注册
		UserInfo isUser = iUserInfoService.queryPhone(userPhone);
		// 是否存在用户
		if (isUser != null) {
			// 验证码是否相同
			if (check.equals(inputCheck)) {
				// 判断是否过验证码有效期
				if (num > mins) {
					// 查询用户信息
					isUser = iUserInfoService.queryPhone(userPhone);
					// 录入数据
					j.put("userInfo", isUser);
				} else {
					// 录入数据
					j.put("userInfo", false);
				}
			} else {
				// 录入数据
				j.put("userInfo", false);
			}

		} else {

			// 注册用户
			UserInfo userInfo = new UserInfo();
			String userId = String.valueOf(new Date().getTime());
			userInfo.setUserId(userId);
			userInfo.setUserPhone(userPhone);
			userInfo.setUserName(userPhone);
			userInfo.setUserImg("headImg.png");
			// 执行添加
			int isFlag = iUserInfoService.registUser(userInfo);
			// 是否注册成功
			if (isFlag > 0) {
				// 验证码是否相同
				if (check.equals(inputCheck)) {
					// 判断是否过验证码有效期
					if (num > mins) {
						// 查询用户信息
						isUser = iUserInfoService.queryPhone(userPhone);
						// 录入数据
						j.put("userInfo", isUser);
					} else {
						// 录入数据
						j.put("userInfo", false);
					}
				} else {
					// 录入数据
					j.put("userInfo", false);
				}
			} else {
				// 录入数据
				j.put("userInfo", false);
			}
		}

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 注册用户
	 * 
	 * @param userPhone
	 * @param inputCheck
	 * @param userPass
	 * @throws Exception
	 */
	@RequestMapping("/registerUser.html")
	@ResponseBody
	public void registerUser(String userPhone, String inputCheck, String userPass) throws Exception {

		// 初始化JSON
		j = new JSONObject();

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 获取验证码
		String check = (String) session.getAttribute("check");
		// 获取开始时间
		long beginTime = (Long) session.getAttribute("beginTime");
		// 获取当前时间
		long nowTime = new Date().getTime();
		// 得到有效期
		long mins = nowTime - beginTime;
		// 比较数
		long num = 60000;

		// 验证码是否相同
		if (check.equals(inputCheck)) {
			// 判断是否过验证码有效期
			if (num > mins) {
				// 查询用户是否注册
				UserInfo user = iUserInfoService.queryPhone(userPhone);
				if (user == null) {
					// 注册用户
					UserInfo userInfo = new UserInfo();
					String userId = String.valueOf(new Date().getTime());
					userInfo.setUserId(userId);
					userInfo.setUserPhone(userPhone);
					userInfo.setUserPass(userPass);
					userInfo.setUserName(userPhone);
					userInfo.setUserImg("headImg.png");
					// 注册用户
					int flag = iUserInfoService.registUser(userInfo);
					// 成功
					if (flag > 0) {
						// 查询用户信息
						UserInfo isUser = iUserInfoService.queryPhone(userPhone);
						// 是否为空
						if (isUser == null) {
							// 录入数据
							j.put("userInfo", false);
						} else {
							// 录入数据
							j.put("userInfo", isUser);
						}
					}
				} else {
					// 修改密码
					int flag = iUserInfoService.setPass(userPhone, userPass);
					// 成功
					if (flag > 0) {
						// 查询用户信息
						UserInfo isUser = iUserInfoService.queryPhone(userPhone);
						// 录入数据
						j.put("userInfo", isUser);
					} else {
						// 录入数据
						j.put("userInfo", false);
					}
				}
			} else {
				// 录入数据
				j.put("userInfo", false);
			}
		} else {
			// 录入数据
			j.put("userInfo", false);
		}

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 查询用户信息
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/queryUserDetail.html")
	@ResponseBody
	public void queryUserDetail(String userId) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 查询用户信息
		UserInfo userInfo = iUserInfoService.queryUserDetail(userId);

		// 录入数据
		j.put("userInfo", userInfo);

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param userInfo
	 * @throws IOException
	 */
	@RequestMapping("/settingUser.html")
	@ResponseBody
	public void setUser(UserInfo userInfo) throws IOException {

		// 初始化JSON
		j = new JSONObject();

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 非空验证
		if (userInfo.getUserName() == "" || userInfo.getUserPhone() == "") {
			// 存入数据
			j.put("message", false);
		} else {
			// 修改
			int flag = iUserInfoService.setUser(userInfo);

			// 成功
			if (flag > 0) {
				// 存入数据
				j.put("message", true);
			} else {
				// 存入数据
				j.put("message", false);
			}
		}

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 上传用户图片
	 * 
	 * @param file
	 * @throws IOException
	 */
	@RequestMapping("/sendUserImg.html")
	@ResponseBody
	public void upload(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 获取根目录
		File f = new File(session.getServletContext().getRealPath("/"));
		// 得到文件上传目录
		String path = f.getParent() + "/upload/changdipai/images/avatar";

		// 获取上传文件名
		String fileName = file.getOriginalFilename();

		// 原名称里倒数第一个”.”在哪里
		int i = fileName.lastIndexOf(".");
		// 取得后缀，及”.”后面的字符
		String ext = fileName.substring(i + 1);
		// 重命名文件
		fileName = new Date().getTime() + "." + ext;

		// 添加到根目录
		File targetFile = new File(path, fileName);

		// 判断是否存在
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			// 写入文件
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 录入数据
		j.put("fileName", fileName);
		// 返回数据
		response.getWriter().println(j);
	}

	/**
	 * 修改用户手机号
	 * 
	 * @param userId
	 * @param oldPhone
	 * @param userPhone
	 * @param inputCheck
	 * @throws IOException
	 */
	@RequestMapping("/updateUserPhone.html")
	@ResponseBody
	public void editPhone(String userId, String oldPhone, String userPhone, String inputCheck) throws IOException {

		// 初始化JSON
		j = new JSONObject();

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 获取验证码
		String check = (String) session.getAttribute("check");
		// 获取开始时间
		long saveTime = (Long) session.getAttribute("beginTime");
		// 获取当前时间
		long nowTime = new Date().getTime();
		// 得到有效期
		long mins = nowTime - saveTime;
		// 比较数
		long num = 60000;

		// 验证码是否相同
		if (check.equals(inputCheck)) {
			// 判断是否过验证码有效期
			if (num > mins) {
				// 非空验证
				if (userId == "" || oldPhone == "" || userPhone == "") {
					// 存入数据
					j.put("error", "必填参数不能为空");
				} else {
					// 验证手机号是否与原手机号相同
					UserInfo userInfo = iUserInfoService.queryUserDetail(userId);
					if (userInfo.getUserPhone().equals(oldPhone)) {
						// 查询手机号是否已绑定
						UserInfo user = iUserInfoService.queryPhone(userPhone);
						if (user == null) {
							// 修改
							int flag = iUserInfoService.editPhone(userId, userPhone);
							// 成功
							if (flag > 0) {
								// 成功消息
								j.put("message", "success");
							} else {
								j.put("error", "修改失败");
							}
						} else {
							j.put("error", "该手机已被绑定");
						}
					} else {
						j.put("error", "原手机号不正确");
					}
				}
			} else {
				j.put("error", "验证码已过期");
			}
		} else {
			j.put("error", "验证码不正确");
		}

		// 返回数据
		response.getWriter().print(j);
	}
}
