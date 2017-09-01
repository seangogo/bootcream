package com.seangogo.blogs.repository;


import com.seangogo.blogs.domain.User;

/**
 * UserRepository添加了自定义接口
 * 命名规范
 */
public interface UserRepository  extends BaseRepository<User, String>,
        UserRepositoryPlus {
        User save(User user);
}
