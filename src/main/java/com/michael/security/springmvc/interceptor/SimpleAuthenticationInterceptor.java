package com.michael.security.springmvc.interceptor;

import com.michael.security.springmvc.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 授权拦截器
 *
 * @author wangce 2021-04-19
 * @since 1.0.0
 */
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在此方法中检验用户请求的url是否在用户的权限范围内
        //读取会话信息
        Object object = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if(object == null){
            writeContent(response,"请登录");
        }

        //请求的url
        UserDto user = (UserDto) object;
        String requestURI = request.getRequestURI();
        if(user.getAuthorities().contains("p1") && requestURI.contains("/r1")){
            return true;
        }
        if(user.getAuthorities().contains("p2") && requestURI.contains("/r2")){
            return true;
        }
        writeContent(response,"权限不足，拒绝访问");
        return false;
    }
    //响应输出
    private void writeContent(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(msg);
        writer.close();
    }
}
