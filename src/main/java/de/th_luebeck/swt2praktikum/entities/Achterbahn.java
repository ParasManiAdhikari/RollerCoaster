package de.th_luebeck.swt2praktikum.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
public class Achterbahn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotBlank
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public Achterbahn() {

    }

    public Achterbahn(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
}
