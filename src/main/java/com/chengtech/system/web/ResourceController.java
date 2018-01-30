package com.chengtech.system.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chengtech.system.service.IResourceService;

@Controller
@RequestMapping("/resource")
public class ResourceController {
	
	@Autowired
	private IResourceService resourceService;

	@GetMapping("/list")
	public String list(){
		return "system/resource/list";
	}
	
	@GetMapping("/tree")
	@ResponseBody
	public String tree(){
		return this.resourceService.getResourceTree(null);
	}
	

}
