package com.seangogo.blogs.service;

import com.seangogo.blogs.domain.Admin;
import com.seangogo.blogs.service.support.BaseService;

/**
 * Created by sean on 2017/9/11.
 */
public interface AdminService extends BaseService<Admin,String> {
    Admin findByLoginName(String loginName);

    boolean existsByEmail(String email);
}
