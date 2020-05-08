package com.acme.blogging.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "clinics")
@Getter
@Setter
public class Clinic  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "Headquarters_id", referencedColumnName = "ID")
    private Headquarters headquarters;


    @Column(name = "Clinic Name",length = 30,nullable = false)
    private String clinicname;

    @Column(name = "Quantity Dentist",nullable = false)
    private long quantitydentist;

}
