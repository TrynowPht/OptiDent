package com.acme.blogging.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "headquarter")
@Getter
@Setter
public class Headquarter extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="post_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private District districts;

    @Column(name = "Name",length = 30,nullable = false)
    private String nameheadquaters;

    @Column(name = "Address",length = 60,nullable = false)
    private String adressheadquarters;

}
