package com.seangogo.blogs.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.seangogo.blogs.pojo.Base.BaseEntity;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class UserRole extends BaseEntity<UserRole> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "roleId", length = 36)
    private String roleId;

}
