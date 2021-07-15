package com.tsn;

import com.tsn.mapper.UserMapper;
import com.tsn.service.UserService;
import com.tsn.util.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyblogApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    JwtUtils jwtUtils;
    @Test
    void contextLoads() {
        userService.list().forEach(System.out::println);
    }

    @Test
    void t2(){
        String jwt = jwtUtils.generateToken(1);
        System.out.println("sdssdsd"+jwt);
    }

}
