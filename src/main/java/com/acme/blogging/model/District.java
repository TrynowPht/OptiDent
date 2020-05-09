package com.acme.blogging.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "district")
@Getter
@Setter
public class District extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "District Name",length = 30,nullable = false)
    private String districtname;
}
