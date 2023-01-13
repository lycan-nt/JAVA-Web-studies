package com.owl.projeto2.webserver;

import com.owl.projeto2.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "User", url = "http://localhost:8080/api/user")
public interface UserEndPoint {

    @RequestMapping(method = RequestMethod.GET, value = "")
    User getUser();

}
