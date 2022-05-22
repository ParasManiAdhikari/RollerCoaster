package de.th_luebeck.swt2praktikum.controllers.Achterbahn;

import de.th_luebeck.swt2praktikum.entities.Achterbahn;
import de.th_luebeck.swt2praktikum.repositories.AchterbahnRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class AchterbahnController {

    private final AchterbahnRepository achterbahnRepository;

    public AchterbahnController(AchterbahnRepository achterbahnRepository) {
        this.achterbahnRepository = achterbahnRepository;
    }

    @GetMapping("/achterbahn")
    public String getAchterbahn(Model model) {
        model.addAttribute("Achterbahn", achterbahnRepository.findAll());
        return "achterbahn";
    }

    @PostMapping("/achterbahn/achterbahnErstellen")
    public String achterbahnErstellen(@PathVariable("id") long id, @Valid Achterbahn achterbahn, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "achterbahn";
        }
        achterbahnRepository.save(achterbahn);
        return "redirect:/achterbahn";
    }
}
