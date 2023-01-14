package com.owl.clientemail.services;

import com.owl.clientemail.dtos.EmailDTO;
import com.owl.clientemail.models.UserModel;
import com.owl.clientemail.repositorys.UserRepository;
import com.owl.clientemail.webservers.EmailEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailEndPoint emailSend;
    @Value("${send.email.user}")
    private String email;

    public UserModel save(UserModel userModel) {
        try {
            this.userRepository.save(userModel);
            EmailDTO emailSuccess = buildEmail(true, userModel);
            this.emailSend.sending(emailSuccess);
        } catch (Exception e){
            EmailDTO emailDTOError = buildEmail(false, userModel);
            this.emailSend.sending(emailDTOError);
            throw new Exception("Registration failed: " + e.getMessage());
        } finally {
            return userModel;
        }
    }

    private EmailDTO buildEmail(boolean success, UserModel userModel) {
        return EmailDTO.builder()
                .ownerRef(userModel.getName())
                .emailFrom(this.email)
                .emailTo(userModel.getEmail())
                .subject("Register User")
                .text(success == true ? "Successfully registered" : "Registration failed, please check your details.")
                .build();
    }

}
