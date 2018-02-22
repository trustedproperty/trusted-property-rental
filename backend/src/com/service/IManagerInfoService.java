package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.ManagerInfo;

/**
 * 管理员信息Service层
 * 
 * @author John
 *
 */
public interface IManagerInfoService {

	/**
	 * 登录
	 * 
	 * @param managerId
	 * @param managerPass
	 * @return
	 */
	public ManagerInfo isLogin(@Param("managerName") String managerName, @Param("managerPass") String managerPass);

	/**
	 * 查询管理员信息
	 * 
	 * @return
	 */
	public List<ManagerInfo> queryManager();

	/**
	 * 添加管理员
	 * 
	 * @param manager
	 * @return
	 */
	public int addManager(ManagerInfo managerInfo);

	/**
	 * 添加管理员角色
	 * 
	 * @param managerRoleInfo
	 * @return
	 */
	public int addRole(@Param("mRoleId") String mRoleId, @Param("managerId") String managerId,
			@Param("roleId") String roleId);

	/**
	 * 删除管理员
	 * 
	 * @param managerId
	 * @return
	 */
	public int removeManager(@Param("managerId") String managerId);

	/**
	 * 查询总行数
	 * 
	 * @return
	 */
	public int queryCount();

	/**
	 * 根据id查询管理员信息
	 * 
	 * @param managerId
	 * @return
	 */
	public ManagerInfo queryByName(@Param("managerName") String managerName);

	/**
	 * 修改管理员
	 * 
	 * @param managerInfo
	 * @return
	 */
	public int updateManager(ManagerInfo managerInfo);

	/**
	 * 个人设置 ----修改用户信息
	 * 
	 * @param managerInfo
	 * @return
	 */
	public int editManager(ManagerInfo managerInfo);

	/**
	 * 查询管理员是否存在
	 * 
	 * @param managerName
	 * @return
	 */
	public ManagerInfo isCheck(@Param("managerName") String managerName);

}
