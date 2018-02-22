package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.SpaceFileInfo;

public interface ISpaceFileInfoService {

	/**
	 * 根据场地查询文件
	 * 
	 * @param spaceId
	 * @return
	 */
	public List<SpaceFileInfo> querySpace(@Param("spaceId") String spaceId);

	/**
	 * 添加文件
	 * 
	 * @param spaceFileInfo
	 * @return
	 */
	public int addFile(SpaceFileInfo spaceFileInfo);
}
