package com.service;

import org.apache.ibatis.annotations.Param;

import com.entity.UserInfo;

public interface IUserInfoService {

	/**
	 * 用户详情
	 * 
	 * @param userId
	 * @return
	 */
	public UserInfo queryById(@Param("userId") String userId);
	
	/**
	 * 用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public UserInfo queryUserDetail(@Param("userId") String userId);

	/**
	 * 登录
	 * 
	 * @param userPhone
	 * @param userPass
	 * @return
	 */
	public UserInfo isLogin(@Param("userAccount") String userAccount, @Param("userPass") String userPass);

	/**
	 * 根据手机号查看用户
	 * 
	 * @param userPhone
	 * @return
	 */
	public UserInfo queryPhone(@Param("userPhone") String userPhone);

	/**
	 * 注册用户
	 * 
	 * @param userInfo
	 * @return
	 */
	public int registUser(UserInfo userInfo);
	
	/**
	 * 修改用户信息
	 * 
	 * @param userInfo
	 * @return
	 */
	public int setUser(UserInfo userInfo);
	
	/**
	 * 修改密码
	 * 
	 * @param userPhone
	 * @param userPass
	 * @return
	 */
	public int setPass(@Param("userPhone") String userPhone,@Param("userPass") String userPass);
	
	/**
	 * 修改用户手机号
	 * 
	 * @param userId
	 * @return
	 */
	public int editPhone(@Param("userId") String userId,@Param("userPhone") String userPhone);
}
