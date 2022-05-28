package de.th_luebeck.swt2praktikum.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Data
@Table(name = "tbl_Park")
public class Park {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name",nullable = false, unique = true)
    private String name;

    @Column(name = "Email",nullable = false, unique = true)
    @NotBlank
    @Email(message = "real e-mail adress required")
    private String email;

    @Column(name = "adress",nullable = false)
    private String adress;


    @Column(name = "phone",nullable = false)
    private String phone;

    @Column(name = "fax",nullable = false)
    private String fax;


    /*private String betreiber;

    private String offnungzeiten;

    private String websitelink;

    private long besucherzahlen;

    private String eroffnung;

    private long flaeche;

    private String besondereEvent;

    private String kurzBeschreibung;
*/


    public Park() {
    }

    public Park(@NotBlank(message = "Name is mandatory") String name) {
        this.name = name;
    }

    public Park(String name, String email, String adresse, String faxnummer, String telefonnummer) {
        this.name = name;
        this.email = email;
        this.adress = adresse;
        this.fax = faxnummer;
        this.phone = telefonnummer;
    }
}
