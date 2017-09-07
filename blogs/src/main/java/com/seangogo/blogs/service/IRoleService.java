package com.seangogo.blogs.service;

import com.seangogo.blogs.domain.Role;
import com.seangogo.blogs.service.support.IBaseService;

/**
 * <p>
 * 角色服务类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
public interface IRoleService extends IBaseService<Role,String> {

	/**
	 * 添加或者修改角色
	 * @param role
	 */
	void saveOrUpdate(Role role);

	/**
	 * 给角色分配资源
	 * @param id 角色ID
	 * @param resourceIds 资源ids
	 */
	void grant(String id, String[] resourceIds);
	
}
