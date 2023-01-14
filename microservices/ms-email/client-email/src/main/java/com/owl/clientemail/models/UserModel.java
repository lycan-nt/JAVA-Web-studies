package com.owl.clientemail.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;
    private String name;
    private String password;
    private String email;

    public UserModel(Long idUser, String name, String password, String email) {
        this.idUser = idUser;
        this.name = name;
        this.password = password;
        this.email = email;
    }

}
