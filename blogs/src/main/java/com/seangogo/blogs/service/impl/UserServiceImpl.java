package com.seangogo.blogs.service.impl;

import com.seangogo.blogs.domain.Role;
import com.seangogo.blogs.domain.User;
import com.seangogo.blogs.repository.UserRepository;
import com.seangogo.blogs.repository.support.BaseRepository;
import com.seangogo.blogs.service.RoleService;
import com.seangogo.blogs.service.UserService;
import com.seangogo.blogs.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 用户账户表  服务实现类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public BaseRepository<User, String> getBaseDao() {
		return this.userRepository;
	}

	@Override
	public User findByUserName(String username) {
		return userRepository.findByName(username);
	}

	@Override
	public void saveOrUpdate(User user) {
		if(user.id() != null){
			User dbUser = find(user.id());
			dbUser.name(user.name());
			update(dbUser);
		}else{
			user.password("111111");//todo MD5Utils.md5("111111")
			save(user);
		}
	}
	
	

	@Override
	public void delete(String id) {
		User user = find(id);
		Assert.state(!"admin".equals(user.name()),"超级管理员用户不能删除");
		super.delete(id);
	}

	@Override
	public void grant(String id, String[] roleIds) {
		User user = find(id);
		Assert.notNull(user, "用户不存在");
		Assert.state(!"admin".equals(user.name()),"超级管理员用户不能修改管理角色");
		Role role;
		Set<Role> roles = new HashSet();
		if(roleIds != null){
			for (int i = 0; i < roleIds.length; i++) {
				role = roleService.find(roleIds[i]);
				roles.add(role);
			}
		}
		update(user);
	}
	
}
