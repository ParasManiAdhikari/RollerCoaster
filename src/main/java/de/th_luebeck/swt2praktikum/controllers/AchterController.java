package de.th_luebeck.swt2praktikum.controllers;

import java.util.ArrayList;
import java.util.List;

import de.th_luebeck.swt2praktikum.entities.Achterbahn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AchterController {
    //rating List
    private static List<String> ratings = null;
    static{
        ratings = new ArrayList<>();
        ratings.add("⭐");
        ratings.add("⭐⭐");
        ratings.add("⭐⭐⭐");
        ratings.add("⭐⭐⭐⭐");
        ratings.add("⭐⭐⭐⭐⭐");
    }

    @GetMapping(path = "/employee")
    private String getEmployeeForm(Model model) {
        model.addAttribute("ratings", ratings);
        return "employee-form";
    }

    @PostMapping(path = "/employee")
    private String submitEmployee(@ModelAttribute("employeeForm") Achterbahn achterbahn, Model model) {
        model.addAttribute("employee", achterbahn);

        return "Sucess";
    }
}