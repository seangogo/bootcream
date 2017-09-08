package com.seangogo.blogs.controller;

import com.seangogo.blogs.utils.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by sean on 2017/9/6.
 */
@Controller
@RequestMapping("admin")
public class AdminLoginController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final static String MAIN_PAGE = PropertiesUtil.getValue("page.main");
    private final static String LOGIN_PAGE = PropertiesUtil.getValue("page.login");
    private final static String REGISTER_PAGE = PropertiesUtil.getValue("page.register");
    /*@Autowired
    OAuthServices oAuthServices;*/
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(Model model) {
       // model.addAttribute("oAuthInfo", new OAuthUser());
        return new ModelAndView(REGISTER_PAGE);
    }

    //SpringBoot SpringMVC实现文件下载
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    ResponseEntity<InputStreamResource> downloadFile(String log)
            throws IOException {
        String filePath = "/Users/alilang/logs/" + log;
        FileSystemResource file = new FileSystemResource(filePath);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }
}
