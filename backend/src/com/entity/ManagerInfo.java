package com.entity;

import java.io.Serializable;

/**
 * 
 * @author John
 * 
 *         管理员信息表
 *
 */
public class ManagerInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String managerId;// 管理员ID
	private String managerName;// 管理员名称
	private String managerTrueName;// 管理员真实姓名
	private String managerPass;// 密码
	private String phone;// 联系电话
	private String managerIntroduce;// 介绍
	private int status;// 状态
	private String remark;// 备用字段

	private String roleName;// 用户角色
	private String roleId;// 临时角色Id
	private String visitId;// 访问者Id

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerTrueName() {
		return managerTrueName;
	}

	public void setManagerTrueName(String managerTrueName) {
		this.managerTrueName = managerTrueName;
	}

	public String getManagerPass() {
		return managerPass;
	}

	public void setManagerPass(String managerPass) {
		this.managerPass = managerPass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getManagerIntroduce() {
		return managerIntroduce;
	}

	public void setManagerIntroduce(String managerIntroduce) {
		this.managerIntroduce = managerIntroduce;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ManagerInfo [managerId=" + managerId + ", managerName=" + managerName + ", managerTrueName="
				+ managerTrueName + ", managerPass=" + managerPass + ", phone=" + phone + ", managerIntroduce="
				+ managerIntroduce + ", status=" + status + ", remark=" + remark + ", roleName=" + roleName
				+ ", roleId=" + roleId + ", visitId=" + visitId + "]";
	}

}
