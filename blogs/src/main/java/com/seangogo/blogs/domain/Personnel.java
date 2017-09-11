package com.seangogo.blogs.domain;

import com.seangogo.blogs.domain.enums.PersonnelType;
import com.seangogo.blogs.pojo.Base.BaseEntity;
import com.seangogo.blogs.pojo.annotation.Header;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * Created by sean on 2017/9/5.
 */
@Entity
@Getter
@Setter
@Inheritance
@DiscriminatorColumn(name="personnelType")
@DiscriminatorValue("PERSONNEL")
@Accessors(fluent = true)
public class Personnel extends BaseEntity<Personnel> {

    @Header(name="人员类型")
    @Column(nullable = false, length = 50, insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private PersonnelType personnelType;

    @Header(name = "是否开启账号")
    @Column(name = "open_account", length = 5)
    private String openAccount;

    @Header(name = "登录名")
    @Column(name = "login_name")
    private String loginName;

    @Header(name = "密码")
    @Column(name = "password")
    private String password;

    @Header(name = "邮箱")
    @Column(name = "email", length = 50)
    private String email;

    public Personnel() {
    }

    public Personnel(PersonnelType personnelType, String openAccount, String loginName, String password, String email) {
        this.personnelType = personnelType;
        this.openAccount = openAccount;
        this.loginName = loginName;
        this.password = password;
        this.email = email;
    }
}
