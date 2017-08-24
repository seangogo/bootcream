package com.seangogo.blog.controller;

import com.seangogo.blog.domain.User;
import com.seangogo.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sean on 2017/8/24.
 */
@RestController
@RequestMapping
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userService.findAllUser());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }

    /**
     * 根据id查询用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id,Model model){
        model.addAttribute("user",userService.findUserById(id));
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/view","userModel",model);
    }

    /**
     * 获取创建表单用户
     * @param model
     * @return
     */
    @PostMapping("/from")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/from","userModel",model);
    }

    /**
     * 新增或者修改用户信息
     * @param user
     * @param model
     * @return
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user,Model model){
        userService.saveUser(user);
        return new ModelAndView("user/from","userModel",model);
    }

}
