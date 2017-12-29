package com.chengtech.system.web;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chengtech.base.model.PageData;
import com.chengtech.base.model.TableSplitResult;
import com.chengtech.system.entity.User;
import com.chengtech.system.service.IUserService;


@Controller
public class UserController {
	
	@Resource
	private IUserService userService;
	
	@GetMapping("/user/userList")
	@ResponseBody
	public TableSplitResult<User> getUsers(Integer pageIndex,Integer pageSize){
		pageIndex = pageIndex == null ? 1 : pageIndex < 1 ? 1 : pageIndex;
		pageSize = 10;
		
		PageData<User> pageData = this.userService.getPageData(pageIndex, pageSize, null);
		TableSplitResult<User> pageJson = new TableSplitResult<User>();
		pageJson.setTotal(pageData.getTotalCount());
		pageJson.setRows(pageData.getPageData());
		pageJson.setPage(pageIndex);
		return pageJson;
	}
	
	@GetMapping("/user/userList1")
	@ResponseBody
	public TableSplitResult<User> userList1(Integer pageIndex,Integer pageSize){
		pageIndex = pageIndex == null ? 1 : pageIndex < 1 ? 1 : pageIndex;
		pageSize = 10;
		
		PageData<User> pageData = this.userService.getPageData(pageIndex, pageSize, null);
		TableSplitResult<User> pageJson = new TableSplitResult<User>();
		pageJson.setTotal(pageData.getTotalCount());
		pageJson.setRows(pageData.getPageData());
		pageJson.setPage(pageIndex);
		return pageJson;
	}

}
