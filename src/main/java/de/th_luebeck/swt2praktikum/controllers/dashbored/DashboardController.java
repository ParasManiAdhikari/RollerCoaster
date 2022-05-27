package de.th_luebeck.swt2praktikum.controllers.dashbored;

import org.springframework.web.bind.annotation.GetMapping;

public class DashboardController {
    @GetMapping(value ="/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/parks/index")
    public String returnIndexfromPark() {
        return "redirect:/index";
    }
    @GetMapping("/parks/parks")
    public String redirectToPark() {
        return "redirect:/showparks";
    }
}
