package de.th_luebeck.swt2praktikum;

import de.th_luebeck.swt2praktikum.controllers.UserController;
import de.th_luebeck.swt2praktikum.entities.User;
import de.th_luebeck.swt2praktikum.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AddFahrtTest{

    @Autowired
    private static UserController userController;

    @Test
    void logoutTest() {

        User user = new User("Parasad1", "mypass", "parasad612@gmail.com", "Paras Adhikari");
        Model model = null;

        userController.addFahrt(user.getId(), model);
        assertThat(user.getFahrten() == 1);
    }
}