package com.chengtech.system.service.impl;

import org.springframework.stereotype.Service;

import com.chengtech.base.dao.impl.BaseDAOImpl;
import com.chengtech.system.entity.Role;
import com.chengtech.system.service.IRoleService;

@Service("roleService")
public class RoleService extends BaseDAOImpl<Role, Long> implements IRoleService{

}
