package com.digitalinnovationone.springbootconfig.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {

    private String driverClassName;
    private String url;
    private String userName;
    private String password;

    @Profile("dev")
    @Bean
    public String testDataBaseConnection()
    {
        System.out.println("Db Connection!");
        return "Connection test";
    }

    @Profile("prod")
    @Bean
    public String productionDataBaseConnection()
    {
        System.out.println("Db Connection!");
        return "Connection prod";
    }
}
