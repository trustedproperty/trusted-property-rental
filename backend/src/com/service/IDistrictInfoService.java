package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.DistrictInfo;

/**
 * 区域信息Service
 * 
 * @author John
 *
 */
public interface IDistrictInfoService {

	/**
	 * 查询城区信息
	 * 
	 * @return
	 */
	public List<DistrictInfo> queryDistrict();
	
	/**
	 * 批量添加城区
	 * 
	 * @param list
	 * @return
	 */
	public int insertDistinct(@Param("list")List<DistrictInfo> list);
}
