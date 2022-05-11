package de.th_luebeck.swt2praktikum;

import de.th_luebeck.swt2praktikum.controllers.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class DeleteUserTest {

    @Autowired
    private UserController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }


    // user1 = new User(id =123)
    // assertthat(delete(user1).isEmpty())


}
