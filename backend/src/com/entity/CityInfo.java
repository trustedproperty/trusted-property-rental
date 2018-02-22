package com.entity;

import java.io.Serializable;

/**
 * 城市信息表
 * 
 * @author John
 *
 */
public class CityInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String cityId;// 城市Id
	private String cityName;// 城市名称
	private String remark;// 备用字段

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "CityInfo [cityId=" + cityId + ", cityName=" + cityName
				+ ", remark=" + remark + "]";
	}
}
