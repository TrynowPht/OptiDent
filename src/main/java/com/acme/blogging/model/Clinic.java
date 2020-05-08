package com.acme.blogging.model;

import javax.persistence.*;

@Entity
@Table(name = "clinics")
public class Clinic  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Clinic Name",length = 30,nullable = false)
    private String clinicname;

    @Column(name = "Quantity Dentist",nullable = false)
    private long quantitydentist;

}
