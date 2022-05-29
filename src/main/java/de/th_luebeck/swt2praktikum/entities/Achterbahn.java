package de.th_luebeck.swt2praktikum.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Data
@Table(name = "tbl_achterbahn")
public class Achterbahn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name",nullable = false, unique = true)
    private String name;

    public Achterbahn() {
    }

    public Achterbahn(String name) {
        this.name = name;
    }


}
