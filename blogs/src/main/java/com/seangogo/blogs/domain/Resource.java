package com.seangogo.blogs.domain;


import com.seangogo.blogs.pojo.Base.BaseEntity;

import javax.persistence.*;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Entity
@Table(name = "tb_resource")
public class Resource extends BaseEntity<User> {

	/**
	 * 资源名称
	 */
	private String name;

	/**
	 * 资源唯一标识
	 */
	private String sourceKey;

	/**
	 * 资源类型,0:目录;1:菜单;2:按钮
	 */
	private Integer type;

	/**
	 * 资源url
	 */
	private String sourceUrl;

	/**
	 * 层级
	 */
	private Integer level;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 是否隐藏
	 * 
	 * 0显示 1隐藏
	 */
	private Integer isHide;

	/**
	 * 描述
	 */
	private String description;



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private Resource parent;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSourceKey() {
		return sourceKey;
	}

	public void setSourceKey(String sourceKey) {
		this.sourceKey = sourceKey;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getIsHide() {
		return isHide;
	}

	public void setIsHide(Integer isHide) {
		this.isHide = isHide;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Resource getParent() {
		return parent;
	}

	public void setParent(Resource parent) {
		this.parent = parent;
	}

}
