package com.seangogo.blogs.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.seangogo.blogs.pojo.annotation.Header;
import com.seangogo.blogs.pojo.Base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by billJiang on 2017/1/3.
 * e-mail:jrn1012@petrochina.com.cn qq:475572229
 * 功能上的数据权限
 */
@Entity
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class FunctionFilter extends BaseEntity<User> {

    @Header(name="关键字")
    @Column(name="[key]")
    private String key;

    @Header(name="操作符")
    @Column(name="operator")
    private String operator;

    @Header(name ="值" )
    @Column(name="[value]")
    private String value;

    @Header(name="类型")
    @Column(name="class_type")
    private String classType;

    @Header(name="排序")
    @Column(name="sort")
    private Integer sort;

    @Header(name="角色Id")
    @Column(name="roleId")
    private String roleId;

    @Header(name="功能Id")
    @Column(name="functionId")
    private String functionId;

}
