package com.entity;

import java.io.Serializable;

/**
 * 用户信息表
 * 
 * @author John
 *
 */
public class UserInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String userId;// 用户Id
	private String userPhone;// 用户手机号
	private String userPass;// 密码
	private String userName;// 用户名
	private String trueName;// 真实名字
	private String userAddress;//常用地址
	private String userIntroduce;// 用户简介
	private String userImg;// 头像
	private String userCard;// 用户证件信息
	private String userPay;// 收付款信息
	private String userActive;// 用户状态(默认为0：生效)
	private String remark;// 备用字段

	private int favoriteCount;// 收藏数
	private int demandCount;// 需求数

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserIntroduce() {
		return userIntroduce;
	}

	public void setUserIntroduce(String userIntroduce) {
		this.userIntroduce = userIntroduce;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getUserCard() {
		return userCard;
	}

	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}

	public String getUserPay() {
		return userPay;
	}

	public void setUserPay(String userPay) {
		this.userPay = userPay;
	}

	public String getUserActive() {
		return userActive;
	}

	public void setUserActive(String userActive) {
		this.userActive = userActive;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public int getDemandCount() {
		return demandCount;
	}

	public void setDemandCount(int demandCount) {
		this.demandCount = demandCount;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userPhone=" + userPhone
				+ ", userPass=" + userPass + ", userName=" + userName
				+ ", trueName=" + trueName + ", userAddress=" + userAddress
				+ ", userIntroduce=" + userIntroduce + ", userImg=" + userImg
				+ ", userCard=" + userCard + ", userPay=" + userPay
				+ ", userActive=" + userActive + ", remark=" + remark
				+ ", favoriteCount=" + favoriteCount + ", demandCount="
				+ demandCount + "]";
	}

}
