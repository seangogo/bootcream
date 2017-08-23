package com.seangogo.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sean on 2017/8/23.
 */
@RestController
public class HelloWordController {

    @RequestMapping("hello")
    public String hello() {
        return "HelloWord!";
    }

}
