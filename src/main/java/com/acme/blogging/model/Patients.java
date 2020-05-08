package com.acme.blogging.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
//Table(name="patients")
@Getter
@Setter
public class Patients extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String lastName;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private Integer dni;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String sex;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private Long  phone;
}
