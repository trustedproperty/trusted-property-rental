package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.SpacePhotoInfo;

public interface ISpacePhotoInfoService {

	/**
	 * 查询场地相册
	 * 
	 * @param spaceId
	 * @return
	 */
	public List<SpacePhotoInfo> photoSpaceId(@Param("spaceId") String spaceId);

	/**
	 * 添加图片
	 *
	 * @param spacePhotoInfo
	 * @return
	 */
	public int addPhoto(SpacePhotoInfo spacePhotoInfo);

	/**
	 * 查询场地封面
	 * 
	 * @param spaceId
	 * @return
	 */
	public String photo_space(@Param("spaceId") String spaceId);

	/**
	 * 删除图片
	 * 
	 * @param url
	 * @return
	 */
	public int remove(@Param("url") String url);
}
