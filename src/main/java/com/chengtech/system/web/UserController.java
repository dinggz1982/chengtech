package com.chengtech.system.web;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chengtech.base.model.PageData;
import com.chengtech.base.model.TableSplitResult;
import com.chengtech.system.entity.Resource;
import com.chengtech.system.entity.ResourceButton;
import com.chengtech.system.entity.User;
import com.chengtech.system.service.IResourceButtonService;
import com.chengtech.system.service.IResourceService;
import com.chengtech.system.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IResourceButtonService resourceButtonService;
	@Autowired
	private IResourceService resourceService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request;
	
	
	
	/**
	 * 用户列表
	 * <p>方法名:list </p>
	 * <p>Description : </p>
	 * <p>Company : </p>
	 * @author 丁国柱
	 * @date 2018年1月30日 下午11:15:01
	 * @param pageIndex
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public String list(Integer pageIndex,Integer pageSize,Model model){
		pageIndex = pageIndex == null ? 1 : pageIndex < 1 ? 1 : pageIndex;
		pageSize = 10;
		PageData<User> pageData = this.userService.getPageData(pageIndex, pageSize, null);
		model.addAttribute("dataList", pageData.getPageData());
		model.addAttribute("total", pageData.getTotalCount());
		model.addAttribute("pages", pageData.getTotalPage());
		model.addAttribute("pagesize", pageData.getPageSize());
		model.addAttribute("pageIndex", pageIndex);
		
		//取得用户的按钮权限
		User currentUser=  (User) session.getAttribute("currentUser");
		
		System.out.println(request.getRequestURI());
		String url = request.getRequestURI();
		Resource resource = resourceService.getResourceByURL(url);
		Set<ResourceButton>  buttons = this.resourceButtonService.getResourceButtonByUserId(resource, currentUser);
		model.addAttribute("buttons", buttons);
		
		return "system/user/list";
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
