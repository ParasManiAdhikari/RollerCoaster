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
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AchterbahnController {

    @Autowired
    private AchterbahnRepository achterbahnRepository;

    List<Achterbahn> achterbahns;

    @GetMapping(value = "/addachterbahn")
    public String addAchterbahn(Model model) {
        model.addAttribute("AchterbahnInput", new AchterbahnInput());
        return "achterbahnErstellen";
    }

    @PostMapping(value = "/addachterbahn")
    public String addAchterbahn(@Valid @ModelAttribute("AchterbahnInput") AchterbahnInput achterbahnInput, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addachterbahn";
        }
        Achterbahn achterbahn = new Achterbahn();
        achterbahn.setName(achterbahnInput.getName());
        achterbahnRepository.save(achterbahn);
        return "redirect:/allAchterbahns";
    }


    public AchterbahnController(AchterbahnRepository achterbahnRepository) {
        this.achterbahnRepository = achterbahnRepository;




      /**  this.achterbahns = new LinkedList<Achterbahn>();

        Achterbahn achterbahn = new Achterbahn("Berlin Achterbahn");
        achterbahn.setId(1);
        this.achterbahns.add(achterbahn);

        achterbahn = new Achterbahn("Luebeck Achterbahn");
        achterbahn.setId(2);
        this.achterbahns.add(achterbahn);

        achterbahn = new Achterbahn("Darmstat Achterbahn");
        achterbahn.setId(3);
        this.achterbahns.add(achterbahn);

        achterbahn = new Achterbahn("Dusseldorf Achterbahn");
        achterbahn.setId(4);
        this.achterbahns.add(achterbahn);

        achterbahn = new Achterbahn("Hessen Achterbahn");
        achterbahn.setId(5);
        this.achterbahns.add(achterbahn);
       */
    }

    /**
     * return list of Achterbahn.
     *
     * @param model for linking a class which contains the achterbahns output
     * @return name of .html file
     */
    @GetMapping("/allAchterbahns")
    public String getAllAchterbahns(Model model){
        achterbahns = achterbahnRepository.findAll();
        model.addAttribute("achterbahns", achterbahns);
        model.addAttribute("achterbahn", new Achterbahn());

        return "AchterbahnAnzeigen";
    }

    /**
     * return Achterbahn.
     *
     * @param model for linking a class which contains the achterbahn output
     * @param id  the achterbahn's id
     * @return name of .html file
     */
    @GetMapping("/Achterbahndeteils/{id}")
    public String Achterbahndeteils(@PathVariable("id") long id, Model model){
        Long _id = achterbahns.get((int) (id-1)).getId();
        String _name = achterbahns.get((int) (id-1)).getName();
        model.addAttribute("id", _id);
        model.addAttribute("name", _name);
        return "Achterbahndeteil";
    }

    /**
     * return Achterbahn.
     *
     * @param model for linking a class which contains the achterbahn output
     * @param achterbahn  the achterbahn's we want to search by its name
     * @return name of .html file
     */
    @PostMapping(value = "/search")
    public String searchCarByName(@ModelAttribute("achterbahn") Achterbahn achterbahn, Model model) {
        List<Achterbahn> _achterbahns = new LinkedList<>();
        if(achterbahns.size() > 0)
            _achterbahns = achterbahns.stream().filter(a -> a.getName().toLowerCase().
                    contains(achterbahn.getName().toLowerCase())
            ).collect(Collectors.toList());
        model.addAttribute("achterbahns", _achterbahns);

        return "AchterbahnAnzeigen";

    }





}




