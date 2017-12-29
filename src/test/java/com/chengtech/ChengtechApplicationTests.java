package com.chengtech;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.chengtech.system.entity.Role;
import com.chengtech.system.entity.User;
import com.chengtech.system.service.IRoleService;
import com.chengtech.system.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ChengtechApplicationTests {
	
	@Resource
	private IUserService userService;
	
	@Resource
	private IRoleService roleService;
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	@Rollback(false) 
	public void addAdminUser() {
	//	System.out.println(this.userService.findById(1l).getEmail());

		// 管理員角色
		Role role1 = new Role();
		role1.setName("管理员");
		role1.setDescription("这是管理员角色");

		Role role2 = new Role();
		role2.setName("普通用户");
		role2.setDescription("这是普通用户角色");

		this.roleService.save(role1);
		this.roleService.save(role2);

		User user = new User();
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder(4);
		user.setPassword(bc.encode("123456"));
		user.setUsername("dgz");
		user.setEmail("dgz888@163.com");
		user.setNickName("dgz");
		user.setSex("男");
		Set<Role>  roles = new HashSet<Role>();
		roles.add(role1);
		roles.add(role2);
		user.setRoles(roles);
		
		userService.save(user);
	}
	
	@Test
	@Rollback(false) 
	public void addGeneralUser() {
	//	System.out.println(this.userService.findById(1l).getEmail());

	

		Role role2 = new Role();
		role2.setId(2l);



		User user = new User();
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder(4);
		user.setPassword(bc.encode("123456"));
		user.setUsername("abc");
		user.setEmail("abc@163.com");
		user.setNickName("abc");
		user.setSex("男");
		Set<Role>  roles = new HashSet<Role>();
		roles.add(role2);
		user.setRoles(roles);
		
		userService.save(user);
	}

}
