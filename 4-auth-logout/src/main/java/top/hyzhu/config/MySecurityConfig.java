package top.hyzhu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import top.hyzhu.handler.JsonLogoutSuccessHandler;
import top.hyzhu.handler.MyLogoutHandler;

/**
 * @Author: zhy
 * @Description: MySecurityConfig
 * @Date: 2024-11-13 20:02
 **/

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // 配置所有的Http请求必须认证
        http.authorizeHttpRequests()
                .requestMatchers("/login.html", "/demo.html")
                .permitAll()
                .anyRequest()
                .authenticated();

        // 开启表单登录
        http.formLogin();

        //自定义注销登录请求处理路径
        // 注销登录
        http.logout()
                .clearAuthentication(true)
                .deleteCookies("xxx", "yyy")
                .invalidateHttpSession(true)
                .logoutUrl("/custom/logout")
                .logoutSuccessUrl("/demo.html")
                .addLogoutHandler(new MyLogoutHandler())
                .logoutSuccessHandler(new JsonLogoutSuccessHandler());
        // 开启Basic认证
        http.httpBasic();

        // 关闭 CSRF
        http.csrf().disable();
        return http.build();
    }

}