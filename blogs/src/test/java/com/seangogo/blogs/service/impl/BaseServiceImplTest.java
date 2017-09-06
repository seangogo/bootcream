package com.seangogo.blogs.service.impl;

import com.seangogo.blogs.domain.User;
import com.seangogo.blogs.repository.PersonnelRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by sean on 2017/9/6.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class BaseServiceImplTest {
    @Autowired
    private PersonnelRepository baseService;

  /*  @Resource
    private PersonnelRepository personnelBaseRepository;*/

    @Test
    public void save() throws Exception {
        User user=new User();
        user.qq("949247328").name("sean").birthday(new Date()).mobile("123456");
        User user1=(User) baseService.save(user);
        log.info("对象属性:{}",user1);
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void saveOrUpdate() throws Exception {
    }

    @Test
    public void batchSave() throws Exception {
    }

}