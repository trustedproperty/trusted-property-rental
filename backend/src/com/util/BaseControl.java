package com.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author John
 * 
 *BaseController
 *
 * @author Administrator
 *
 */
public class BaseControl {

	protected HttpServletRequest request;
	protected HttpSession session;
	protected HttpServletResponse response;
	protected Model model;
	public ServletContext application;
	
	
	@ModelAttribute
	public void setServletRequest(HttpServletRequest request,HttpServletResponse response){
		
		this.request=request;
		this.response=response;
		this.session=request.getSession();
	}
	@ModelAttribute
	public void setModel(Model model)
	{
		this.model=model;
	}
	
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		application=arg0;
	}

}
