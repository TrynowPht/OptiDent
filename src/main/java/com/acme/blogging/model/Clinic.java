package com.acme.blogging.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "clinics")
@Getter
@Setter
public class Clinic  extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", nullable=false)
    private Headquarters headquarters;

    @Column(name = "Clinic Name",length = 30,nullable = false)
    private String clinicName;

    @Column(name = "Quantity Dentist",nullable = false)
    private long quantityDentist;

}
