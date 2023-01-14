package com.owl.clientemail.webservers;

import com.owl.clientemail.dtos.EmailDTO;
import com.owl.clientemail.models.EmailModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "MicroserviceSendEmail", url = "http://localhost:8080/api/email")
public interface EmailEndPoint {

    @RequestMapping(method = RequestMethod.GET, value = "/sending")
    EmailModel sending(EmailDTO email);

}
