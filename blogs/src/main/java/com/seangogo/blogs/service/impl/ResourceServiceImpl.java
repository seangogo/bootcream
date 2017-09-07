package com.seangogo.blogs.service.impl;

import com.seangogo.blogs.domain.Resource;
import com.seangogo.blogs.domain.Role;
import com.seangogo.blogs.pojo.ZtreeView;
import com.seangogo.blogs.repository.ResourceRepository;
import com.seangogo.blogs.repository.support.BaseRepository;
import com.seangogo.blogs.service.IResourceService;
import com.seangogo.blogs.service.IRoleService;
import com.seangogo.blogs.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource, String>
		implements IResourceService {

	@Autowired
	private ResourceRepository resourceRepository;

	@Autowired
	private IRoleService roleService;

	@Override
	public BaseRepository<Resource, String> getBaseDao() {
		return this.resourceRepository;
	}

	@Override
	@Cacheable(value = "resourceCache", key = "'tree' + #roleId")
	public List<ZtreeView> tree(String roleId) {
		List<ZtreeView> resulTreeNodes = new ArrayList<ZtreeView>();
		Role role = roleService.find(roleId);
		/*Set<Resource> roleResources = role.getResources();
		resulTreeNodes.add(new ZtreeView(0L, null, "系统菜单", true));
		ZtreeView node;
		Sort sort = new Sort(Direction.ASC, "parent", "id", "sort");
		List<Resource> all = resourceDao.findAll(sort);
		for (Resource resource : all) {
			node = new ZtreeView();
			node.setId(Long.valueOf(resource.getId()));
			if (resource.getParent() == null) {
				node.setpId(0L);
			} else {
				node.setpId(Long.valueOf(resource.getParent().getId()));
			}
			node.setName(resource.getName());
			if (roleResources != null && roleResources.contains(resource)) {
				node.setChecked(true);
			}
			resulTreeNodes.add(node);
		}*/
		return resulTreeNodes;
	}

	@Override
	@CacheEvict(value = "resourceCache")
	public void saveOrUpdate(Resource resource) {
		if(resource.id() != null){
			Resource dbResource = find(resource.id());
			dbResource.setName(resource.getName());
			dbResource.setSourceKey(resource.getSourceKey());
			dbResource.setType(resource.getType());
			dbResource.setSourceUrl(resource.getSourceUrl());
			dbResource.setLevel(resource.getLevel());
			dbResource.setSort(resource.getSort());
			dbResource.setIsHide(resource.getIsHide());
			dbResource.setIcon(resource.getIcon());
			dbResource.setDescription(resource.getDescription());
			dbResource.setParent(resource.getParent());
			update(dbResource);
		}else{
			save(resource);
		}
	}

}
