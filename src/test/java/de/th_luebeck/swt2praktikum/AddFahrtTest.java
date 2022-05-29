package de.th_luebeck.swt2praktikum;

import de.th_luebeck.swt2praktikum.controllers.UserController;
import de.th_luebeck.swt2praktikum.controllers.registration.RegistrationInput;
import de.th_luebeck.swt2praktikum.entities.User;
import de.th_luebeck.swt2praktikum.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
class AddFahrtTest{

    @Autowired
    private UserController controller;
    @Autowired
    private UserRepository userRepository;

    private static Model mockedModel;

    @BeforeEach
    public void setUpUserControllerInstance() {
        mockedModel = mock(Model.class);
    }

    @Test
    void addFahrtTest() {

        RegistrationInput registrationInput = new RegistrationInput("salemSalem2","ahmedahmed2", "MyPassword12$", "MyPassword12$", "myEmail2@gmail.com", false);

        User user = new User(registrationInput.getUserName(),
                BCrypt.hashpw(registrationInput.getPassword(), BCrypt.gensalt()),
                registrationInput.getEmailAddress(),registrationInput.getName());

        User _user = userRepository.save(user);

        assertEquals(_user.getFahrten(), 0);

        controller.addFahrt(_user.getId(), mockedModel);

        assertEquals(_user.getFahrten(), 1);
    }
}