package com.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import com.service.ISpaceInfoService;

/**
 * 定时批量刷新场地热度 
 * 
 * @author John
 *
 */
public class SpaceDataTimerTask extends TimerTask {

	@Resource
	private ISpaceInfoService iSpaceInfoService;

	@Override
	public void run() {
		try {

			// 初始化参数列表
			List<SpaceInfo> list = new ArrayList<SpaceInfo>();

			// 场地列表
			List<SpaceInfo> spaceInfos = iSpaceInfoService.allSpace();

			// 批量更改数据
			for (SpaceInfo space : spaceInfos) {
				// 初始化实体
				SpaceInfo spaceInfo = new SpaceInfo();
				// 查询热度
				int count = iSpaceInfoService.favoriteCount(space.getSpaceId());
				// 设置参数
				spaceInfo.setSpaceId(space.getSpaceId());
				spaceInfo.setHotSpace(count);
				list.add(spaceInfo);
			}

			// 刷新数据
			int fag = iSpaceInfoService.updateHot(list);

			// 是否成功
			if (fag > 0) {
				System.out.println("刷新成功");
			} else {
				System.out.println("刷新失败");
			}

		} catch (Exception e) {

		}
	}
}
