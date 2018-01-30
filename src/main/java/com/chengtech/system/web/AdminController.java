package com.chengtech.system.web;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chengtech.system.entity.Resource;
import com.chengtech.system.entity.User;
import com.chengtech.system.service.IResourceService;

@Controller
public class AdminController  {
	
	@Autowired
	private IResourceService resourceService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/admin")
	public String admin(Model model){
		User currentUser=  (User) session.getAttribute("currentUser");
		Set<Resource> resources =  resourceService.getMenuByUser(currentUser);
		model.addAttribute("resources", resources);
		return "system/index";
	}
	
	@GetMapping("/admin/userList")
	public String userList(){
		
		return "system/user/userList";
	}

}
