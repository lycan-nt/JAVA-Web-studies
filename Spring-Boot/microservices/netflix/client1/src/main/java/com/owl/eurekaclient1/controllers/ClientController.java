package com.owl.eurekaclient1.controllers;

import com.owl.eurekaclient1.configs.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplateConfig restTemplate;

    @GetMapping("/callClientOne")
    public ResponseEntity<String> callFirstClient() throws Exception {
        String client1Response = "Response from client1";
        return new ResponseEntity<>(client1Response, HttpStatus.OK);
    }

    @GetMapping("/callClientTwo")
    public ResponseEntity<String> callSecondClient() throws Exception {
        try {
            return new ResponseEntity<String>(this.restTemplate.restTemplate().getForObject(getBaseUrl() + "/callClientTwo", String.class), HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<String>(this.restTemplate.restTemplate().getForObject(getBaseUrl() + "/callClientTwo", String.class), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String getBaseUrl() {
        ServiceInstance instance = this.loadBalancerClient.choose("CLIENT2");
        return instance.getUri().toString();
    }

}
