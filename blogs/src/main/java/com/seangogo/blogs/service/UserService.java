package com.seangogo.blogs.service;


import com.seangogo.blogs.domain.User;
import com.seangogo.blogs.service.support.BaseService;

/**
 * <p>
 * 用户服务类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
public interface UserService extends BaseService<User, String> {

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User findByUserName(String username);

	/**
	 * 增加或者修改用户
	 * @param user
	 */
	void saveOrUpdate(User user);

	/**
	 * 给用户分配角色
	 * @param id 用户ID
	 * @param roleIds 角色Ids
	 */
	void grant(String id, String[] roleIds);

}
