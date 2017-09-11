package com.seangogo.blogs.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.seangogo.blogs.pojo.annotation.ForeignShow;
import com.seangogo.blogs.pojo.annotation.Header;
import com.seangogo.blogs.pojo.Base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sean on 2017/8/31.
 */
@Entity
@Getter
@Setter
@Table(name = "rbac_role")
@Accessors(fluent = true)
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class Role extends BaseEntity<User>{
    @ForeignShow
    @Header(name = "名称")
    @Column(name = "name", length = 50)
    private String name;

    @Header(name = "编码")
    @Column(name = "code", length = 50)
    private String code;

    @Header(name = "备注")
    @Column(name = "remark", length = 1000)
    private String remark;

    @Header(name = "排序")
    @Column(name = "sort")
    private Integer sort;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "rbac_admin_role", joinColumns = @JoinColumn(name = "role_id",
            referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "admin_id",
            referencedColumnName = "id"))
    @JsonIgnoreProperties("roles")
    private Set<Admin> admins = new HashSet();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "rbac_role_resource", joinColumns =  @JoinColumn(name = "role_id",
            referencedColumnName = "id") , inverseJoinColumns =  @JoinColumn(name = "resource_id",
            referencedColumnName = "id")
    )
    @JsonIgnoreProperties("roles")
    private Set<Resource> resources=new HashSet<>();

}
