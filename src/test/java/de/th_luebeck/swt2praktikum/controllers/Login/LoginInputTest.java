package de.th_luebeck.swt2praktikum.controllers.Login;

import de.th_luebeck.swt2praktikum.controllers.registration.RegistrationInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginInputTest {

    @Test
    void testUsername() {
        LoginInput input = new LoginInput();
        input.setUserName("username");
        assertEquals("username", input.getUserName());
    }

    @Test
    void testPassword() {
        LoginInput input = new LoginInput();
        input.setUserPassword("123456Weak@Password");
        assertEquals("123456Weak@Password", input.getUserPassword());
    }
}