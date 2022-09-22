package com.owl.securityjwt;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "Home Page";
    }

    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER')")
    public String profile() {
        return "profile page";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "Admin Page";
    }

}
