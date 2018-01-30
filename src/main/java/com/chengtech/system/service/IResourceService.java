package com.chengtech.system.service;

import java.util.Set;

import com.chengtech.base.service.BaseService;
import com.chengtech.system.entity.Resource;
import com.chengtech.system.entity.Role;
import com.chengtech.system.entity.User;



/**
 * URL资源管理
 * <p>Title : IResourceService</p>
 * <p>Description : </p>
 * <p>Company : </p>
 * @author 丁国柱
 * @date 2017年11月26日 上午1:52:38
 */
public interface IResourceService extends BaseService<Resource, Long>{
	
	/**
	 * 根据角色获取Resource集
	 * <p>方法名:getResourcesByRoleId </p>
	 * <p>Description : </p>
	 * <p>Company : </p>
	 * @author 丁国柱
	 * @date 2017年11月26日 上午1:54:28
	 * @param roleId
	 * @return
	 */
	public Set<Resource> getResourcesByRoleId(Role role);
	
	/**
	 * 根据用户获取该用户可以获取的资源列表
	 * <p>方法名:getResourcesByUserId </p>
	 * <p>Description : </p>
	 * <p>Company : </p>
	 * @author 丁国柱
	 * @date 2017年11月26日 上午1:55:09
	 * @param userId
	 * @return
	 */
	public Set<Resource> getResourcesByUserId(User user);
	
	/**
	 * 根据用户获取权限菜单
	 * <p>方法名:getMenuByUser </p>
	 * <p>Description : </p>
	 * <p>Company : </p>
	 * @author 丁国柱
	 * @date 2018年1月30日 下午10:19:48
	 * @param user
	 * @return
	 */
	public Set<Resource> getMenuByUser(User user);
	
	/**
	 * 根据角色返回资源信息
	 * <p>方法名:getResourceTree </p>
	 * <p>Description : </p>
	 * <p>Company : </p>
	 * @author 丁国柱
	 * @date 2018年1月30日 下午11:56:20
	 * @param roleId
	 * @return
	 */
	public String getResourceTree(Integer roleId);
}
