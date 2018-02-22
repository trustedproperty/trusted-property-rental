package com.entity;

import java.io.Serializable;

/**
 * 场地相册信息表
 * 
 * @author John
 *
 */
public class SpacePhotoInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String photoId;//场地相册Id
	private String spaceId;// 场地ID 
	private String photoName;// 图片名称
	private String url;// 图片路径
	private String remark;// 备用字段

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SpacePhotoInfo [photoId=" + photoId + ", spaceId=" + spaceId
				+ ", photoName=" + photoName + ", url=" + url + ", remark="
				+ remark + "]";
	}

}
