package com.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author John
 * 
 *         收藏信息表
 *
 */
public class FavoriteInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String favoriteId;// 收藏Id
	private String spaceId;// 场地ID
	private String userId;// 用户ID
	private Date time;// 收藏时间
	private String remark;// 备用字段

	public String getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(String favoriteId) {
		this.favoriteId = favoriteId;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Favoritenfo [favoriteId=" + favoriteId + ", spaceId=" + spaceId + ", userId=" + userId + ", time="
				+ time + ", remark=" + remark + "]";
	}

}
