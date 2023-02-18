package com.owl.clientemail.webservers;

import com.owl.clientemail.configs.RestTemplateConfig;
import com.owl.clientemail.dtos.EmailDTO;
import com.owl.clientemail.models.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

@Service
public class EmailEndPoint {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplateConfig restTemplateConfig ;

    public EmailModel sending(EmailDTO emailDTO) {
        EmailModel emailModel = this.restTemplateConfig.restTemplate().postForObject(getBaseUrl() + "/api/email/sending", emailDTO, EmailModel.class);
        return emailModel;
    }

    private String getBaseUrl() {
        ServiceInstance instance = this.loadBalancerClient.choose("EMAIL");
        return instance.getUri().toString();
    }

}
