package com.seangogo.blogs.repository;

import com.seangogo.blogs.domain.Admin;
import com.seangogo.blogs.domain.Personnel;
import com.seangogo.blogs.domain.Role;
import com.seangogo.blogs.domain.User;
import com.seangogo.blogs.utils.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


/**
 * Created by sean on 2017/9/5.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class PersonnelTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PersonnelRepository personnelRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Test
    public void save() throws Exception {
        User user = new User();
        user.qq("949247328").birthday(new Date()).email("949247328@qq.com");
        userRepository.save(user);
        Role role = new Role();
        role.code("code").name("角色一").remark("备注").sort(1);
        //      roleRepository.save(role);
        Admin admin = new Admin();
        Set<Role> roles = new HashSet();
        roles.add(role);
        admin.roles(roles);
        admin.nickname("后台用户昵称").loginName("15972911474").password("mima");
        adminRepository.save(admin);

        Personnel personnel = new Personnel();
        personnel.password("222").loginName("223123");
        personnelRepository.save(personnel);

    }

    @Test
    public void findOne() throws Exception {
       /* User user=new User();
        user.setQq("949247328");
        User repositoryOne=userRepository.findOne(Example.of(user));
        System.out.println(repositoryOne);*/
    }

    @Test
    public void findList() throws Exception {
        List<User> Users = userRepository.findAll();
        System.out.println(Users.size());
        Collection<Admin> admins = adminRepository.findAll();
/*        admins.stream().filter(admin -> admin.roles().size()>0)
                .forEach(admin -> admin.roles().stream().forEach(
                        role -> System.out.println(role.id())
                ))*/
        JsonMapper mapper = new JsonMapper();
        log.info("admins:{}", mapper.toJson(admins));
        admins.stream().forEach(admin -> admin.roles().stream().forEach(role ->
                log.info("角色实体json:{}", mapper.toJson(role))
        ));
    }

    @Test
    public void deleteOne() throws Exception {
        Personnel personnel = new Personnel();
        Example<Personnel> example = Example.of(personnel.loginName("223123"));
        List<Personnel> personnels = personnelRepository.findAll(example);
        personnels.forEach(user1 ->personnelRepository.delete(user1));
    }
}
