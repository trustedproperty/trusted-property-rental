package com.entity;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.util.TimerManager;

/**
 * 定时批量刷新场地热度
 * 
 * @author John
 *
 */
public class SpaceDataTaskListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		new TimerManager();
	}

	public void contextDestroyed(ServletContextEvent event) {
	}

}
