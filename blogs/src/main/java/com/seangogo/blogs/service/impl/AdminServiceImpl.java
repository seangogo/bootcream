package com.seangogo.blogs.service.impl;

import com.seangogo.blogs.domain.Admin;
import com.seangogo.blogs.repository.AdminRepository;
import com.seangogo.blogs.repository.support.BaseRepository;
import com.seangogo.blogs.service.AdminService;
import com.seangogo.blogs.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sean on 2017/9/11.
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin,String> implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public BaseRepository<Admin, String> getBaseDao() {
        return this.adminRepository;
    }

    @Override
    public Admin findByLoginName(String loginName) {
        return adminRepository.findByLoginName(loginName);
    }

    @Override
    public boolean existsByEmail(String email) {
        return adminRepository.existsByEmail(email);
    }
}
