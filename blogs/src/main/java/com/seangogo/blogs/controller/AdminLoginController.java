package com.seangogo.blogs.controller;

import com.seangogo.blogs.VO.ResultVO;
import com.seangogo.blogs.domain.Admin;
import com.seangogo.blogs.domain.enums.ResultEnum;
import com.seangogo.blogs.service.AdminService;
import com.seangogo.blogs.utils.PropertiesUtil;
import com.seangogo.blogs.utils.VerifyCodeUtils;
import com.seangogo.blogs.utils.encryption.AESUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by sean on 2017/9/6.
 */
@Controller
@RequestMapping("admin")
public class AdminLoginController extends BaseController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final static String MAIN_PAGE = PropertiesUtil.getValue("page.main");
    private final static String LOGIN_PAGE = PropertiesUtil.getValue("page.login");
    private final static String GLOBAL_SALT = PropertiesUtil.getValue("global.salt");

    @Autowired
    private AdminService adminService;


    @RequestMapping(value = {"/admin/login"}, method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password, ModelMap model
    ) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            return redirect("/admin/index");
        } catch (AuthenticationException e) {
            model.put("message", e.getMessage());
        }
        return new ModelAndView("admin/login");
    }

    @RequestMapping(value = {"/admin/register"}, method = RequestMethod.POST)
    @ResponseBody
    public ResultVO register(Admin admin, ModelMap model, String vcode) {
        //todo volidata
        if (!VerifyCodeUtils.verifyCode(vcode)) {
            return new ResultVO(ResultEnum.CODE_ERROR);
        }
        if (adminService.existsByEmail(admin.email())) {
            return new ResultVO(ResultEnum.EMAIL_EXIST);
        }
        //加密
        admin.password(AESUtils.encrypt(GLOBAL_SALT, admin.password()));
        adminService.save(admin);
     /*   LoggerUtils.fmtDebug(getClass(), "注册插入完毕！", JSONObject.fromObject(entity).toString());
        entity = TokenManager.login(entity, Boolean.TRUE);
        LoggerUtils.fmtDebug(getClass(), "注册后，登录完毕！", JSONObject.fromObject(entity).toString());
        resultMap.put("message", "注册成功！");
        resultMap.put("status", 200);*/
        return new ResultVO(ResultEnum.SUCCESS);
    }


    @RequestMapping(value = {"/admin/logout"}, method = RequestMethod.GET)
    public ModelAndView logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return redirect("admin/login");
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView(LOGIN_PAGE);
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
