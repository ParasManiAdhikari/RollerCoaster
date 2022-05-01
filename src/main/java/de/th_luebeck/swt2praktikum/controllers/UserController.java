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

    @GetMapping("/register")
    public String registerUser(@Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "register";
        }

        userRepository.save(user);
        return "redirect:/index";
    }

}
