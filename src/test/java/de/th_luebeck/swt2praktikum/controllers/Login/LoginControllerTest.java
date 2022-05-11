package de.th_luebeck.swt2praktikum.controllers.Login;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    @Test
    void dashboard() {
        LoginController l = new LoginController();
        String response = l.dashboard();
        assertEquals("kontoansicht", response);
    }
}