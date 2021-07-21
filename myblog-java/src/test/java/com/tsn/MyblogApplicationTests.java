package com.tsn;

import com.tsn.entity.Role;
import com.tsn.mapper.UserMapper;
import com.tsn.service.RoleService;
import com.tsn.service.UserService;
import com.tsn.util.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class MyblogApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    RoleService roleService;
    @Test
    void contextLoads() {

        System.out.println(userService.getUserInfo("tsn"));
    }

    @Test
    void t2(){
        String jwt = jwtUtils.generateToken(1);
        System.out.println("sdssdsd"+jwt);
    }
    @Test
    void t3(){
        Role role = new Role();
        role.setRoleId(1);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        System.out.println(roles);
    }


}
