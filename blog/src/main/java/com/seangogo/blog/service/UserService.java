package com.seangogo.blog.service;

import com.seangogo.blog.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sean on 2017/8/24.
 */
public interface UserService {

    void deleteUser(Long id);

    User findUserById(Long id);

    List<User> findAllUser();

    void saveUser(User user);

    void updateUser(User user);
}
