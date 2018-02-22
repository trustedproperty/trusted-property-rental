package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.SpaceFacilityInfo;

public interface ISpaceFacilityInfoService {

	/**
	 * 根据场地查询设施
	 * 
	 * @param spaceId
	 * @return
	 */
	public List<SpaceFacilityInfo> facilitySpaceId(@Param("spaceId") String spaceId);

	/**
	 * 根据场地查询设施---修改场地
	 * 
	 * @param spaceId
	 * @return
	 */
	public List<SpaceFacilityInfo> queryFacilityId(@Param("spaceId") String spaceId);

	/**
	 * 删除设施
	 * 
	 * @param spaceFacilityId
	 * @return
	 */
	public int removeFacilityId(@Param("spaceId") String spaceId);

	/**
	 * 批量添加场地设施
	 * 
	 * @param list
	 * @return
	 */
	public int addSpaceFacility(@Param("list") List<SpaceFacilityInfo> list);
}
