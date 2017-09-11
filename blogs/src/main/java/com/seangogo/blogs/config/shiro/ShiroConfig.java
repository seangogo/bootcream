package com.seangogo.blogs.config.shiro;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sean on 2017/9/8.
 */
@Configuration
public class ShiroConfig {

    /**
     * 系统安全认证实现类
     * @return
     */
    @Bean(name = "realm")
    @DependsOn("lifecycleBeanPostProcessor")
    @ConditionalOnMissingBean
    public Realm realm() {
        return new MyRealm();
    }



    /**
     * 用户授权信息Cache
     */
    @Bean(name = "shiroCacheManager")
    @ConditionalOnMissingBean
    public CacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();//todo 后期改为redis
    }

    @Bean(name = "securityManager")
    @ConditionalOnMissingBean
    public DefaultSecurityManager securityManager() {
        DefaultSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setCacheManager(cacheManager());
        return defaultSecurityManager;
    }

    @Bean(name = "shiroFilter")
    @DependsOn("securityManager")
    @ConditionalOnMissingBean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultSecurityManager securityManager, Realm realm) {
        securityManager.setRealm(realm);

        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setLoginUrl("/admin/login");
        shiroFilter.setSuccessUrl("/admin/index");
        shiroFilter.setUnauthorizedUrl("/previlige/no");
        Map<String, String> filterChainDefinitionMap = new HashMap<String, String>();
        filterChainDefinitionMap.put("/assets/**", "anon");

        filterChainDefinitionMap.put("/admin/login", "anon");

        filterChainDefinitionMap.put("/admin/user/index", "perms[system:user:index]");
        filterChainDefinitionMap.put("/admin/user/add", "perms[system:user:add]");
        filterChainDefinitionMap.put("/admin/user/edit*", "perms[system:user:edit]");
        filterChainDefinitionMap.put("/admin/user/deleteBatch", "perms[system:user:deleteBatch]");
        filterChainDefinitionMap.put("/admin/user/grant/**", "perms[system:user:grant]");

        filterChainDefinitionMap.put("/admin/role/index", "perms[system:role:index]");
        filterChainDefinitionMap.put("/admin/role/add", "perms[system:role:add]");
        filterChainDefinitionMap.put("/admin/role/edit*", "perms[system:role:edit]");
        filterChainDefinitionMap.put("/admin/role/deleteBatch", "perms[system:role:deleteBatch]");
        filterChainDefinitionMap.put("/admin/role/grant/**", "perms[system:role:grant]");

        filterChainDefinitionMap.put("/admin/resource/index", "perms[system:resource:index]");
        filterChainDefinitionMap.put("/admin/resource/add", "perms[system:resource:add]");
        filterChainDefinitionMap.put("/admin/resource/edit*", "perms[system:resource:edit]");
        filterChainDefinitionMap.put("/admin/resource/deleteBatch", "perms[system:resource:deleteBatch]");

        filterChainDefinitionMap.put("/admin/**", "authc");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilter;
    }



/*
    *//**
     * 过滤器注册bean
     * @return
     *//*
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistration;
    }

    *//**
     * @see org.apache.shiro.spring.web.ShiroFilterFactoryBean
     * @return
     *//*
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
        bean.setLoginUrl("/login");
        bean.setUnauthorizedUrl("/unauthor");

        Map<String, Filter>filters = Maps.newHashMap();
        filters.put("perms", urlPermissionsFilter());
        filters.put("anon", new AnonymousFilter());
        bean.setFilters(filters);

        Map<String, String> chains = Maps.newHashMap();
        chains.put("/login", "anon");
        chains.put("/unauthor", "anon");
        chains.put("/logout", "logout");
        chains.put("/base/**", "anon");
        chains.put("/css/**", "anon");
        chains.put("/layer/**", "anon");
        chains.put("/**", "authc,perms");
        bean.setFilterChainDefinitionMap(chains);
        return bean;
    }

    *//**
     * @see org.apache.shiro.mgt.SecurityManager
     * @return
     *//*
    @Bean(name="securityManager")
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm());
        manager.setCacheManager(cacheManager());
        manager.setSessionManager(defaultWebSessionManager());
        return manager;
    }

    *//**
     * @see DefaultWebSessionManager
     * @return
     *//*
    @Bean(name="sessionManager")
    public DefaultWebSessionManager defaultWebSessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setCacheManager(cacheManager());
        sessionManager.setGlobalSessionTimeout(1800000);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setDeleteInvalidSessions(true);
        return sessionManager;
    }

    *//**
     * @see UserRealm--->AuthorizingRealm
     * @return
     *//*
    @Bean
    @DependsOn(value="lifecycleBeanPostProcessor")
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        userRealm.setCacheManager(cacheManager());
        return userRealm;
    }

    @Bean
    public URLPermissionsFilter urlPermissionsFilter() {
        return new URLPermissionsFilter();
    }

    @Bean
    public EhCacheManager cacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        return cacheManager;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }*/
}
