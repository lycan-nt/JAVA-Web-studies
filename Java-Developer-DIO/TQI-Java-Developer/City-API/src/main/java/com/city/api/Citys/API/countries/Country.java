package com.city.api.Citys.API.countries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pais")
public class Country {
    @Id
    private long id;

    @Column(name="nome")
    private String name;

    @Column(name="name_pt")
    private String portugueseName;

}
