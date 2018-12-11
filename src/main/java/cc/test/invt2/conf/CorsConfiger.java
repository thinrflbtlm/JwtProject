/******************************************************************************
 * Copyright (c) 2017-2018. Spring-Boot -Version 2.1.0.RELEASE                *
 * CorsConfiger1.java  181209 06:34:26 by @Chenccsy                           *
 * JavaProject builded by IDE@ ,all rights reserved.                          *
 ******************************************************************************/

package cc.test.invt2.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfiger {
//    private String[] urls = new String[]{
//            "localhost",
//            "127.0.0.1",
//            "syc.tk",
//            "chenccsy.com",
//            "www.chenccsy.com"
//    };

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration configuration = new CorsConfiguration();
//        for (String url : urls) {
////            添加运行跨域访问地址
//            configuration.addAllowedOrigin("http://" + url);
//            configuration.addAllowedOrigin("https://" + url);
//        }
//        url限制
        configuration.addAllowedOrigin("*");
//        POST 、 GET 等方法限制
        configuration.addAllowedMethod("*");
//        运行头部为指定
        configuration.addAllowedHeader("*");
//        允许跨域共享资源(安全证书）
//        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        过滤器过滤请求的路径配置
        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
    }
}
