package top.hyzhu.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * @Author: zhy
 * @Description: MySecurityConfig
 * @Date: 2024-11-13 19:01
 **/

@Configuration
@EnableWebSecurity // 开启 Spring Security
public class MySecurityConfig {
    /**
     * 密码编码器
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}