package com.digitalinnovationone.springbootconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Value("${app.message}")
    private String appMessage;

    @Value("${ENV_DB_URL:NENHUMA}")
    private String dbEnvironmentVarieble;

    @GetMapping("/")
    public String getAppMessage()
    {
        return appMessage;
    }

    @GetMapping("/envVariable")
    public String getEnvironmentVarieble()
    {
        return "A seguinte variavel foi passada: " + dbEnvironmentVarieble;
    }
}
