package com.acme.blogging.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
//Table(name="patients")
@Getter
@Setter
public class Patients extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
