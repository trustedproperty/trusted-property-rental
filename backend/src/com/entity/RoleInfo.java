package com.entity;

import java.io.Serializable;

/**
 * 角色信息表
 * 
 * @author John
 *
 */
public class RoleInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String roleId;//角色ID
	private String roleName;// 角色名称
	private String roleIntroduce;//角色介绍
	private String remark;// 备用字段

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleIntroduce() {
		return roleIntroduce;
	}

	public void setRoleIntroduce(String roleIntroduce) {
		this.roleIntroduce = roleIntroduce;
	}

	public String getRemark() {
		return remark;
	}

	@Override
	public String toString() {
		return "RoleInfo [roleId=" + roleId + ", roleName=" + roleName
				+ ", roleIntroduce=" + roleIntroduce + ", remark=" + remark
				+ "]";
	}

}
