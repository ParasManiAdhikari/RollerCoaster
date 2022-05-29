package de.th_luebeck.swt2praktikum.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_fahrt")
public class Fahrt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private long id;



}
