package com.acme.blogging.model;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = " Appointment")
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @Lob
    @DateTimeFormat
    public Date Fecha;

    @NotNull
    @Lob
    @DateTimeFormat
    public Time Hora;

    @NotNull
    @Lob
    public String status;





}


