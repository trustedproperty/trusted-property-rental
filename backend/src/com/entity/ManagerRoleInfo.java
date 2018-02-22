package com.entity;

import java.io.Serializable;

/**
 * 管理员角色信息表
 * 
 * @author John
 *
 */
public class ManagerRoleInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String mRoleId;// 管理员角色ID
	private String managerId;//管理员ID
	private String roleId;// 角色ID
	private String remark;// 备用字段

	public String getmRoleId() {
		return mRoleId;
	}

	public void setmRoleId(String mRoleId) {
		this.mRoleId = mRoleId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "ManagerRoleInfo [mRoleId=" + mRoleId + ", managerId="
				+ managerId + ", roleId=" + roleId + ", remark=" + remark + "]";
	}
}
