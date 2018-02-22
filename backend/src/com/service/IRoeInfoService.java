package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.RoleInfo;

/**
 * ��ɫ��ϢService��
 * 
 * @author John
 *
 */
public interface IRoeInfoService {

	/**
	 * 添加角色
	 * 
	 * @param role
	 * @return
	 */
	public int addRole(RoleInfo roleInfo);

	/**
	 * 查询角色列表
	 * 
	 * @return
	 */
	public List<RoleInfo> queryRole();

	/**
	 * 删除角色
	 * 
	 * @param roleId
	 * @return
	 */
	public int removeRole(@Param("roleId") String roleId);
}
