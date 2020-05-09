package com.acme.blogging.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "districts")
@Getter
@Setter
public class Districts extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Districts Name",length = 30,nullable = false)
    private String districtname;
}
