package de.th_luebeck.swt2praktikum.controllers.ParkController;


import de.th_luebeck.swt2praktikum.entities.Park;
import de.th_luebeck.swt2praktikum.repositories.ParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;

/**
 * @autor Baraa Hejazi
 * The type Park controller.
 */
@Controller
public class ParkController {

    @Autowired
    private ParkRepository parkRepository;

    /**
     * Add park string.
     * @autor Baraa Hejazi
     * @param model for linking a class which contains the user input
     * @return name of .html file
     */
    @GetMapping(value = "/addpark")
    public String addPark(Model model) {
        model.addAttribute("ParkInput", new ParkInput());
        return "addpark";
    }


    
}
