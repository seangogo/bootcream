package com.seangogo.blogs.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.seangogo.blogs.annotation.ForeignShow;
import com.seangogo.blogs.annotation.Header;
import com.seangogo.blogs.pojo.Base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by sean on 2017/8/31.
 */
@Entity
@Data
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
}
