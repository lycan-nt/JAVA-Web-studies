package com.owl.springngblog.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface IServiceWebSecurityConfigurer {
    void configure(HttpSecurity http) throws Exception;
}
