package de.th_luebeck.swt2praktikum.controllers.registration;

import de.th_luebeck.swt2praktikum.controllers.registration.RegistrationInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationInputTest {

    @Test
    void testUsername() {
        RegistrationInput input = new RegistrationInput();
        input.setUserName("username");
        assertEquals("username", input.getUserName());
    }

    @Test
    void testPassword() {
        RegistrationInput input = new RegistrationInput();
        input.setPassword("123456Weak@Password");
        assertEquals("123456Weak@Password", input.getPassword());
    }

    @Test
    void testPasswordConfirm() {
        RegistrationInput input = new RegistrationInput();
        input.setPasswordConfirm("123456Weak@Password");
        assertEquals("123456Weak@Password", input.getPasswordConfirm());
    }

    @Test
    void testEmail() {
        RegistrationInput input = new RegistrationInput();
        input.setEmailAddress("email@gmail.com");
        assertEquals("email@gmail.com", input.getEmailAddress());
    }

    @Test
    void testName() {
        RegistrationInput input = new RegistrationInput();
        input.setName("Name");
        assertEquals("Name", input.getName());
    }

    @Test
    void testCheckbox() {
        RegistrationInput input = new RegistrationInput();
        input.setCheckbox(true);
        input.isCheckbox();
    }

}

