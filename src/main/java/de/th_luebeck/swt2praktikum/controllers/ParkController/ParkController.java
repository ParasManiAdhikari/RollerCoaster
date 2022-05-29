package de.th_luebeck.swt2praktikum.controllers.ParkController;


import de.th_luebeck.swt2praktikum.entities.Achterbahn;
import de.th_luebeck.swt2praktikum.entities.Park;
import de.th_luebeck.swt2praktikum.repositories.ParkRepository;
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

/**
 * @autor Baraa Hejazi
 * The type Park controller.
 */
@Controller
public class ParkController {

    @Autowired
    private ParkRepository parkRepository;

    List<Park> parks;

    public ParkController(ParkRepository mockedParkRepository) {
        this.parkRepository = mockedParkRepository;
    }


    /**
     * Add park string.
     * @autor Baraa Hejazi
     * @param model for linking a class which contains the user input
     * @return name of .html file
     */
    @GetMapping(value = "/addpark")
    public String addPark(Model model) {
        model.addAttribute("Parkinput", new ParkInput());
        return "addpark";
    }


    /**
     * Add park check string.
     * @autor Baraa Hejazi
     * @param Parkinput     the parkinput
     * @param bindingResult the binding result
     * @param model         the model
     * @return the string
     */
    @PostMapping(value ="/addpark")
    public String addParkCheck(@Valid @ModelAttribute("Parkinput") ParkInput Parkinput, BindingResult bindingResult, Model model) {
        if (parkRepository.findByName(Parkinput.getName()) != null) {
            model.addAttribute("notAvailablename", "name bereits vergeben");
            return "/addpark";
        }

        else if (parkRepository.findByEmail(Parkinput.getEmailadress()) != null) {
            model.addAttribute("notAvailableEmail", "Email bereits vergeben");
            return "/addpark";
        }


        else if (bindingResult.hasErrors()) {
            model.addAttribute("checkallInput", "Alle Pflichtfelder müssen ausgefüllt werden");
            return "/addpark";
        }

        else if (Parkinput.getName().isEmpty()
                || Parkinput.getEmailadress().isEmpty()
                || Parkinput.getAdresse().isEmpty()
                || Parkinput.getFaxnummer().isEmpty()
                || Parkinput.getTelefonnummer().isEmpty()) {
            model.addAttribute("checkallInput", "Alle Pflichtfelder müssen ausgefüllt werden");
            return "/addpark";
        }
        else
        return addPark(Parkinput);
    }


    /**
     * @autor Baraa Hejazi
     * help function to save the new park
     * @param Parkinput the parkinput
     * @return the string
     */
    public String addPark(@ModelAttribute("Parkinput") ParkInput Parkinput) {
        parkRepository.save(new Park(Parkinput.getName(),
                        Parkinput.getEmailadress(), Parkinput.getAdresse(),
                Parkinput.getFaxnummer(),Parkinput.getTelefonnummer()));
        return "redirect:/showparks";
    }


    /**
     * @autor Paras Adhikari
     * to show list of all parks
     */
    @GetMapping("/showparks")
    public String showParks(Model model){
        parks = parkRepository.findAll();
        model.addAttribute("allparks", parks);
        model.addAttribute("mypark", new Park());
        return "parks";
    }

    /**
     * @autor Paras Adhikari
     * return searched Park.
     */
    @PostMapping(value = "/search")
    public String searchParkByName(@ModelAttribute("mypark") Park mypark, Model model) {
        List<Park> _parks = new LinkedList<>();
        if(parks.size() > 0)
            _parks = parks.stream().filter(a -> a.getName().toLowerCase().
                    contains(mypark.getName().toLowerCase())
            ).collect(Collectors.toList());
        model.addAttribute("allparks", _parks);

        return "parks";

    }

    /**
     * @autor Paras Adhikari
     * to show the clicked park
     */
    @GetMapping("/parks/{id}")
    public String chosenPark(@PathVariable("id") long myid, Model model){
        Park chosenpark = parkRepository.findById(myid).orElseThrow(() -> new IllegalArgumentException("Invalid park Id:" + myid));
        model.addAttribute("mypark", chosenpark);
        return "dynamicpark";
    }


}
