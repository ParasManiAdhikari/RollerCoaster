package de.th_luebeck.swt2praktikum.controllers.ParkController;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class ParkInput {

    @NotNull
    @Size(min = 8, message = "Parkname zu kurz, mindestens 8 Zeichen")
    private String name;

    @NotNull
    @Email
    @Pattern(regexp = ".+@.+\\..+", message = "E-Mail-Adresse ist nicht gültig")
    private String emailadress;

    @NotNull
    private String adresse;

    @NotNull
    private String telefonnummer;

    @NotNull
    private String faxnummer;

    public ParkInput() {
    }

    public ParkInput(String name, String email, String address, String fax, String telefon){
        this.name = name;
        this.emailadress = email;
        this.adresse = address;
        this.faxnummer = fax;
        this.telefonnummer = telefon;
    }
   public String getEmail(){
       return this.emailadress;
   }
}
