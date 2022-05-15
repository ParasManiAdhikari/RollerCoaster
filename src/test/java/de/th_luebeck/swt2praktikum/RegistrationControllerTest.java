package de.th_luebeck.swt2praktikum;

import de.th_luebeck.swt2praktikum.controllers.registration.RegistrationController;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import de.th_luebeck.swt2praktikum.controllers.registration.RegistrationInput;
import de.th_luebeck.swt2praktikum.entities.User;
import de.th_luebeck.swt2praktikum.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Baraa
 * A test for creating and saving object in database
 * An user obgect should be created and saved in database.
 * The created user should match the user inputs
 */
@AutoConfigureMockMvc
@SpringBootTest
public class RegistrationControllerTest {


    @Autowired
    private RegistrationController registrationController;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc mock;

    /**
     *
     * A parameterized junit test is called here by using a csv file with the required input data.
     * The csv file is stored in the ./src/test/resources folder and contains the parameters below.
     * @param username the given username as String
     * @param password the given password as String
     * @param passwordConfirm the given password confirm as a string
     * @param email the given Email as String
     * @param checkbox assuming that the user had accepted the terms of use as boolean
     */
    @ParameterizedTest(name = "{index}:name: {0}, Username: {1}, password: {2}, passwordConfirm{3}, email: {4}, checkbox{5}")
    @CsvFileSource(resources = "/registrationTestInput.csv", numLinesToSkip = 1)
    @DisplayName("User instantiation test")
    public void testUserRegistration(String name,String username, String password, String passwordConfirm, String email, boolean checkbox) {
        RegistrationInput registrationInput = new RegistrationInput(name,username, password, passwordConfirm, email, checkbox);
        registrationController.registration(registrationInput);
        User savedUser = userRepository.findByUserName(registrationInput.getUserName());
        /*
         *  BCryptPasswordEncoder object to compare the encrypted password in the database
         *  with the given password
         */
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        boolean isPasswordMatches = bcrypt.matches(registrationInput.getPassword(), savedUser.getPassword());
        assertNotNull(savedUser);
        assertTrue(isPasswordMatches);
        assertEquals(registrationInput.getUserName(), savedUser.getUserName());
        assertEquals(registrationInput.getEmailAddress(), savedUser.getEmail());
    }

}
