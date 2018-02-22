package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.DemandInfo;

/**
 * 需求信息Service层
 * 
 * @author John
 *
 */
public interface IDemandInfoService {

	/**
	 * 查询用户需求
	 * 
	 * @param userId
	 * @return
	 */
	public List<DemandInfo> queryDemand(@Param("userId") String userId);
	
	/**
	 * 发布需求
	 * 
	 * @param demandInfo
	 * @return
	 */
	public int addDemand(DemandInfo demandInfo);
	
	/**
	 * 查询新需求数量
	 * 
	 * @return
	 */
	public int newDemand();
	
	/**
	 * 查询未联系需求
	 * 
	 * @return
	 */
	public List<DemandInfo> queryNoDemand();
	
	/**
	 * 查询全部需求
	 * @return
	 */
	public List<DemandInfo> queryDemands();
	
	/**
	 * 查询需求详情
	 * 
	 * @param demandId
	 * @return
	 */
	public DemandInfo queryDetil(@Param("demandId")String demandId);
	
	/**
	 * 修改需求信息
	 * 
	 * @param demandInfo
	 * @return
	 */
	public int updateDemand(DemandInfo demandInfo);
	
	/**
	 *  批量修改需求状态
	 *  
	 * @param list
	 * @return
	 */
	public int updateStatus(List<DemandInfo> list);
}
