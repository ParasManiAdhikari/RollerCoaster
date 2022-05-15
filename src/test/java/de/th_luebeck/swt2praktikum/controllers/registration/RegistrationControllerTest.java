package de.th_luebeck.swt2praktikum;

import de.th_luebeck.swt2praktikum.controllers.UserController;
import de.th_luebeck.swt2praktikum.controllers.registration.RegistrationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import de.th_luebeck.swt2praktikum.controllers.registration.RegistrationInput;
import de.th_luebeck.swt2praktikum.entities.User;
import de.th_luebeck.swt2praktikum.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;


import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest
public class RegistrationControllerTest {


    @Test
    public void contextLoads() throws Exception {
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegistrationController registrationController;

    @Test
    public void registerTest() {

        RegistrationInput registrationInput = new RegistrationInput("testname", "testusername",
                "testPassword12@", "testPassword12@", "testEmail@example.com", true);


        registrationController.registration(registrationInput);


        User user = new User(registrationInput.getUserName(),
                BCrypt.hashpw(registrationInput.getPassword(), BCrypt.gensalt()),
                registrationInput.getEmailAddress(),registrationInput.getName());


        User savedUser = userRepository.save(user);

        assertEquals(registrationInput.getUserName(), savedUser.getUserName());

    }
}
