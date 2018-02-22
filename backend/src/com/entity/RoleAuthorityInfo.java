package com.entity;

import java.io.Serializable;

/**
 * 角色权限信息表
 * 
 * @author John
 *
 */
public class RoleAuthorityInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String roleAuthorityId;//角色权限ID
	private String roleId;// 角色ID
	private String authorityId;// 权限ID
	private String remark;// 备用字段

	public String getRoleAuthorityId() {
		return roleAuthorityId;
	}

	public void setRoleAuthorityId(String roleAuthorityId) {
		this.roleAuthorityId = roleAuthorityId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "RoleAuthorityInfo [roleAuthorityId=" + roleAuthorityId
				+ ", roleId=" + roleId + ", authorityId=" + authorityId
				+ ", remark=" + remark + "]";
	}
}
