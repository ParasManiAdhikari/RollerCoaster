package de.th_luebeck.swt2praktikum.controllers;

import de.th_luebeck.swt2praktikum.entities.User;
import de.th_luebeck.swt2praktikum.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        System.out.println("Deleted User");
        return "redirect:/index";
    }
    public UserController(UserRepository rep) {
    }
//
//    @GetMapping(value ="/kontoansicht")
//    public String ShowKonto() {
//        return "redirect:/kontoansicht/1";
//    }

    @PostMapping(value = "/logout")
    public String logout2(User user, BindingResult mockedBindingResult, Model mockedModel) {
        // log out the user and go to homepage
        return "redirect:/login";
    }



    @GetMapping("/dynamicpark/{id}")
    public String addFahrt(@PathVariable("id") long id, Model model) {

        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);

        user.fahrten = user.fahrten + 1;

        model.addAttribute("user", user);

        System.out.println("added Fahrt");
        return "redirect:/index";
    }

}
