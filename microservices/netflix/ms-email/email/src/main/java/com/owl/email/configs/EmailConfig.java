package com.owl.email.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@ConfigurationProperties
public class EmailConfig {

    private static final int GMAIL_SMTP_PORT = 587;
    @Value("${spring.email.host}")
    private String host;
    @Value("${spring.email.username}")
    private String user;
    @Value("${spring.email.password}")
    private String password;
    @Value("${spring.email.sender.debug}")
    private Boolean debug;
    @Value("${spring.transport.protocol}")
    private String protocol;
    @Value("${spring.email.properties.mail.smtp.auth}")
    private String auth;
    @Value("${spring.email.properties.mail.smtp.starttls.enable}")
    private String starttls;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.host);
        mailSender.setPort(GMAIL_SMTP_PORT);
        mailSender.setUsername(this.user);
        mailSender.setPassword(this.password);
        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", this.protocol);
        properties.put("mail.smtp.auth", this.auth);
        properties.put("mail.smtp.starttls.enable", this.starttls);
        properties.put("mail.debug", this.debug);
        return mailSender;
    }

}
