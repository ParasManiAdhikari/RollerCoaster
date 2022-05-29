package de.th_luebeck.swt2praktikum.controllers.Login;

import de.th_luebeck.swt2praktikum.entities.User;
import de.th_luebeck.swt2praktikum.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    public User loggedUser;

    /**
     * @param model connection to user input class
     * @return login.html page
     */
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginInput", new LoginInput());
        return "login";
    }

    /**
     * @author Baraa Hejazi
     * @return login.html page
     */
    @GetMapping("/")
    public String forwardingToLogin() {
        return "redirect:/login";
    }

    /**
     * @param loginInput user input from Login page
     * @param model connection to user input class
     * @return login page or following page
     */
    @PostMapping(value = "/login", params = "submit")
    public String login(@ModelAttribute("loginInput")LoginInput loginInput, Model model, HttpServletRequest request) {
        final User userFound = userRepository.findByUserName(loginInput.getUserName());
        this.loggedUser = userFound;
        final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String result = "redirect:/dashboard";
        if (userFound == null || !encoder.matches(loginInput.getUserPassword(), userFound.getPassword())) {
            model.addAttribute("errorMsg", "Invalid Username or Password");
            result = "login";
        }
        else if (userFound != null && encoder.matches(loginInput.getUserPassword(), userFound.getPassword()) ){
            request.getSession().setAttribute("USER_ID", userFound.getId());
        return "redirect:/index/" + userFound.getId();
        }
        System.out.println(userFound);
            return "login";
    }

    /**
     * @autor Paras Adhikari
     * to greet the user after logged in
     */
    @GetMapping(value ="/index/{id}")
    public String welcome(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("myuser", user);
        return "welcome";
    }

    @ModelAttribute("loggeduser")
    public User user(){
        return loggedUser;
    }

    /**
     * @autor Paras Adhikari
     * to show the account info
     */
    @GetMapping("/kontoansicht")
    public String getUserDetails() {
        return "kontoansicht";
    }

    /**
     * A method to redirect the user to the registration.html
     * @return registration page
     */
    @PostMapping(value = "/login", params = "registration")
    public String goToRegistration() {
        return "redirect:/registration";
    }

    // comment out to use h2 database, other times comment in for logout to work.

    @PostMapping(value = "/logout", params = "submit")
    public String doLogout(){
        return "login";
    }

    @Configuration
    @EnableWebSecurity
    public class SecSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(final HttpSecurity http) throws Exception {
            http.logout();
        }
    }
}
