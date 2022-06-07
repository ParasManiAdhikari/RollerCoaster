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
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class AchterbahnController {

    @Autowired
    private static AchterbahnRepository achterbahnRepository;

    List<Achterbahn> achterbahns;
    Achterbahn currentAchterbahn;

    //rating List
    static List<String> ratings = null;
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
        Achterbahn achter = achterbahnRepository.findAll().get(0);
        achter.setMyrating(achterbahn.getMyrating());
        model.addAttribute("achter", achter);
        return "Sucess";
    }

    public AchterbahnController(AchterbahnRepository mockedAchterbahnRepo){
        this.achterbahnRepository = mockedAchterbahnRepo;
    }

    /**
     * @autor Nitesh Bhattarai
     * to add achterbahn
     */
    @GetMapping(value = "/addachterbahn")
    public String addAchterbahn(Model model) {
        model.addAttribute("AchterbahnInput", new AchterbahnInput());
        return "addachterbahn";
    }

    /**
     * @autor Nitesh Bhattarai
     * to add achterbahn
     */
    @PostMapping(value = "/addachterbahn")
    public String addAchterbahnCheck(@Valid @ModelAttribute("AchterbahnInput") AchterbahnInput achterbahnInput, BindingResult bindingResult, Model model) {
        if (achterbahnRepository.findByName(achterbahnInput.getName()) != null) {
            model.addAttribute("error", "Achterbahn mit diesem Namen existiert bereits");
        } else if (bindingResult.hasErrors()) {
            model.addAttribute("checkallInput", "Bitte alle Felder ausfüllen!");
            return "addachterbahn";
        } else
            return addAchterbahn(achterbahnInput);
        return "redirect:/addachterbahn";
    }

    /**
     * @autor Nitesh Bhattarai
     * to add achterbahn
     */
    public String addAchterbahn(@ModelAttribute("Achterbahninput") AchterbahnInput Achterbahninput) {
        achterbahnRepository.save(new Achterbahn(Achterbahninput.getName()));
        return "redirect:/allAchterbahns";
    }

    /**
     * @autor Paras Adhikari
     * rate achterbahn
     */
    @PostMapping(value = "/submitCoasterRating")
    public String submitRating(Model model) {
        achterbahns = achterbahnRepository.findAll();
        model.addAttribute("achterbahnlist", achterbahns);
        return "myab";
    }

    @GetMapping(value = "/deleteachterbahn/{id}")
    public String deleteAchterbahn(@PathVariable("id") Long id) {
        achterbahnRepository.deleteById(id);
        return "AchterbahnAnzeigen";
    }

    /**
     * @autor Ammar
     * to add achterbahn
     */
    @GetMapping("/allAchterbahns")
    public String getAllAchterbahns(Model model){
        achterbahns = achterbahnRepository.findAll();
        model.addAttribute("achterbahns", achterbahns);
        model.addAttribute("achterbahn", new Achterbahn());
        model.addAttribute("ratings", ratings);

        return "AchterbahnAnzeigen";
    }

    /**
     * @autor Ammar
     * to add achterbahn
     */
    @GetMapping("/Achterbahndetails/{id}")
    public String Achterbahndeteils(@PathVariable("id") long id, Model model){
        Long _id = achterbahns.get((int) (id-1)).getId();
        String _name = achterbahns.get((int) (id-1)).getName();
        model.addAttribute("id", _id);
        model.addAttribute("name", _name);
        return "AchterbahnDeteil";
    }

    /**
     * @autor Ammar
     * to add achterbahn
     */
    @PostMapping(value = "/searchbahn")
    public String searchBahnByName(@ModelAttribute("achterbahn") Achterbahn achterbahn, Model model) {
        List<Achterbahn> _achterbahns = new LinkedList<>();
        if(achterbahns.size() > 0)
            _achterbahns = achterbahns.stream().filter(a -> a.getName().toLowerCase().
                    contains(achterbahn.getName().toLowerCase())
            ).collect(Collectors.toList());
        model.addAttribute("achterbahns", _achterbahns);

        return "AchterbahnAnzeigen";

    }

    /**
     * @autor Ammar
     * to add achterbahn
     */
    @GetMapping("/GetRandomAchterbahn")
    public String getRandomAchterbahn(Model model){
        Random rng = new Random();
        int min = 0;
        int max = achterbahns.size() - 1;
        int upperBound = max - min + 1;
        int randomId = min + rng.nextInt(upperBound);
        Long _id = achterbahns.get(randomId).getId();
        String _name = achterbahns.get(randomId).getName();
        model.addAttribute("id", _id);
        model.addAttribute("name", _name);
        return "AchterbahnDeteil";
    }

    /**
     * @autor Ahmad Alyusef
     * ausgewählte Achterbahn Anzeigen
     */
    @GetMapping("/Achterbahns/{id}")
    public String chosenachterbahn(@PathVariable("id") long myid, Model model) {
        Achterbahn chosenachterbahn = achterbahnRepository.findById(myid).orElseThrow(() -> new IllegalArgumentException("Invalid Rollercoaster Id:" + myid));
        model.addAttribute("ratingss", ratings);
        currentAchterbahn = chosenachterbahn;
        model.addAttribute("myachterbahn", chosenachterbahn);
        return "dynamicachterbahn";
    }

    @PostMapping(path = "/saverating")
    private String submitAchterbahn(@ModelAttribute("achterbahnForm") Achterbahn achterbahn, Model model) {
        model.addAttribute("employee", achterbahn);
        currentAchterbahn.setMyrating(achterbahn.getMyrating());
        model.addAttribute("ratedAB", currentAchterbahn);
        achterbahnRepository.save(currentAchterbahn);
        return "redirect:/allAchterbahns";
    }






}




