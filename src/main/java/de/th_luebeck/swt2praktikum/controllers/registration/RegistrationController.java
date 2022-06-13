package de.th_luebeck.swt2praktikum.controllers.registration;

import de.th_luebeck.swt2praktikum.entities.User;
import de.th_luebeck.swt2praktikum.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


/**
 * The type Registration controller.
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Registration check string.
     *
     * @param registrationInput contains the user input from the html form
     * @param bindingResult     check if inputs are allowed                          then able to change inputs at /registration else
     * @param model             connection to registration input class
     * @return redirect to /login
     * @autor Baraa Hejazi
     */
    @PostMapping("/registration")
    public String registrationCheck(@Valid RegistrationInput registrationInput, BindingResult bindingResult, Model model) {
        if (userRepository.findByUserName(registrationInput.getUserName()) != null) {
            model.addAttribute("notAvailableUsername", "Benutzername bereits vergeben");
            return "registration";
        }

        if (userRepository.findByEmail(registrationInput.getEmailAddress()) != null) {
            model.addAttribute("notAvailableEmail", "Email bereits vergeben");
            return "registration";
        }

        if (!(registrationInput.getPassword().equals(registrationInput.getPasswordConfirm()))) {
            model.addAttribute("noPasswordmatchMSG", "Benutzer-Passwörter stimmen nicht überein");
            return "registration";
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("checkallInput", "Alle Pflichtfelder müssen ausgefüllt werden");
            return "registration";
        }

        if (registrationInput.getUserName().isEmpty() || registrationInput.getPassword().isEmpty() ||
                registrationInput.getPasswordConfirm().isEmpty() || registrationInput.getEmailAddress().isEmpty()
                ||registrationInput.getName().isEmpty()) {
            model.addAttribute("checkallInput", "Alle Pflichtfelder müssen ausgefüllt werden");
            return "registration";
        }

        return registration(registrationInput);
    }

    /**
     * Registration string.
     *
     * @param model for linking a class which contains the user input
     * @return name of .html file
     */
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("registrationInput", new RegistrationInput());
        return "registration";
    }


    /**
     * Registration string.
     *
     * @param registrationInput contains the user input from the html form
     * @return redirect to /login
     */

    public String registration(@ModelAttribute("registrationInput") RegistrationInput registrationInput) {
        userRepository.save(new User(registrationInput.getUserName(),
                BCrypt.hashpw(registrationInput.getPassword(), BCrypt.gensalt()),
                registrationInput.getEmailAddress(),registrationInput.getName()));
        return "redirect:/login";
    }
}
