package com.michael.security.springmvc.model;

import lombok.Data;

/**
 * 认证请求
 *
 * @author wangce 2021-04-18
 * @since 1.0.0
 */
@Data
public class AuthenticationRequest {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

}
