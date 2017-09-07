package com.seangogo.blogs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.seangogo.blogs.pojo.annotation.Header;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sean on 2017/9/5.
 */
@Entity
@Data
@Accessors(fluent = true)
@DiscriminatorValue("ADMIN")
public class Admin extends Personnel {
    @Header(name = "昵称")
    @Column(name = "nickname")
    private String nickname;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "admin_role", joinColumns = @JoinColumn(name = "admin_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @JsonIgnoreProperties("admins")
    private Set<Role> roles = new HashSet();

}
