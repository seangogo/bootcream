package com.seangogo.blogs.config.shiro;

import com.seangogo.blogs.domain.Admin;
import com.seangogo.blogs.domain.Resource;
import com.seangogo.blogs.domain.Role;
import com.seangogo.blogs.service.AdminService;
import com.seangogo.blogs.utils.encryption.MD5Utils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.AllowAllCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SPPan
 */
@Component
public class MyRealm extends AuthorizingRealm {

    public MyRealm() {
        super(new AllowAllCredentialsMatcher());
        setAuthenticationTokenClass(UsernamePasswordToken.class);

        //FIXME: 暂时禁用Cache
        setCachingEnabled(false);
    }

    @Autowired
    private AdminService adminService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {


        Admin admin = (Admin) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Admin dbAdmin = adminService.findByLoginName(admin.loginName());
        Set<String> shiroPermissions = new HashSet<>();
        Set<String> roleSet = new HashSet<String>();
        Set<Role> roles = dbAdmin.roles();
        for (Role role : roles) {
            Set<Resource> resources = role.resources();
            for (Resource resource : resources) {
                shiroPermissions.add(resource.getCode());
            }
            roleSet.add(role.code());
        }
        authorizationInfo.setRoles(roleSet);
        authorizationInfo.setStringPermissions(shiroPermissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        if (token == null)
            throw new AuthenticationException("parameter token is null");

        String loginName = (String) token.getPrincipal();

        Admin admin = adminService.findByLoginName(loginName);

        String password = new String((char[]) token.getCredentials());

        // 账号不存在
        if (admin == null) {
            throw new AuthorizationException("parameters principals is null");
        }
        // 密码错误
        if (!MD5Utils.md5(password).equals(admin.password())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }//todo 目前由前端MD5加密，后期优化成 前端MD5 加后端的其他加密算法
        // 账号锁定
        if (admin.locked()) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(admin, password, getName());
        return info;
    }

}
