package com.acme.blogging.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="patient")
@Getter
@Setter
@Data
public class Patient extends AuditModel{
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
    private Long  phone;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String  ocupation;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String  civilState;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(nullable=false,updatable=false)
    @Temporal (TemporalType.TIMESTAMP)
    private String birth;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(nullable=false,updatable=false)
    @Temporal (TemporalType.TIMESTAMP)
    private String inscription;

    @NotNull
    @NotBlank
    @Column(nullable=false)
    private String email;
}
