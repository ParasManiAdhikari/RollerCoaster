package de.th_luebeck.swt2praktikum;

import de.th_luebeck.swt2praktikum.controllers.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import de.th_luebeck.swt2praktikum.controllers.registration.RegistrationInput;
import de.th_luebeck.swt2praktikum.entities.User;
import de.th_luebeck.swt2praktikum.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class DeleteUserTest {

    @Autowired
    private UserController controller;

    @Test
    public void contextLoads() throws Exception {
        //   assertThat(controller).isNotNull(); asd
    }
    @Autowired
    private UserRepository userRepository;

    @Test
    public void DeleteUserTest(){

        List<User> users = new ArrayList<>();
        users = (List<User>) userRepository.findAll(); // Sie können diese Zeile löschen

        RegistrationInput registrationInput = new RegistrationInput("salemSalem2","ahmedahmed2", "MyPassword12$", "MyPassword12$", "myEmail2@gmail.com", false);

        User user = new User(registrationInput.getUserName(),
                BCrypt.hashpw(registrationInput.getPassword(), BCrypt.gensalt()),
                registrationInput.getEmailAddress(),registrationInput.getName());

        User _user = userRepository.save(user);

        users = (List<User>) userRepository.findAll(); // Sie können diese Zeile löschen

//        assertThat(_user.getUserName()).isSameAs(registrationInput.getUserName());

        userRepository.delete(_user);

        users = (List<User>) userRepository.findAll(); // Sie können diese Zeile löschen

        Optional<User> u = userRepository.findById(_user.getId());

        assertEquals(u.toString(), "Optional.empty");

    }

}