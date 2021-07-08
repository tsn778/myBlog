package com.tsn;

import com.tsn.mapper.UserMapper;
import com.tsn.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyblogApplicationTests {
    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        userService.list().forEach(System.out::println);
    }

}
