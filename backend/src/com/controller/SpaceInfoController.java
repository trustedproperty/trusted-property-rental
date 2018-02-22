package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.entity.SpaceFacilityInfo;
import com.entity.SpaceFileInfo;
import com.entity.SpaceInfo;
import com.service.IAuthorityInfoService;
import com.service.ISpaceFacilityInfoService;
import com.service.ISpaceFileInfoService;
import com.service.ISpaceInfoService;
import com.service.ISpacePhotoInfoService;
import com.util.BaseControl;

/**
 * 场地信息操作Controller
 * 
 * @author John
 *
 */
@Controller
@RequestMapping("/spaceInfo")
public class SpaceInfoController extends BaseControl {

	@Resource
	private ISpaceInfoService iSpaceInfoService;
	@Resource
	private ISpaceFileInfoService iSpaceFileInfoService;
	@Resource
	private ISpaceFacilityInfoService iSpaceFacilityInfoService;
	@Resource
	private IAuthorityInfoService iAuthorityInfoService;
	@Resource
	private ISpacePhotoInfoService iSpacePhotoInfoService;
	// 初始化JSON
	JSONObject j = null;

	/**
	 * 场地管理列表
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/spaceInfo.html")
	@ResponseBody
	public void querySpace() throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 查询未审核场地
		List<SpaceInfo> shenHeSpace = iSpaceInfoService.shenHeSpace();
		// 查询全部场地
		List<SpaceInfo> allSpace = iSpaceInfoService.allSpace();

		// 录入数据
		j.put("shenHeSpace", shenHeSpace);
		j.put("allSpace", allSpace);

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 审核场地
	 * 
	 * @param spaceId
	 * @throws IOException
	 */
	@RequestMapping("/shenHeSpace.html")
	@ResponseBody
	public void shenHeSpace(String spaceId, String visitId) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 判断权限
		if (iAuthorityInfoService.checkAuthority(visitId, "editSpace") > 0) {
			// 执行修改
			int flag = iSpaceInfoService.shenHeStatus(spaceId);

			// 判断是否成功
			if (flag > 0) {
				j.put("message", "success");
			} else {
				j.put("message", "failed");
			}

		} else {
			j.put("message", "failed");
		}

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 驳回场地
	 * 
	 * @param spaceId
	 * @throws IOException
	 */
	@RequestMapping("/boHuiSpace.html")
	@ResponseBody
	public void boHuiSpace(String spaceId, String visitId) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 判断权限
		if (iAuthorityInfoService.checkAuthority(visitId, "editSpace") > 0) {

			// 执行修改
			int flag = iSpaceInfoService.boHuiStatus(spaceId);

			// 判断是否成功
			if (flag > 0) {
				j.put("message", "success");
			} else {
				j.put("message", "failed");
			}

		} else {
			j.put("message", "failed");
		}

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 批量修改场地状态
	 * 
	 * @param spaceId
	 * @param spaceStatus
	 * @throws IOException
	 */
	@RequestMapping("/updateStatus.html")
	@ResponseBody
	public void updateStatus(String spaceId, int spaceStatus, String visitId) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 判断权限
		if (iAuthorityInfoService.checkAuthority(visitId, "editSpace") > 0) {

			// 分割参数
			String str[] = spaceId.split(",");
			// 设置参数列表
			List<SpaceInfo> list = new ArrayList<SpaceInfo>();

			// 设置参数
			for (int i = 0; i < str.length; i++) {
				// 初始化实体
				SpaceInfo spaceInfo = new SpaceInfo();
				spaceInfo.setSpaceId(str[i]);
				spaceInfo.setSpaceStatus(spaceStatus);
				list.add(spaceInfo);
			}

			// 执行修改
			int flag = iSpaceInfoService.updateStatus(list);

			// 是否修改成功
			if (flag > 0) {
				j.put("message", "success");
			} else {
				j.put("message", "failed");
			}

		} else {
			j.put("message", "failed");
		}

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 根据Id查询场地信息
	 * 
	 * @param spaceId
	 * @throws IOException
	 */
	@RequestMapping("/queryById.html")
	@ResponseBody
	public void queryById(String spaceId) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 预定政策集合
		List<HashMap<String, String>> policyList = new ArrayList<HashMap<String, String>>();
		// 价格列表集合
		List<HashMap<String, String>> priceList = new ArrayList<HashMap<String, String>>();
		// 查询文件列表
		List<SpaceFileInfo> spaceFileInfos = iSpaceFileInfoService.querySpace(spaceId);

		// 查询数据
		SpaceInfo spaceInfo = iSpaceInfoService.queryById(spaceId);
		// 取出预定政策
		String policy[] = spaceInfo.getSpacePolicy().split(",");
		// 加入集合
		for (int i = 0; i < policy.length; i++) {
			HashMap<String, String> policyMap = new HashMap<String, String>();
			policyMap.put("policy", policy[i]);
			policyList.add(policyMap);
		}
		// 取出价格周期列表
		String price[] = spaceInfo.getPriceList().split(",");
		// 加入集合
		for (int i = 0; i < price.length; i++) {
			HashMap<String, String> priceMap = new HashMap<String, String>();
			priceMap.put("priceListItem", price[i]);
			priceList.add(priceMap);
		}

		// 录入数据
		j.put("spaceInfo", spaceInfo);
		j.put("spaceFileInfos", spaceFileInfos);
		j.put("policyList", policyList);
		j.put("priceList", priceList);

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 用户收藏场地列表
	 * 
	 * @param userId
	 * @throws IOException
	 */
	@RequestMapping("/favoriteSpace.html")
	@ResponseBody
	public void favoriteSpace(String userId) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 收藏列表
		List<SpaceInfo> spaceInfos = iSpaceInfoService.userFavoriteSpace(userId);
		List<SpaceInfo> space_moreSpace = new ArrayList<SpaceInfo>();
		for (SpaceInfo space : spaceInfos) {
			SpaceInfo info = new SpaceInfo();
			info.setSpaceId(space.getSpaceId());
			info.setSpaceName(space.getSpaceName());
			info.setSpaceAddress(space.getSpaceAddress());
			info.setSpaceDetailAddress(space.getSpaceDetailAddress());
			info.setSpaceNum(space.getSpaceNum());
			info.setHostId(space.getHostId());
			info.setSpaceTypeId(space.getSpaceTypeId());
			info.setHotSpace(space.getHotSpace());
			info.setSpacePhoto(iSpacePhotoInfoService.photo_space(space.getSpaceId()));
			space_moreSpace.add(info);
		}

		// 录入数据
		j.put("spaceInfos", space_moreSpace);

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 修改场地信息
	 * 
	 * @param spaceInfo
	 * @throws IOException
	 */
	@RequestMapping("/updateSpace.html")
	@ResponseBody
	public void updateSpace(SpaceInfo spaceInfo) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 设施Id
		String[] str = spaceInfo.getFacilityId().split(",");

		// 判断权限
		if (iAuthorityInfoService.checkAuthority(spaceInfo.getVisitId(), "editSpace") > 0) {

			// 修改设施参数
			List<SpaceFacilityInfo> list = new ArrayList<SpaceFacilityInfo>();
			// 删除设施
			int flag = iSpaceFacilityInfoService.removeFacilityId(spaceInfo.getSpaceId());

			// 设置添加参数
			for (int i = 0; i < str.length; i++) {
				SpaceFacilityInfo spaceFacilityInfos = new SpaceFacilityInfo();
				spaceFacilityInfos.setSpaceFacilityId(String.valueOf(new Date().getTime() + i));
				spaceFacilityInfos.setSpaceId(spaceInfo.getSpaceId());
				spaceFacilityInfos.setFacilityId(str[i]);
				list.add(spaceFacilityInfos);
			}
			// 修改场地
			int sflag = iSpaceInfoService.updateSpace(spaceInfo);
			// 添加设施
			int fag = iSpaceFacilityInfoService.addSpaceFacility(list);

			// 是否成功
			if (fag > 0 && sflag > 0 && flag > 0) {
				j.put("message", "success");
			} else {
				j.put("message", "failed");
			}

		} else {
			j.put("message", "failed");
		}

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 查询相似场地
	 * 
	 * @param spaceId
	 * @throws IOException
	 */
	@RequestMapping("/similarSpace.html")
	@ResponseBody
	public void similarSpace(String spaceId) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 查询类型
		SpaceInfo spaceInfo = iSpaceInfoService.queryTypeId(spaceId);
		// 判断是否为空
		if (spaceInfo.getSpaceTypeId() == "") {
			j.put("similarSpace", false);
		} else {

			// 相似场地
			List<SpaceInfo> similarSpace = iSpaceInfoService.as_Space(spaceInfo.getSpaceTypeId());

			// 录入数据
			j.put("similarSpace", similarSpace);
		}

		// 返回数据
		response.getWriter().print(j);
	}
}
