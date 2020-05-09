package com.acme.blogging.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private Long dni;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String gender;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private Long phone;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(nullable=false,updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private String address;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String admisssion;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String dentist;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(nullable=false,updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private String date;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String status;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String schedule_date;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String scheduleTime;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String medicalSchool;
}
