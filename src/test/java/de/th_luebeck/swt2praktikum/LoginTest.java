package de.th_luebeck.swt2praktikum.controllers.Login;

import de.th_luebeck.swt2praktikum.controllers.registration.RegistrationInput;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LoginTest {

    @Test
    public void testConstructor() {
        LoginInput input = new LoginInput();
        assertNotNull(input);
    }

    @Test
    public void testSetterAndGetter() {
        LoginInput input = new LoginInput();
        input.setUserName("username");
        input.setUserPassword("password");
        assertEquals("username", input.getUserName());
        assertEquals("password", input.getUserPassword());
    }

}
