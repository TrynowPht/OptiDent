package com.acme.blogging.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Specialties")
@Getter
@Setter
public class Specialties extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(nullable=false,updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Long ga;



}
