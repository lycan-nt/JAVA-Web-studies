package com.owl.clientemail.controllers;

import com.owl.clientemail.models.UserModel;
import com.owl.clientemail.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserModel> save(@RequestBody @Valid UserModel userModel) {
        this.userService.save(userModel);
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }

}
