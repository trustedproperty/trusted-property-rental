package com.entity;

import java.io.Serializable;

/**
 *场地类型信息表
 * 
 * @author John
 *
 */
public class SpaceTypeInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String spaceTypeId;// 场地类型Id
	private String spaceTypeName;// 场地类型名称
	private String remark;// 备用字段

	public String getSpaceTypeId() {
		return spaceTypeId;
	}

	public void setSpaceTypeId(String spaceTypeId) {
		this.spaceTypeId = spaceTypeId;
	}

	public String getSpaceTypeName() {
		return spaceTypeName;
	}

	public void setSpaceTypeName(String spaceTypeName) {
		this.spaceTypeName = spaceTypeName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SpaceTypeInfo [spaceTypeId=" + spaceTypeId + ", spaceTypeName="
				+ spaceTypeName + ", remark=" + remark + "]";
	}
}
