package com.chengtech.system.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.chengtech.base.dao.impl.BaseDAOImpl;
import com.chengtech.system.entity.Resource;
import com.chengtech.system.entity.Role;
import com.chengtech.system.entity.User;
import com.chengtech.system.service.IResourceService;

/**
 * 资源服务
 * <p>Title : ResourceService</p>
 * <p>Description : </p>
 * <p>Company : </p>
 * @author 丁国柱
 * @date 2017年11月26日 上午1:55:55
 */
@Service("resourceService")
public class ResourceService  extends BaseDAOImpl<Resource, Long> implements IResourceService{

	@Override
	public Set<Resource> getResourcesByRoleId(Role role) {
		return role.getResources();
	}

	@Override
	public Set<Resource> getResourcesByUserId(User user) {
		Set<Resource> resources = new HashSet<Resource>();
		Set<Role> roles = user.getRoles();
		for (Iterator iterator = roles.iterator(); iterator.hasNext();) {
			Role role = (Role) iterator.next();
			resources.addAll(role.getResources());
		}
		return resources;
	}

}
