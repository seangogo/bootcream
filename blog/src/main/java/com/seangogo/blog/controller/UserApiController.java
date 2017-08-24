package com.seangogo.blog.controller;

import com.seangogo.blog.domain.User;
import com.seangogo.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sean on 2017/8/24.
 */
@RestController
public class UserApiController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    public User findOneUser(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @RequestMapping(value = "/api/User", method = RequestMethod.PUT)
    public void modifyUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @RequestMapping(value = "/api/User/{id}", method = RequestMethod.DELETE)
    public void modifyUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
