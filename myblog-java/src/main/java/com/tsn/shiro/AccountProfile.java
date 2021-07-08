package com.tsn.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author tsn77
 * @Date 2021/7/8 17:50
 * @Version 1.0
 */
@Data
public class AccountProfile implements Serializable {
    private Integer id;

    private String username;

    private String avatar;

    private String email;
}
