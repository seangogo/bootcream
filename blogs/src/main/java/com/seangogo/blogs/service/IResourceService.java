package com.seangogo.blogs.service;

import com.seangogo.blogs.domain.Resource;
import com.seangogo.blogs.pojo.ZtreeView;
import com.seangogo.blogs.service.support.IBaseService;

import java.util.List;

/**
 * <p>
 * 资源服务类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
public interface IResourceService extends IBaseService<Resource, String> {

	/**
	 * 获取角色的权限树
	 * @param roleId
	 * @return
	 */
	List<ZtreeView> tree(String roleId);

	/**
	 * 修改或者新增资源
	 * @param resource
	 */
	void saveOrUpdate(Resource resource);

}
