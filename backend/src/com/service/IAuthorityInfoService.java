package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.AuthorityInfo;

public interface IAuthorityInfoService {

	/**
	 * 查询管理员权限
	 * 
	 * @param managerId
	 * @return
	 */
	public List<AuthorityInfo> queryAuthority(@Param("managerId") String managerId);
	
	/**
	 * 查询操作权限 
	 * 
	 * @param managerId
	 * @param authorityName
	 * @return
	 */
	public int checkAuthority(@Param("managerId") String managerId,@Param("authorityName") String authorityName);
}
