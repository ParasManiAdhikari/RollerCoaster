package de.th_luebeck.swt2praktikum;

import de.th_luebeck.swt2praktikum.controllers.Login.LoginController;
import de.th_luebeck.swt2praktikum.controllers.Login.LoginInput;
import de.th_luebeck.swt2praktikum.controllers.registration.RegistrationController;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import de.th_luebeck.swt2praktikum.controllers.registration.RegistrationInput;
import de.th_luebeck.swt2praktikum.entities.User;
import de.th_luebeck.swt2praktikum.repositories.UserRepository;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest

public class AnmeldenTest {

}
