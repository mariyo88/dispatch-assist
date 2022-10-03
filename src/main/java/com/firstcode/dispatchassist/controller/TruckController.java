package com.firstcode.dispatchassist.controller;

import com.firstcode.dispatchassist.service.TruckService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TruckController {

    private final TruckService service;

    public TruckController(TruckService service) {
        this.service = service;
    }

    @GetMapping("/trucks")
    public String getAllTrucks(Model model) {
        model.addAttribute("trucks", service.findAll());
        return "view/trucks";
    }
}
