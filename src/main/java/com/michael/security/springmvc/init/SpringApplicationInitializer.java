package com.michael.security.springmvc.init;

import com.michael.security.springmvc.config.ApplicationConfig;
import com.michael.security.springmvc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 加载 Spring容器
 *
 * @author wangce 2021-04-17
 * @since 1.0.0
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * spring容器，想当于加载applicationContext.xml
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //指定rootContext的配置类
        return new Class<?>[] { ApplicationConfig.class };
    }

    /**
     * servletContext
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        //指定servletContext的配置类
        return  new Class<?>[] { WebConfig.class };
    }

    /**
     * url-mapping
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String [] {"/"};
    }
}
