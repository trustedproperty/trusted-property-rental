package com.controller;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.entity.FavoriteInfo;
import com.service.IFavoriteInfoService;
import com.util.BaseControl;

/**
 * 收藏信息操作Controller
 * 
 * @author John
 *
 */
@Controller
@RequestMapping("/favoriteInfo")
public class FavoriteInfoController extends BaseControl {

	@Resource
	private IFavoriteInfoService iFavoriteInfoService;
	// 初始化JSON
	JSONObject j = null;

	/**
	 * 收藏场地
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/addFavorite.html")
	@ResponseBody
	public void addFavorite(String userId,String spaceId) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");

		//是否收藏
		int flg = iFavoriteInfoService.checkSpace(userId, spaceId);
		if(flg>0){
			j.put("message", "failed");
		}else{
			//声明实体
			FavoriteInfo favoriteInfo = new FavoriteInfo();
			//设置参数
			favoriteInfo.setFavoriteId(String.valueOf(new Date().getTime()));
			favoriteInfo.setUserId(userId);
			favoriteInfo.setSpaceId(spaceId);
			
			//收藏
			int flag = iFavoriteInfoService.addFavorite(favoriteInfo);
			
			//是否成功
			if(flag>0){
				j.put("message", "success");
			}else{
				j.put("message", "failed");
			}
		}

		// 返回数据
		response.getWriter().print(j);
	}
	
	/**
	 * 取消收藏场地
	 * 
	 * @param userId
	 * @param spaceId
	 * @throws IOException
	 */
	@RequestMapping("/removeFavorite.html")
	@ResponseBody
	public void removeFavorite(String userId,String spaceId) throws IOException {

		// 初始化JSON
		j = new JSONObject();
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("apolication/json;charset=utf-8");
		
		//取消收藏
		int flag = iFavoriteInfoService.removeFavorite(userId, spaceId);
		
		//是否成功
		if(flag>0){
			j.put("message", "success");
		}else{
			j.put("message", "failed");
		}

		// 返回数据
		response.getWriter().print(j);
	}
}
