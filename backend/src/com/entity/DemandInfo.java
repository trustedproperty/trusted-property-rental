package com.entity;

import java.io.Serializable;

/**
 * 需求信息表
 * 
 * @author John
 *
 */
public class DemandInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String demandId;// 主键，需求Id
	private String spaceId;// 需求场地Id
	private String demandSpace;// 需求场地
	private String demandCity;// 举办城市
	private String districtId;// 区域
	private String demandNum;// 人数范围
	private String timeLength;// 持续时长
	private String activityType;// 活动类型
	private String time;// 发布时间
	private String beginTime;// 活动开始日期
	private String price;// 预算价格
	private String userId;// 用户ID
	private String contacts;// 联系人
	private String contactsPhone;// 联系人手机号
	private int demandStatus;// 需求状态 未审核。已联系。已无效
	private String timeFloat;// 时间浮动说明 浮动1小时，1天等
	private String additionalDemand;// 额外需求 如人数，预算
	private String demandDescribe;// 额外需求描述
	private String priorityArea;// 优先区域
	private String spaceEquip;// 场地设施
	private String equipDescribe;// 场地设施描述
	private String unitName;// 单位名称
	private String remark;// 备用字段

	private String visitId;// 访问者Id
	private String inputCheck;// 验证码

	public String getDemandId() {
		return demandId;
	}

	public void setDemandId(String demandId) {
		this.demandId = demandId;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public String getDemandSpace() {
		return demandSpace;
	}

	public void setDemandSpace(String demandSpace) {
		this.demandSpace = demandSpace;
	}

	public String getDemandCity() {
		return demandCity;
	}

	public void setDemandCity(String demandCity) {
		this.demandCity = demandCity;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getDemandNum() {
		return demandNum;
	}

	public void setDemandNum(String demandNum) {
		this.demandNum = demandNum;
	}

	public String getTimeLength() {
		return timeLength;
	}

	public void setTimeLength(String timeLength) {
		this.timeLength = timeLength;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getContactsPhone() {
		return contactsPhone;
	}

	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}

	public int getDemandStatus() {
		return demandStatus;
	}

	public void setDemandStatus(int demandStatus) {
		this.demandStatus = demandStatus;
	}

	public String getTimeFloat() {
		return timeFloat;
	}

	public void setTimeFloat(String timeFloat) {
		this.timeFloat = timeFloat;
	}

	public String getAdditionalDemand() {
		return additionalDemand;
	}

	public void setAdditionalDemand(String additionalDemand) {
		this.additionalDemand = additionalDemand;
	}

	public String getDemandDescribe() {
		return demandDescribe;
	}

	public void setDemandDescribe(String demandDescribe) {
		this.demandDescribe = demandDescribe;
	}

	public String getPriorityArea() {
		return priorityArea;
	}

	public void setPriorityArea(String priorityArea) {
		this.priorityArea = priorityArea;
	}

	public String getSpaceEquip() {
		return spaceEquip;
	}

	public void setSpaceEquip(String spaceEquip) {
		this.spaceEquip = spaceEquip;
	}

	public String getEquipDescribe() {
		return equipDescribe;
	}

	public void setEquipDescribe(String equipDescribe) {
		this.equipDescribe = equipDescribe;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public String getInputCheck() {
		return inputCheck;
	}

	public void setInputCheck(String inputCheck) {
		this.inputCheck = inputCheck;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DemandInfo [demandId=" + demandId + ", spaceId=" + spaceId + ", demandSpace=" + demandSpace
				+ ", demandCity=" + demandCity + ", districtId=" + districtId + ", demandNum=" + demandNum
				+ ", timeLength=" + timeLength + ", activityType=" + activityType + ", time=" + time + ", beginTime="
				+ beginTime + ", price=" + price + ", userId=" + userId + ", contacts=" + contacts + ", contactsPhone="
				+ contactsPhone + ", demandStatus=" + demandStatus + ", timeFloat=" + timeFloat + ", additionalDemand="
				+ additionalDemand + ", demandDescribe=" + demandDescribe + ", priorityArea=" + priorityArea
				+ ", spaceEquip=" + spaceEquip + ", equipDescribe=" + equipDescribe + ", unitName=" + unitName
				+ ", remark=" + remark + ", visitId=" + visitId + ", inputCheck=" + inputCheck + "]";
	}
}
