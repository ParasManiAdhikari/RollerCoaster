package de.th_luebeck.swt2praktikum.controllers.Achterbahn;

import de.th_luebeck.swt2praktikum.entities.Achterbahn;
import de.th_luebeck.swt2praktikum.repositories.AchterbahnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AchterbahnController {

    @Autowired
    private AchterbahnRepository achterbahnRepository;


    @GetMapping(value = "/addachterbahn")
    public String addachterbahn(Model model) {
        model.addAttribute("AchterbahnInput", new AchterbahnInput());
        return "addachterbahn";
    }


    @PostMapping(value = "/addachterbahn")
    public String addAchterbahnCheck(@Valid @ModelAttribute("AchterbahnInput") AchterbahnInput achterbahnInput, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/addachterbahn";
        }
        else
            return addachterbahn(achterbahnInput);
    }

    public String addachterbahn(@ModelAttribute("AchterbahnInput") AchterbahnInput achterbahnInput) {
        Achterbahn achterbahn = new Achterbahn();
        achterbahn.setName(achterbahnInput.getName());
        achterbahnRepository.save(achterbahn);
        return "redirect:/dashboard";
    }


}
