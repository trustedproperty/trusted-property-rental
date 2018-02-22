package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.entity.FacilityInfo;
import com.entity.SpaceInfo;
import com.service.ICityInfoService;
import com.service.IFacilityInfoService;
import com.service.ISpaceInfoService;
import com.service.ISpacePhotoInfoService;
import com.service.ISpaceTypeInfoService;
import com.util.BaseControl;

/**
 * 搜索场地Controller
 * 
 * @author John
 *
 */
@Controller
@RequestMapping("/search")
public class SearchSpaceController extends BaseControl {

	@Resource
	private ISpaceInfoService iSpaceInfoService;
	@Resource
	private ICityInfoService iCityInfoService;
	@Resource
	private ISpaceTypeInfoService iSpaceTypeInfoService;
	@Resource
	private IFacilityInfoService iFacilityInfoService;
	@Resource
	private ISpacePhotoInfoService iSpacePhotoInfoService;
	// 初始化JSON
	JSONObject j = null;

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
	 * @throws IOException
	 */
	@RequestMapping("/searchSpace.html")
	@ResponseBody
	public void searchSpace(String cityId, String districtId, String spaceTypeId, String spaceNum, String spacePrice,
			String facilityId, String price) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 设置参数
		List<SpaceInfo> spaceInfos = new ArrayList<SpaceInfo>();
		List<FacilityInfo> facilityInfos = new ArrayList<FacilityInfo>();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 判断参数是否为空
		if (cityId == "") {
			cityId = "null";
		}
		if (districtId == "") {
			districtId = "null";
		}
		if (spaceTypeId == "") {
			spaceTypeId = "null";
		}
		if (spaceNum == "") {
			spaceNum = "null";
		}
		if (price == "") {
			price = "null";
		}
		if (spacePrice == "") {
			spacePrice = "0";
		}

		// 设置单个参数
		SpaceInfo info = new SpaceInfo();
		info.setCityId(cityId);
		info.setSpacePrice(spacePrice);
		info.setSpaceTypeId(spaceTypeId);
		info.setSpaceNum(spaceNum);
		info.setDistrictId(districtId);
		spaceInfos.add(info);

		// 设置多个参数
		if (facilityId == "") {
			facilityId = "null";
		} else {
			String[] str = facilityId.split(",");
			if (str.length > 1) {
				for (int i = 0; i < str.length; i++) {
					FacilityInfo facilityInfo = new FacilityInfo();
					facilityInfo.setFacilityId(str[i]);
					facilityInfos.add(facilityInfo);
				}
			} else {
				FacilityInfo facilityInfo = new FacilityInfo();
				facilityInfo.setFacilityId(facilityId);
				facilityInfos.add(facilityInfo);
			}
		}

		// 场地信息
		List<SpaceInfo> searchSpace = iSpaceInfoService.searchSpace(spaceInfos, facilityInfos, price);
		List<SpaceInfo> space_searchSpace = new ArrayList<SpaceInfo>();
		for (SpaceInfo space : searchSpace) {
			SpaceInfo spaces = new SpaceInfo();
			spaces.setSpaceId(space.getSpaceId());
			spaces.setSpaceName(space.getSpaceName());
			spaces.setSpaceAddress(space.getSpaceAddress());
			spaces.setSpaceDetailAddress(space.getSpaceDetailAddress());
			spaces.setSpaceNum(space.getSpaceNum());
			spaces.setHostId(space.getHostId());
			spaces.setSpaceTypeId(space.getSpaceTypeId());
			spaces.setHotSpace(space.getHotSpace());
			spaces.setSpacePhoto(iSpacePhotoInfoService.photo_space(space.getSpaceId()));
			space_searchSpace.add(spaces);
		}

		// 录入数据
		j.put("spaceList", space_searchSpace);

		// 返回数据
		response.getWriter().print(j);
	}
}
