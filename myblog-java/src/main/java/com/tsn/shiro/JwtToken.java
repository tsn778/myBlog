package com.tsn.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author tsn77
 * @Date 2021/7/8 17:09
 * @Version 1.0
 */
public class JwtToken implements AuthenticationToken {
    private String token;
    public JwtToken(String jwt){
        this.token=jwt;
    }
    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
