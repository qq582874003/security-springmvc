package com.michael.security.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Spring 容器配置
 * 对应web.xml中ContextLoaderListener的配置
 *
 * @author wangce 2021-04-17
 * @since 1.0.0
 */
@Configuration
@ComponentScan(basePackages="com.michael.security.springmvc",excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,value = Controller.class)})
public class ApplicationConfig {
    //在此配置除了Controller的其它bean，比如：数据库链接池、事务管理器、业务bean等。
}
