package com.chengtech.system.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chengtech.base.web.Basecontroller;
import com.chengtech.system.entity.Resource;
import com.chengtech.system.service.IResourceService;

@Controller
public class AdminController extends Basecontroller {
	
	@Autowired
	private IResourceService resourceService;
	
	@GetMapping("/admin")
	public String admin(Model model){
		Set<Resource> resources =  resourceService.getMenuByUser(currentUser);
		model.addAttribute("resources", resources);
		return "system/index";
	}
	
	@GetMapping("/admin/userList")
	public String userList(){
		
		return "system/user/userList";
	}

}
