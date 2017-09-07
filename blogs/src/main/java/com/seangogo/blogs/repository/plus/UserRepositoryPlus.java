package com.seangogo.blogs.repository.plus;

import com.seangogo.blogs.domain.User;

import java.util.List;

/**
 * Created by sean on 2017/9/1.
 */
public interface UserRepositoryPlus {
    List<User> getList(String id);
}
