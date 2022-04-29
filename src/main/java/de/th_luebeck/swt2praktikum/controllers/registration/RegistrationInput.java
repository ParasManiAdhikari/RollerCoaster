package de.th_luebeck.swt2praktikum.controllers.registration;

import javax.validation.constraints.*;

/** Autor : Baraa Hejazi
 * class to store and accsess the user input from webinterface
 */
public class RegistrationInput {

    /**
     * create variables with validation rules
     */
    @NotNull
    private String name;
    @NotNull
    @Size(min = 8, message = "Benutzername zu kurz, mindestens 8 Zeichen")
    private String userName;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}].:;',?/*~$^+=<>]).{8,}$", message = "Benutzer-Passwort entspricht nicht den Anforderungen")
    private String password;
    @NotNull
    private String passwordConfirm;
    @NotNull
    @Email
    @Pattern(regexp = ".+@.+\\..+", message = "E-Mail-Adresse ist nicht gültig")
    private String emailAddress;
    @NotNull
    @AssertTrue(message = "Nutzungsbedingungen muss zugestimmt werden")
    private boolean checkbox;

    public RegistrationInput() {
    }

    public RegistrationInput(String name, String userName, String password, String passwordConfirm, String emailAddress, boolean checkbox) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.emailAddress = emailAddress;
        this.checkbox = checkbox;
    }



    public RegistrationInput(String userInput, String passInput, String passConfirm, String emailInput, boolean check) {
        this.userName = userInput;
        this.password = passInput;
        this.passwordConfirm = passConfirm;
        this.emailAddress = emailInput;
        this.checkbox = check;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean newCheck) {
        this.checkbox = newCheck;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

}
