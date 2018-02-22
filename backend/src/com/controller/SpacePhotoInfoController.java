package com.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.entity.DemandInfo;
import com.entity.DistrictInfo;
import com.entity.SpaceFacilityInfo;
import com.entity.SpaceInfo;
import com.entity.SpacePhotoInfo;
import com.entity.UserInfo;
import com.service.ICityInfoService;
import com.service.IDemandInfoService;
import com.service.IDistrictInfoService;
import com.service.IFacilityInfoService;
import com.service.IFavoriteInfoService;
import com.service.ISpaceFacilityInfoService;
import com.service.ISpaceInfoService;
import com.service.ISpacePhotoInfoService;
import com.service.IUserInfoService;
import com.util.BaseControl;

/**
 * 场地详情Controller
 * 
 * @author John
 *
 */
@Controller
@RequestMapping("/space")
public class SpacePhotoInfoController extends BaseControl {

	@Resource
	private IFavoriteInfoService iFavoriteInfoService;
	@Resource
	private ISpacePhotoInfoService iSpacePhotoInfoService;
	@Resource
	private ISpaceInfoService iSpaceInfoService;
	@Resource
	private IUserInfoService iUserInfoService;
	@Resource
	private ISpaceFacilityInfoService iSpaceFacilityInfoService;
	@Resource
	private ICityInfoService iCityInfoService;
	@Resource
	private IFacilityInfoService iFacilityInfoService;
	@Resource
	private IDemandInfoService iDemandInfoService;
	@Resource
	private IDistrictInfoService iDistrictInfoService;
	// 初始化JSON
	JSONObject j = null;
	// 格式化时间
	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH");

	/**
	 * 热门场地
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/hotSpace.html")
	@ResponseBody
	public void hotSpace() throws IOException {

		// 初始化JSON
		j = new JSONObject();

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 热门场地
		List<SpaceInfo> hotSpaceInfo = iSpaceInfoService.hotSpace();
		List<SpaceInfo> spaceInfo = new ArrayList<SpaceInfo>();
		for (SpaceInfo space : hotSpaceInfo) {
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
			spaceInfo.add(info);
		}

		// 添加数据
		j.put("hotSpaceInfo", spaceInfo);

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 查询场地是否收藏
	 * 
	 * @param userId
	 * @param spaceId
	 * @throws IOException
	 */
	@RequestMapping("/hasFavorite.html")
	@ResponseBody
	public void hasFavorite(String userId, String spaceId) throws IOException {

		// 初始化JSON
		j = new JSONObject();

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");
		// 返回参数
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();

		// 非空验证
		if (userId == "" || spaceId == "") {
			// 添加查询状态
			map.put("error", "必填参数不能为空");
		} else {
			// 查询
			int count = iFavoriteInfoService.checkSpace(userId, spaceId);
			// 是否收藏
			if (count > 0) {
				// 添加查询状态
				map.put("message", "success");
				map.put("status", "0002");
			} else {
				// 添加查询状态
				map.put("message", "success");
				map.put("status", "0001");
			}
		}
		// 录入数据
		list.add(map);
		j.put("favorite", list);
		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 场主场地
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/hostSpace.html")
	@ResponseBody
	public void hostSpace(String hostId) throws IOException {

		// 初始化JSON
		j = new JSONObject();

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		List<SpaceInfo> hostSpace = iSpaceInfoService.userSpace(hostId);
		List<SpaceInfo> spaceInfo = new ArrayList<SpaceInfo>();
		for (SpaceInfo space : hostSpace) {
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
			spaceInfo.add(info);
		}

		// 添加数据
		j.put("hostSpace", spaceInfo);

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 场地详情
	 * 
	 * @param userId
	 * @param spaceId
	 * @param spaceTypeId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/space_details.html")
	@ResponseBody
	public void space_details(String spaceId) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 查询城区信息
		List<DistrictInfo> districtInfo = iDistrictInfoService.queryDistrict();
		// 查询场主和相似条件
		SpaceInfo spaceInfo = iSpaceInfoService.queryTypeId(spaceId);
		// 场主更多场地
		List<SpaceInfo> moreSpace = iSpaceInfoService.userSpace(spaceInfo.getHostId());
		List<SpaceInfo> space_moreSpace = new ArrayList<SpaceInfo>();
		for (SpaceInfo space : moreSpace) {
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
		// 相似场地
		List<SpaceInfo> as_Space = iSpaceInfoService.as_Space(spaceInfo.getSpaceTypeId());
		List<SpaceInfo> space_asSpace = new ArrayList<SpaceInfo>();
		for (SpaceInfo space : as_Space) {
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
			space_asSpace.add(info);
		}
		// 场地相册
		List<SpacePhotoInfo> photoSpace = iSpacePhotoInfoService.photoSpaceId(spaceId);
		// 场地设施
		List<SpaceFacilityInfo> spaceFacilityInfo = iSpaceFacilityInfoService.facilitySpaceId(spaceId);
		// 收藏数
		int favoriteCount = iSpaceInfoService.favoriteCount(spaceId);
		// 需求数
		int demandCount = iSpaceInfoService.demandCount(spaceId);
		// 用户信息
		UserInfo hostInfo = iUserInfoService.queryById(spaceInfo.getHostId());
		hostInfo.setDemandCount(demandCount);
		hostInfo.setFavoriteCount(favoriteCount);

		// 预定政策集合
		List<HashMap<String, String>> policyList = new ArrayList<HashMap<String, String>>();
		// 价格列表集合
		List<HashMap<String, String>> priceList = new ArrayList<HashMap<String, String>>();
		// 查询数据
		SpaceInfo spaceDetail = iSpaceInfoService.queryDetail(spaceId);
		// 取出预定政策
		String policy[] = spaceDetail.getSpacePolicy().split(",");
		// 加入集合
		for (int i = 0; i < policy.length; i++) {
			HashMap<String, String> policyMap = new HashMap<String, String>();
			policyMap.put("policy", policy[i]);
			policyList.add(policyMap);
		}
		// 取出价格周期列表
		String price[] = spaceDetail.getPriceList().split(",");
		// 加入集合
		for (int i = 0; i < price.length; i++) {
			HashMap<String, String> priceMap = new HashMap<String, String>();
			priceMap.put("priceListItem", price[i]);
			priceList.add(priceMap);
		}

		// 录入数据
		j.put("moreSpace", space_moreSpace);
		j.put("as_Space", space_asSpace);
		j.put("photoSpace", photoSpace);
		j.put("spaceFacilityInfo", spaceFacilityInfo);
		j.put("hostInfo", hostInfo);
		j.put("spaceDetail", spaceDetail);
		j.put("policyList", policyList);
		j.put("priceList", priceList);
		j.put("districtInfo", districtInfo);

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 发布需求
	 * 
	 * @param demandInfo
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/insertDemand.html")
	@ResponseBody
	public void addDemand(DemandInfo demandInfo) throws IOException, ParseException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 得到当前验证码
		String inputCheck = demandInfo.getInputCheck();
		// 获取验证码
		String check = (String) session.getAttribute("check");
		// 获取开始时间
		long saveTime = (Long) session.getAttribute("beginTime");
		// 获取当前时间
		long nowTime = new Date().getTime();
		// 得到有效期
		long mins = nowTime - saveTime;
		// 比较数
		long num = 60000;

		// 验证码是否相同
		if (check.equals(inputCheck)) {
			// 判断是否过验证码有效期
			if (num > mins) {
				if (demandInfo.getContactsPhone() == "") {
					j.put("data", "fail");
				} else {
					// 设置需求Id
					String demandId = String.valueOf(new Date().getTime());
					demandInfo.setDemandId(demandId);
					// 设置时间格式
					Date beginTime = dateFormater.parse(demandInfo.getBeginTime());
					demandInfo.setBeginTime(dateFormater.format(beginTime));
					// 执行添加操作
					int flag = iDemandInfoService.addDemand(demandInfo);
					System.out.println(flag);
					// 判断是否添加成功
					if (flag > 0) {
						j.put("data", "success");
					} else {
						j.put("data", "fail");
					}
				}
			} else {
				j.put("error", "验证码已过期");
			}
		} else {
			j.put("error", "验证码不正确");
		}

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 查询需求信息
	 * 
	 * @param userId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/queryDemand.html")
	@ResponseBody
	public void queryDemand(String userId) throws IOException {

		// 初始化JSON
		j = new JSONObject();

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		List<DemandInfo> demandInfos = iDemandInfoService.queryDemand(userId);

		// 录入数据
		j.put("demandInfos", demandInfos);

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 发布场地
	 * 
	 * @param spaceInfo
	 * @throws IOException
	 */
	@RequestMapping("/addSpaceFacility.html")
	@ResponseBody
	public void addSpaceFacility(SpaceInfo spaceInfo) throws IOException {

		// 初始化JSON
		j = new JSONObject();

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 判断必填项是否为空
		if (spaceInfo.getCityId() == "" || spaceInfo.getSpaceTypeId() == "" || spaceInfo.getHostId() == ""
				|| spaceInfo.getDistrictId() == "") {
			j.put("data", "false");
		} else {
			// 场地设施Id
			String spaceFacilityId = "";
			String[] str = spaceInfo.getFacilityId().split(",");
			// 场地设施添加条件
			List<SpaceFacilityInfo> facilityList = new ArrayList<SpaceFacilityInfo>();

			// 设置场地Id
			String spaceId = String.valueOf(new Date().getTime());
			spaceInfo.setSpaceId(spaceId);
			// 设置设施
			if (str.length > 1) {
				// 循环设置添加条件
				for (int i = 0; i < str.length; i++) {
					SpaceFacilityInfo spaceFacilityInfo = new SpaceFacilityInfo();
					// 设置主键
					spaceFacilityId = String.valueOf(new Date().getTime() + i);
					spaceFacilityInfo.setSpaceFacilityId(spaceFacilityId);
					// 场地ID
					spaceFacilityInfo.setSpaceId(spaceId);
					// 设施ID
					spaceFacilityInfo.setFacilityId(str[i]);
					// 添加到集合
					facilityList.add(spaceFacilityInfo);
				}
			} else {
				SpaceFacilityInfo spaceFacilityInfo = new SpaceFacilityInfo();
				// 设置主键
				spaceFacilityId = String.valueOf(new Date().getTime());
				spaceFacilityInfo.setSpaceFacilityId(spaceFacilityId);
				// 场地ID
				spaceFacilityInfo.setSpaceId(spaceId);
				// 设施ID
				spaceFacilityInfo.setFacilityId(spaceInfo.getFacilityId());
				// 添加到集合
				facilityList.add(spaceFacilityInfo);
			}

			// 添加场地
			int spaceFlag = iSpaceInfoService.addSpace(spaceInfo);
			// 添加场地设施
			int facilityFlag = iSpaceFacilityInfoService.addSpaceFacility(facilityList);
			// 判断是否成功
			if (spaceFlag > 0 && facilityFlag > 0) {
				j.put("data", spaceId);
			} else {
				j.put("data", "false");
			}
		}

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 管理首页数据
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/managerPage.html")
	@ResponseBody
	public void managerPage() throws IOException {

		// 初始化JSON
		j = new JSONObject();

		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 查询新需求数
		int newDemand = iDemandInfoService.newDemand();
		// 查询新场地数
		int newSpace = iSpaceInfoService.newSpace();

		// 录入数据
		j.put("demandCount", newDemand);
		j.put("spaceCount", newSpace);

		// 返回数据
		response.getWriter().print(j);
	}

	/**
	 * 上传图片相册
	 * 
	 * @param file
	 * @param photoName
	 * @param spaceId
	 * @throws IOException
	 */
	@RequestMapping("/uploadPhoto.html")
	@ResponseBody
	public void upload(@RequestParam(value = "file", required = false) MultipartFile file, String photoName,
			String spaceId) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 获取根目录
		File f = new File(session.getServletContext().getRealPath("/"));
		// 得到文件上传目录
		String path = f.getParent() + "/upload/changdipai/images/album";

		// 获取上传文件名
		String fileName = file.getOriginalFilename();
		// 声明实体
		SpacePhotoInfo spacePhotoInfo = new SpacePhotoInfo();
		// 文件Id
		String photoId = String.valueOf(new Date().getTime());

		// 原名称里倒数第一个”.”在哪里
		int i = fileName.lastIndexOf(".");
		// 取得后缀，及”.”后面的字符
		String ext = fileName.substring(i + 1);

		// 判断是否修改名字
		if (photoName != null) {
			// 拼凑而成
			fileName = photoName + new Date().getTime() + "." + ext;
		} else {
			photoName = fileName;
			fileName = fileName + new Date().getTime() + "." + ext;
		}

		// 添加到根目录
		File targetFile = new File(path, fileName);

		// 判断是否存在
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 设置参数
		spacePhotoInfo.setPhotoId(photoId);
		spacePhotoInfo.setPhotoName(photoName);
		spacePhotoInfo.setUrl(fileName);
		spacePhotoInfo.setSpaceId(spaceId);

		// 保存
		try {
			// 写入文件
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 执行添加
		int flag = iSpacePhotoInfoService.addPhoto(spacePhotoInfo);

		// 判断是否添加成功
		if (flag > 0) {
			j.put("message", "success");
		} else {
			j.put("message", "failed");
		}

		// 返回数据
		response.getWriter().println(j);
	}

	/**
	 * 上传单个图片
	 * 
	 * @param file
	 * @throws IOException
	 */
	@RequestMapping("/sendPhoto.html")
	@ResponseBody
	public void upload(@RequestParam(value = "file", required = false) MultipartFile file, String newFile)
			throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		// 获取根目录
		File f = new File(session.getServletContext().getRealPath("/"));
		// 得到文件上传目录
		String path = f.getParent() + "/upload/changdipai/images/album";

		// 获取上传文件名
		String fileName = file.getOriginalFilename();

		// 原名称里倒数第一个”.”在哪里
		int i = fileName.lastIndexOf(".");
		// 取得后缀，及”.”后面的字符
		String ext = fileName.substring(i + 1);

		// 判断是否修改名字
		if (newFile != null) {
			// 拼凑而成
			fileName = newFile + new Date().getTime() + "." + ext;
		} else {
			fileName = fileName + new Date().getTime() + "." + ext;
		}

		// 添加到根目录
		File targetFile = new File(path, fileName);

		// 判断是否存在
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			// 写入文件
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 录入数据
		j.put("fileName", fileName);
		// 返回数据
		response.getWriter().println(j);
	}

	/**
	 * 删除图片
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	@RequestMapping("/removePhoto.html")
	@ResponseBody
	public void removePhoto(String photo) throws IOException {
		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");
		// 得到文件存储路径
		File file = new File("/upload/changdipai/images/album/" + photo);
		// 判断 如果文件存在，则执行删除方法
		if (file.exists()) {
			file.delete();
		}
		// 删除数据库
		int flag = iSpacePhotoInfoService.remove(photo);
		// 成功
		if (flag > 0) {
			j.put("message", "success");
		} else {
			j.put("message", "failed");
		}
		response.getWriter().print(j);
	}
}
