package com.chengtech.system.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chengtech.base.model.PageData;
import com.chengtech.system.entity.Resource;
import com.chengtech.system.entity.Role;
import com.chengtech.system.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;

	@GetMapping("/list")
	public String list(Integer pageIndex,Integer pageSize,Model model){
		pageIndex = pageIndex == null ? 1 : pageIndex < 1 ? 1 : pageIndex;
		pageSize = 10;
		PageData<Role> pageData = this.roleService.getPageData(pageIndex, pageSize, null);
		model.addAttribute("dataList", pageData.getPageData());
		model.addAttribute("total", pageData.getTotalCount());
		model.addAttribute("pages", pageData.getTotalPage());
		model.addAttribute("pagesize", pageData.getPageSize());
		model.addAttribute("pageIndex", pageIndex);
		return "system/role/list";
	}

}
