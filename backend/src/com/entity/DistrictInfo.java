package com.entity;

/**
 * 城区信息表
 * 
 * @author John
 *
 */
public class DistrictInfo {

	private String districtId;// 城区Id
	private String districtName;// 城区名称
	private String cityId;// 所在城市Id

	// 临时存储数据(城市名称)
	private String cityName;// 城市名称

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "DistrictInfo [districtId=" + districtId + ", districtName=" + districtName + ", cityId=" + cityId
				+ ", cityName=" + cityName + "]";
	}

}
