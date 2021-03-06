package com.seangogo.blogs.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.seangogo.blogs.domain.enums.Gender;
import com.seangogo.blogs.domain.enums.PersonnelType;
import com.seangogo.blogs.pojo.annotation.Header;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 前台用户
 */
@Entity
@Getter
@Setter
@DiscriminatorValue("USER")
@NoArgsConstructor
@Accessors(fluent = true)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class User extends Personnel {


    @Header(name = "姓名")
    @Column(name = "name")
    private String name;

    @Header(name = "性别")
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Header(name = "出生年月")
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

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



    public User(PersonnelType personnelType, String openAccount, String loginName, String password, String email) {
        super(personnelType, openAccount, loginName, password, email);
    }
}
