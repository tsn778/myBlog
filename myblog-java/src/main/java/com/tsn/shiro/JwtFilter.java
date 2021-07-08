package com.tsn.shiro;

import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.http.server.HttpServerResponse;
import cn.hutool.json.JSONUtil;
import com.tsn.common.Result;
import com.tsn.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;

import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author tsn77
 * @Date 2021/7/8 17:06
 * @Version 1.0
 */
@Component
public class JwtFilter extends AuthenticatingFilter {
    @Autowired
    JwtUtils jwtUtils;
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        String jwt = request.getHeader("Authorization");
        if(ObjectUtils.isEmpty(jwt))
            return null;
        return new JwtToken(jwt);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        String jwt = request.getHeader("Authorization");
        if(ObjectUtils.isEmpty(jwt))
            return true;
        else
        {
            //校验jwt
            Claims claim = jwtUtils.getClaimByToken(jwt);
            if(claim ==null|| jwtUtils.isTokenExpired(claim.getExpiration())){
                throw  new ExpiredCredentialsException("token已失效，请重新登录");
            }
            //执行登录
        }
        return executeLogin(servletRequest,servletResponse);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpServletResponse= (HttpServletResponse) response;
        Throwable throwable=e.getCause() ==null ? e :e.getCause();
        Result result = Result.failure(throwable.getMessage());
        String json= JSONUtil.toJsonStr(result);
        try {
            httpServletResponse.getWriter().println(json);
        }catch (IOException ioException){

        }

        return false;
    }
}
