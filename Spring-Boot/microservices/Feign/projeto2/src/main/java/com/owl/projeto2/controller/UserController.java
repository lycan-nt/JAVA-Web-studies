package com.owl.projeto2.controller;

import com.owl.projeto2.model.User;
import com.owl.projeto2.webserver.UserEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserEndPoint userEndPoint;

    @GetMapping
    public User getUser() {
        return userEndPoint.getUser();
    }

}
