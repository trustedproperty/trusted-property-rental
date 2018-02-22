package com.service;

import org.apache.ibatis.annotations.Param;

import com.entity.FavoriteInfo;

/**
 * 收藏信息Service层
 * 
 * @author John
 *
 */
public interface IFavoriteInfoService {

	/**
	 * 添加收藏信息
	 * 
	 * @param favoritenfo
	 * @return
	 */
	public int addFavorite(FavoriteInfo favoriteInfo);

	/**
	 * 取消收藏
	 * 
	 * @param userId
	 * @param spaceId
	 * @return
	 */
	public int removeFavorite(@Param("userId") String userId, @Param("spaceId") String spaceId);
	
	/**
	 * 验证是否收藏
	 * 
	 * @param userId
	 * @param spaceId
	 * @return
	 */
	public int checkSpace(@Param("userId") String userId, @Param("spaceId") String spaceId);
}
