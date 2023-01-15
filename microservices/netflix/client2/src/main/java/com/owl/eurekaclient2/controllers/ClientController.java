package com.owl.eurekaclient2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GetMapping("/callClientTwo")
    public ResponseEntity<String> callSecondClient() throws Exception {
        String client2Response = "Hello Response from client2";
        return new ResponseEntity<>(client2Response, HttpStatus.OK);
    }

}
