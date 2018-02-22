package com.service;

import java.util.List;

import com.entity.CityInfo;

/**
 * 城市信息Service层
 * 
 * @author John
 *
 */
public interface ICityInfoService {

	/**
	 * 添加城市
	 * 
	 * @param city
	 */
	public int addCity(CityInfo city);

	/**
	 * 查询城市列表
	 * 
	 * @return
	 */
	public List<CityInfo> queryCity();
}
