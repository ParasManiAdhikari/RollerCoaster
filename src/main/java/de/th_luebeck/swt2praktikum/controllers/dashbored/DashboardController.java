package de.th_luebeck.swt2praktikum.controllers.dashbored;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/parks/index")
    public String returnIndexfromPark() {
        return "redirect:/index";
    }
    @GetMapping("/parks/parks")
    public String redirectToPark() {
        return "redirect:/showparks";
    }
}
