package com.seangogo.blogs.service.impl;

import com.seangogo.blogs.domain.Resource;
import com.seangogo.blogs.domain.Role;
import com.seangogo.blogs.repository.RoleRepository;
import com.seangogo.blogs.repository.support.BaseRepository;
import com.seangogo.blogs.service.IResourceService;
import com.seangogo.blogs.service.IRoleService;
import com.seangogo.blogs.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 角色表  服务实现类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, String> implements IRoleService {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private IResourceService resourceService;
	
	@Override
	public BaseRepository<Role, String> getBaseDao() {
		return this.roleRepository;
	}

	@Override
	public void saveOrUpdate(Role role) {
		if(role.id() != null){
			Role dbRole = find(role.id());
			update(dbRole);
		}else{
			save(role);
		}
	}

	
	
	@Override
	public void delete(String id) {
		Role role = find(id);
		Assert.state(!"administrator".equals(role.name()),"超级管理员角色不能删除");
		super.delete(id);
	}

	@Override
	public void grant(String id, String[] resourceIds) {
		Role role = find(id);
		Assert.notNull(role, "角色不存在");
		
		Assert.state(!"administrator".equals(role.name()),"超级管理员角色不能进行资源分配");
		Resource resource;
		Set<Resource> resources = new HashSet<Resource>();
		if(resourceIds != null){
			for (int i = 0; i < resourceIds.length; i++) {
				if(StringUtils.isEmpty(resourceIds[i]) || "0".equals(resourceIds[i])){
					continue;
				}
				Integer rid = Integer.parseInt(resourceIds[i]);
				resources.add(null);
			}
		}
		update(role);
	}
	
}
