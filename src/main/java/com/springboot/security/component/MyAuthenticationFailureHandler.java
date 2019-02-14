package com.springboot.security.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.security.bean.Msg;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author N
 * @create 2019/2/14 -- 17:22
 * @email 554197854@qq.com
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    public void onAuthenticationFailure(HttpServletRequest req,
                                        HttpServletResponse resp,
                                        AuthenticationException e) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        Msg msg = Msg.fail();
        Map map = new HashMap();
        if (e instanceof BadCredentialsException ||
                e instanceof UsernameNotFoundException) {
        } else if (e instanceof LockedException) {
            map.put("loginError", "账户被锁定，请联系管理员!");
        } else if (e instanceof CredentialsExpiredException) {
            map.put("loginError", "密码过期，请联系管理员!");
        } else if (e instanceof AccountExpiredException) {
            map.put("loginError", "账户过期，请联系管理员!");
        } else if (e instanceof DisabledException) {
            map.put("loginError", "账户被禁用，请联系管理员!");
        } else {
            map.put("loginError", "登录失败!");
        }
        msg.setExtend(map);
        resp.setStatus(401);
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = resp.getWriter();
        out.write(om.writeValueAsString(msg));
        out.flush();
        out.close();
    }
}
