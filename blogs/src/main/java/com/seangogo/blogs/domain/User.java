package com.seangogo.blogs.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.seangogo.blogs.annotation.Header;
import com.seangogo.blogs.pojo.Base.BaseEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by sean on 2017/8/31.
 */
@Entity
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class User extends BaseEntity<User> {

    @Header(name = "姓名")
    @Column(name = "name")
    private String name;

    @Header(name = "性别")
    @Column(name = "sex")
    private String sex;

    @Header(name = "出生年月")
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Header(name = "登录名")
    @Column(name = "login_name")
    private String loginName;

    @Header(name = "密码")
    @Column(name = "password")
    private String password;

    @Header(name = "邮箱")
    @Column(name = "email", length = 50)
    private String email;

    @Header(name = "座机")
    @Column(name = "telphone")
    private String telphone;

    @Header(name = "手机")
    @Column(name = "mobile")
    private String mobile;

    @Header(name = "QQ")
    @Column(name = "qq")
    private String qq;

    @Header(name = "微信")
    @Column(name = "wechat")
    private String wechat;

    @Header(name = "是否开启账号")
    @Column(name = "open_account", length = 5)
    private String openAccount;

    @Header(name = "超级管理员")
    @Column(name = "isSuperAdmin")
    private String isSuperAdmin;

    @Header(name = "部门ID")
    @Column(name = "dept_id")
    private String deptId;

}
