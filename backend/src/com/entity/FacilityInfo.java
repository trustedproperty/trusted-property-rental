package com.entity;

import java.io.Serializable;

/**
 * 设备信息表
 * 
 * @author John
 *
 */
public class FacilityInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String facilityId;// 设备ID
	private String facilityName;// 设备名称
	private String remark;// 备用字段

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "FacilityInfo [facilityId=" + facilityId + ", facilityName=" + facilityName + ", remark=" + remark + "]";
	}

}
