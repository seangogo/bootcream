package com.seangogo.blogs.repository;

import com.seangogo.blogs.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by sean on 2017/9/1.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void save() throws Exception {
        User user=new User();
        user.qq("949247328");
        userRepository.save(user);
    }

    @Test
    public void findOne() throws Exception {
        User user=new User();
        user.qq("949247328");
        User repositoryOne=userRepository.findOne(Example.of(user));
        System.out.println(repositoryOne);
    }
    @Test
    public void findList() throws Exception {
        User user=new User();
        user.qq("949247328");
        List<User> Users=userRepository.getList("22");
        System.out.println(Users.size());
    }
}