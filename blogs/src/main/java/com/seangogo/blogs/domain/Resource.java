package com.seangogo.blogs.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.seangogo.blogs.domain.enums.ResourceType;
import com.seangogo.blogs.pojo.Base.BaseEntity;
import com.seangogo.blogs.pojo.annotation.ForeignShow;
import com.seangogo.blogs.pojo.annotation.Header;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Entity
@Getter
@Setter
@Table(name = "rbac_resource")
public class Resource extends BaseEntity<User> {
    @ForeignShow
    @Header(name = "名称")
    @Column(name = "name", length = 50)
    private String name;

    @Header(name = "编码")
    @Column(name = "code", length = 50)
    private String code;

    // 0=目录 1=功能 2=按钮
    @Header(name = "菜单类型")
    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

    @Header(name = "url")
    @Column(name = "url", length = 200)
    private String url;

    @Header(name = "排序")
    @Column(name = "sort")
    private Integer sort;

    @Header(name = "父级ID")
    @Column(name = "parent_id")
    private String parentId;

    @Header(name = "层级编码")
    @Column(name = "levelCode", length = 36)
    private String levelCode;

    @Header(name = "图标")
    @Column(name = "icon")
    private String icon;

    @Header(name = "备注")
    @Column(name = "remark", length = 1000)
    private String remark;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "rbac_role_resource", joinColumns = @JoinColumn(name = "resource_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @JsonIgnoreProperties("resources")
    private Set<Role> roles = new HashSet();
}
