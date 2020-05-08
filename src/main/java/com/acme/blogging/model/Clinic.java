package com.acme.blogging.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "clinic")
@Getter
@Setter
public class Clinic  extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Clinic Name",length = 30,nullable = false)
    private String clinicname;

    @Column(name = "Quantity Dentist",nullable = false)
    private long quantitydentist;

}
