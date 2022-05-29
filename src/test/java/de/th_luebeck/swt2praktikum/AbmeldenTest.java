package de.th_luebeck.swt2praktikum;

import de.th_luebeck.swt2praktikum.controllers.UserController;
import de.th_luebeck.swt2praktikum.entities.User;
import de.th_luebeck.swt2praktikum.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AbmeldenTest{

    private static UserController userController;
    private static UserRepository mockedUserRepository;
    private static BindingResult mockedBindingResult;
    private static Model mockedModel;

    @BeforeEach
    public void setUpUserControllerInstance() {
        mockedUserRepository = mock(UserRepository.class);
        mockedBindingResult = mock(BindingResult.class);
        mockedModel = mock(Model.class);
        userController = new UserController(mockedUserRepository);
    }

    @Test
    void logoutTest() {
        User user = new User("Parasad1", "mypass", "parasad612@gmail.com", "P1^2aras Adhikari");

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(userController.logout2(user, mockedBindingResult, mockedModel)).isEqualTo("redirect:/login");
    }


}