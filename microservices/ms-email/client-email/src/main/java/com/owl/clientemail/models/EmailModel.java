package com.owl.clientemail.models;

import com.owl.clientemail.enums.StatusEmail;
import lombok.Data;
import java.util.Date;

@Data
public class EmailModel {

    private Long emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    private Date sendDateEmail;
    private StatusEmail statusEmail;

}
