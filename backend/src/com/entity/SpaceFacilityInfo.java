package com.entity;

import java.io.Serializable;

/**
 * 场地设备信息表
 * 
 * @author John
 *
 */
public class SpaceFacilityInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String spaceFacilityId;// 场地设备ID
	private String spaceId;// 场地ID
	private String facilityId;// 设备ID
	private FacilityInfo facilityInfo;// 设备实体
	private String remark;// 备用字段

	public String getSpaceFacilityId() {
		return spaceFacilityId;
	}

	public void setSpaceFacilityId(String spaceFacilityId) {
		this.spaceFacilityId = spaceFacilityId;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public FacilityInfo getFacilityInfo() {
		return facilityInfo;
	}

	public void setFacilityInfo(FacilityInfo facilityInfo) {
		this.facilityInfo = facilityInfo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SpaceFacilityInfo [spaceFacilityId=" + spaceFacilityId + ", spaceId=" + spaceId + ", facilityId="
				+ facilityId + ", facilityInfo=" + facilityInfo + ", remark=" + remark + "]";
	}

}
