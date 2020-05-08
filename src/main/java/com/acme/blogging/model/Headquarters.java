package com.acme.blogging.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "headquarters")
@Getter
@Setter
public class Headquarters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;



    @Column(name = "Name",length = 30,nullable = false)
    private String nameheadquaters;

    @Column(name = "Address",length = 60,nullable = false)
    private String adressheadquarters;

}
