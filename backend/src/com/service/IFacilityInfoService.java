package com.service;

import java.util.List;

import com.entity.FacilityInfo;

/**
 * 设备设施信息Service层
 * 
 * @author John
 *
 */
public interface IFacilityInfoService {

	/**
	 * 查询设备信息
	 * 
	 * @return
	 */
	public List<FacilityInfo> queryFacility();

	/**
	 * 添加设施
	 * @param facilityInfo
	 * @return
	 */
	public int addFacility(FacilityInfo facilityInfo);
	
	/**
	 * 批量添加设施
	 * 
	 * @param list
	 * @return
	 */
	public int insertFacility(List<FacilityInfo> list);
}
