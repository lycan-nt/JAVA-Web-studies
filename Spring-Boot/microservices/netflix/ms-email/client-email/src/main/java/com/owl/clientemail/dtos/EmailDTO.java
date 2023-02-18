package com.owl.clientemail.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
public class EmailDTO {

    @NotBlank
    private String ownerRef;
    @NotBlank
    @Email
    private String emailFrom;
    @Email
    @NotBlank
    private String emailTo;
    @NotBlank
    private String subject;
    @NotBlank
    private String text;

    public EmailDTO(String ownerRef, String emailFrom, String emailTo, String subject, String text) {
        this.ownerRef = ownerRef;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
    }

}
