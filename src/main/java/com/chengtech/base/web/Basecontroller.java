package com.chengtech.base.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.chengtech.system.entity.User;

public class Basecontroller {
	
	public  User currentUser;
	
	@Resource
	private HttpSession session;
	
	public Basecontroller(){
		this.currentUser = (User) session.getAttribute("currentUser");
	}

}
