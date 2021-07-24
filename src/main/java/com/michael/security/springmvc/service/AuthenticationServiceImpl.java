package com.michael.security.springmvc.service;

import com.michael.security.springmvc.model.AuthenticationRequest;
import com.michael.security.springmvc.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 请在这里填写该类具有作用
 *
 * @author wangce 2021-04-18
 * @since 1.0.0
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    /**
     * 校验用户信息
     * @param authenticationRequest 用户认证请求
     * @return
     */
    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        //校验参数是否为空
        if(authenticationRequest == null
                || StringUtils.isEmpty(authenticationRequest.getUsername())
        || StringUtils.isEmpty(authenticationRequest.getPassword())){
            throw new RuntimeException("账号密码为空");
        }
        UserDto userDto = getUserDto(authenticationRequest.getUsername());
        if(userDto == null){
            throw new RuntimeException("查询不到该用户");
        }
        if(!authenticationRequest.getPassword().equals(userDto.getPassword())){
            throw new RuntimeException("账号或密码错误");
        }
        return userDto;
    }

    //模拟用户查询
    public UserDto getUserDto(String username){
        return userMap.get(username);
    }

    //用户信息
    private Map<String,UserDto> userMap = new HashMap<>();
    {
        Set<String> authorities1 = new HashSet<>();
        authorities1.add("p1"); // p1和资源/r/r1对应
        Set<String> authorities2 = new HashSet<>();
        authorities2.add("p2");// p2和资源/r/r2对应

        userMap.put("zhangsan",new UserDto("1010","zhangsan","123","张三","133443", authorities1));
        userMap.put("lisi",new UserDto("1011","lisi","456","李四","144553", authorities2));
    }
}
