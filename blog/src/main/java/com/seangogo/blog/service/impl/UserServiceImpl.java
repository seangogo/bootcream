package com.seangogo.blog.service.impl;

import com.seangogo.blog.domain.User;
import com.seangogo.blog.repository.UserRepository;
import com.seangogo.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sean on 2017/8/24.
 */
@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
