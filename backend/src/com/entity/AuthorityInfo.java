package com.entity;

import java.io.Serializable;

/**
 * 
 * @author John
 * 
 *        权限信息表
 *
 */
public class AuthorityInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String authorityId;//权限ID
	private String authorityName;//权限名称
	private String authorityUrl;//权限路径
	private String authorityImage;//权限图片
	private String superiorId;// 上级ID
	private String remark;//备用字段

	public String getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getAuthorityUrl() {
		return authorityUrl;
	}

	public void setAuthorityUrl(String authorityUrl) {
		this.authorityUrl = authorityUrl;
	}

	public String getAuthorityImage() {
		return authorityImage;
	}

	public void setAuthorityImage(String authorityImage) {
		this.authorityImage = authorityImage;
	}

	public String getSuperiorId() {
		return superiorId;
	}

	public void setSuperiorId(String superiorId) {
		this.superiorId = superiorId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "AuthorityInfo [authorityId=" + authorityId + ", authorityName="
				+ authorityName + ", authorityUrl=" + authorityUrl
				+ ", authorityImage=" + authorityImage + ", superiorId="
				+ superiorId + ", remark=" + remark + "]";
	}

}
