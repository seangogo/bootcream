package com.seangogo.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sean on 2017/8/23.
 */
@Controller
public class ErrorTestController {

    @RequestMapping("error1")
    public String error1() throws Exception{
        throw  new Exception("发生错误");
    }
}
