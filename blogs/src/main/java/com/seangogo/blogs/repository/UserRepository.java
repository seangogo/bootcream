package com.seangogo.blogs.repository;


import com.seangogo.blogs.domain.User;
import com.seangogo.blogs.repository.support.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository添加了自定义接口
 * 命名规范
 */
@Repository
public interface UserRepository  extends BaseRepository<User,String>/*, UserRepositoryPlus */{
        User findByName(String username);
}
