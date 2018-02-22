package com.entity;

import java.io.Serializable;

/**
 * 场地信息表
 * 
 * @author John
 *
 */
public class SpaceInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String spaceId;// 场地ID
	private String cityId;// 城市ID
	private String districtId;// 城区Id
	private String spaceTypeId;// 场地类型
	private SpaceTypeInfo spaceTypeInfo;// 场地类型实体
	private String spaceName;// 场地名称
	private String legalName;// 自定义名称
	private String spacePrice;// 场地价格
	private String priceList;// 价格类型列表
	private String spaceNum;// 人数范围
	private String spaceArea;// 面积
	private String isAvailable;// 可用性
	private String introduce;// 场地简介
	private String spacePolicy;// 场地政策
	private String reservationPolicy;// 预定政策
	private String spacePhoto;// 场地图片
	private String spaceAddress;// 地址地址ַ
	private String spaceDetailAddress;// 地址详细地址ַ
	private String position;// 地址坐标
	private int hotSpace;// 热度
	private String hostId;// 场地用户ID
	private int spaceStatus;// 场地状态

	private String facilityId;// 临时设施Id
	private String trueName;// 场主
	private String spaceTypeName;// 活动类型
	private String cityName;// 城市名称
	private String visitId;// 访问者Id

	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getSpaceTypeId() {
		return spaceTypeId;
	}

	public void setSpaceTypeId(String spaceTypeId) {
		this.spaceTypeId = spaceTypeId;
	}

	public SpaceTypeInfo getSpaceTypeInfo() {
		return spaceTypeInfo;
	}

	public void setSpaceTypeInfo(SpaceTypeInfo spaceTypeInfo) {
		this.spaceTypeInfo = spaceTypeInfo;
	}

	public String getSpaceName() {
		return spaceName;
	}

	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getSpacePrice() {
		return spacePrice;
	}

	public void setSpacePrice(String spacePrice) {
		this.spacePrice = spacePrice;
	}

	public String getPriceList() {
		return priceList;
	}

	public void setPriceList(String priceList) {
		this.priceList = priceList;
	}

	public String getSpaceNum() {
		return spaceNum;
	}

	public void setSpaceNum(String spaceNum) {
		this.spaceNum = spaceNum;
	}

	public String getSpaceArea() {
		return spaceArea;
	}

	public void setSpaceArea(String spaceArea) {
		this.spaceArea = spaceArea;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getSpacePolicy() {
		return spacePolicy;
	}

	public void setSpacePolicy(String spacePolicy) {
		this.spacePolicy = spacePolicy;
	}

	public String getReservationPolicy() {
		return reservationPolicy;
	}

	public void setReservationPolicy(String reservationPolicy) {
		this.reservationPolicy = reservationPolicy;
	}

	public String getSpacePhoto() {
		return spacePhoto;
	}

	public void setSpacePhoto(String spacePhoto) {
		this.spacePhoto = spacePhoto;
	}

	public String getSpaceAddress() {
		return spaceAddress;
	}

	public void setSpaceAddress(String spaceAddress) {
		this.spaceAddress = spaceAddress;
	}

	public String getSpaceDetailAddress() {
		return spaceDetailAddress;
	}

	public void setSpaceDetailAddress(String spaceDetailAddress) {
		this.spaceDetailAddress = spaceDetailAddress;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getHotSpace() {
		return hotSpace;
	}

	public void setHotSpace(int hotSpace) {
		this.hotSpace = hotSpace;
	}

	public String getHostId() {
		return hostId;
	}

	public void setHostId(String hostId) {
		this.hostId = hostId;
	}

	public int getSpaceStatus() {
		return spaceStatus;
	}

	public void setSpaceStatus(int spaceStatus) {
		this.spaceStatus = spaceStatus;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getSpaceTypeName() {
		return spaceTypeName;
	}

	public void setSpaceTypeName(String spaceTypeName) {
		this.spaceTypeName = spaceTypeName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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
		return "SpaceInfo [spaceId=" + spaceId + ", cityId=" + cityId + ", districtId=" + districtId + ", spaceTypeId="
				+ spaceTypeId + ", spaceTypeInfo=" + spaceTypeInfo + ", spaceName=" + spaceName + ", legalName="
				+ legalName + ", spacePrice=" + spacePrice + ", priceList=" + priceList + ", spaceNum=" + spaceNum
				+ ", spaceArea=" + spaceArea + ", isAvailable=" + isAvailable + ", introduce=" + introduce
				+ ", spacePolicy=" + spacePolicy + ", reservationPolicy=" + reservationPolicy + ", spacePhoto="
				+ spacePhoto + ", spaceAddress=" + spaceAddress + ", spaceDetailAddress=" + spaceDetailAddress
				+ ", position=" + position + ", hotSpace=" + hotSpace + ", hostId=" + hostId + ", spaceStatus="
				+ spaceStatus + ", facilityId=" + facilityId + ", trueName=" + trueName + ", spaceTypeName="
				+ spaceTypeName + ", cityName=" + cityName + ", visitId=" + visitId + "]";
	}
}
