package de.th_luebeck.swt2praktikum.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Park {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String email;

    private String address;

    private String phone;

    private String fax;

    public Park() {
    }

    public Park(@NotBlank(message = "Name is mandatory") String name) {
        this.name = name;
    }


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Park setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Park setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Park setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getFax() {
        return fax;
    }

    public Park setFax(String fax) {
        this.fax = fax;
        return this;
    }
}
