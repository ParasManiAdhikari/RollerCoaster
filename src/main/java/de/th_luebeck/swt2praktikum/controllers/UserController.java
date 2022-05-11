package de.th_luebeck.swt2praktikum.controllers;

import de.th_luebeck.swt2praktikum.entities.User;
import de.th_luebeck.swt2praktikum.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository rep) {
    }

    @PostMapping(value = "/logout")
    public String logout(User user, BindingResult mockedBindingResult, Model mockedModel) {
        // log out the user and go to homepage
        return "redirect:/index";
    }
}
