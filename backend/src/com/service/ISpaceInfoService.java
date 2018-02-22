package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.FacilityInfo;
import com.entity.SpaceInfo;

/**
 * 场地信息Service层
 * 
 * @author John
 *
 */
public interface ISpaceInfoService {

	/**
	 * 查询热门场地
	 * 
	 * @return
	 */
	public List<SpaceInfo> hotSpace();

	/**
	 * 场地详情
	 * 
	 * @param spaceId
	 * @return
	 */
	public SpaceInfo queryDetail(@Param("spaceId") String spaceId);

	/**
	 * 用户场地
	 * 
	 * @param userId
	 * @return
	 */
	public List<SpaceInfo> userSpace(@Param("hostId") String hostId);

	/**
	 * 
	 * 相似场地
	 * 
	 * @param spaceTypeId
	 * @return
	 */
	public List<SpaceInfo> as_Space(@Param("spaceTypeId") String spaceTypeId);

	/**
	 * 需求数
	 * 
	 * @param demandSpace
	 * @return
	 */
	public int demandCount(@Param("spaceId") String spaceId);

	/**
	 * 收藏数
	 * 
	 * @param spaceId
	 * @return
	 */
	public int favoriteCount(@Param("spaceId") String spaceId);

	/**
	 * 搜索场地
	 * 
	 * @param cityId
	 * @param spaceTypeId
	 * @param spaceNum
	 * @param spacePrice
	 * @param facilityId
	 * @param price
	 * @param pageNo
	 * @return
	 */
	public List<SpaceInfo> searchSpace(@Param("spaceInfos") List<SpaceInfo> spaceInfos,
			@Param("facilityInfos") List<FacilityInfo> facilityInfos, @Param("price") String price);

	/**
	 * 添加场地
	 * 
	 * @param spaceInfo
	 * @return
	 */
	public int addSpace(SpaceInfo spaceInfo);

	/**
	 * 查询新场地数量
	 * 
	 * @return
	 */
	public int newSpace();

	/**
	 * 查询未审核场地
	 * 
	 * @return
	 */
	public List<SpaceInfo> shenHeSpace();

	/**
	 * 查询全部场地
	 * 
	 * @return
	 */
	public List<SpaceInfo> allSpace();

	/**
	 * 根据Id查询
	 * 
	 * @param spaceId
	 * @return
	 */
	public SpaceInfo queryById(@Param("spaceId") String spaceId);

	/**
	 * 修改场地信息
	 * 
	 * @param spaceInfo
	 * @return
	 */
	public int updateSpace(SpaceInfo spaceInfo);

	/**
	 * 批量修改场地状态
	 * 
	 * @param list
	 * @return
	 */
	public int updateStatus(List<SpaceInfo> list);

	/**
	 * 审核场地
	 * 
	 * @param spaceId
	 * @return
	 */
	public int shenHeStatus(@Param("spaceId") String spaceId);

	/**
	 * 驳回场地
	 * 
	 * @param spaceId
	 * @return
	 */
	public int boHuiStatus(@Param("spaceId") String spaceId);

	/**
	 * 用户收藏场地列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<SpaceInfo> userFavoriteSpace(@Param("userId") String userId);

	/**
	 * 修改场地热度
	 * 
	 * @param spaceId
	 * @param hot
	 * @return
	 */
	public int updateHot(List<SpaceInfo> list);
	
	/**
	 * 根据场地查询类型
	 * 
	 * @param spaceId
	 * @return
	 */
	public SpaceInfo queryTypeId(@Param("spaceId") String spaceId);
}
