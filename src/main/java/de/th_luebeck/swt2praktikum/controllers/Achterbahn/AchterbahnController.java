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
    public String addAchterbahn(Model model) {
        model.addAttribute("AchterbahnInput", new AchterbahnInput());
        return "AchterbahnErstellen";
    }

    @PostMapping(value = "/addachterbahn")
    public String addAchterbahnCheck(@Valid @ModelAttribute("AchterbahnInput") AchterbahnInput achterbahnInput, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("checkallInput", "Bitte alle Felder ausfüllen!");
            return "addachterbahn";
        }
        else
            return addAchterbahn(achterbahnInput);
    }

    public String addAchterbahn(@ModelAttribute("Achterbahninput") AchterbahnInput Achterbahninput) {
        achterbahnRepository.save(new Achterbahn(Achterbahninput.getName()));
        return "/index";
    }

    @GetMapping(value = "/deleteachterbahn/{id}")
    public String deleteAchterbahn(@PathVariable("id") Long id) {
        achterbahnRepository.deleteById(id);
        return "/index";
    }
}






