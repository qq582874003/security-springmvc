package com.michael.security.springmvc.service;

import com.michael.security.springmvc.model.AuthenticationRequest;
import com.michael.security.springmvc.model.UserDto;

/**
 * 认证服务
 *
 * @author wangce 2021-04-18
 * @since 1.0.0
 */
public interface AuthenticationService {

    /**
     * 用户认证
     * @param authenticationRequest 用户认证请求
     * @return 认证成功的用户信息
     */
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
