package com.seangogo.blogs.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.seangogo.blogs.pojo.Base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "tbl_role_function")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Data
public class RoleFunction extends BaseEntity<User> {

    @Column(name = "roleId", length = 36)
    private String roleId;

    @Column(name = "functionId", length = 36)
    private String functionId;

    @Column(name="remark")
    private String remark;

    @Transient
    private List<FunctionFilter> fflist;


}
