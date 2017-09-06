package com.seangogo.blogs.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.seangogo.blogs.pojo.annotation.Header;
import com.seangogo.blogs.pojo.Base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 用户头像
 */
@Entity
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class UserAvatar extends BaseEntity<User> {

    @Header(name="用户Id")
    @Column(name="user_id",length=32)
    private String userId;

    @Header(name="头像名称")
    @Column(name="name")
    private String name;

    @Header(name="头像路径")
    @Column(name="src")
    private String src;


}
