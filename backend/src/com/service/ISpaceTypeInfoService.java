package com.service;

import java.util.List;

import com.entity.SpaceTypeInfo;

/**
 * 场地类型信息Service层
 * 
 * @author John
 *
 */
public interface ISpaceTypeInfoService {

	/**
	 * 查询场地类型列表
	 * 
	 * @return
	 */
	public List<SpaceTypeInfo> queryType();

	/**
	 * 添加场地类型
	 * 
	 * @param spaceTypeInfo
	 * @return
	 */
	public int addSpaceType(SpaceTypeInfo spaceTypeInfo);
}
