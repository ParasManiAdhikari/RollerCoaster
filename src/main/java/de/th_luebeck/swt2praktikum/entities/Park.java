package de.th_luebeck.swt2praktikum.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Park {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @Column(name = "Email")
    @NotBlank
    @Email(message = "real e-mail adress required")
    private String email;

    @Column(name = "strasse")
    private String strasse;

    @Column(name = "land")
    private String land;

    @Column(name = "ort")
    private String ort;

    @Column(name = "phone")
    @Pattern(regexp = "\\d{9}")
    private String phone;

    @Column(name = "fax")
    private String fax;


    private String betreiber;

    private String offnungzeiten;

    private String websitelink;

    private long besucherzahlen;

    private String eroffnung;

    private long flaeche;

    private String besondereEvent;

    private String kurzBeschreibung;



    public Park() {
    }

    public Park(@NotBlank(message = "Name is mandatory") String name) {
        this.name = name;
    }

    public String getBetreiber() {
        return betreiber;
    }

    public void setBetreiber(String betreiber) {
        this.betreiber = betreiber;
    }

    public String getOffnungzeiten() {
        return offnungzeiten;
    }

    public void setOffnungzeiten(String offnungzeiten) {
        this.offnungzeiten = offnungzeiten;
    }

    public String getWebsitelink() {
        return websitelink;
    }

    public void setWebsitelink(String websitelink) {
        this.websitelink = websitelink;
    }

    public long getBesucherzahlen() {
        return besucherzahlen;
    }

    public void setBesucherzahlen(long besucherzahlen) {
        this.besucherzahlen = besucherzahlen;
    }

    public String getEroffnung() {
        return eroffnung;
    }

    public void setEroffnung(String eroffnung) {
        this.eroffnung = eroffnung;
    }

    public long getFlaeche() {
        return flaeche;
    }

    public void setFlaeche(long flaeche) {
        this.flaeche = flaeche;
    }

    public String getBesondereEvent() {
        return besondereEvent;
    }

    public void setBesondereEvent(String besondereEvent) {
        this.besondereEvent = besondereEvent;
    }

    public String getKurzBeschreibung() {
        return kurzBeschreibung;
    }

    public void setKurzBeschreibung(String kurzBeschreibung) {
        this.kurzBeschreibung = kurzBeschreibung;
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

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
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
