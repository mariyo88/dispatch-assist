package com.firstcode.dispatchassist.controller;

import com.firstcode.dispatchassist.model.Load;
import com.firstcode.dispatchassist.service.DriverService;
import com.firstcode.dispatchassist.service.LoadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoadController {

    private final LoadService service;
    private final DriverService driverService;

    public LoadController(LoadService service, DriverService driverService) {
        this.service = service;
        this.driverService = driverService;
    }

    @GetMapping("/loads")
    public String getAllLoads(Model model) {
        model.addAttribute("loads", service.findAll());
        model.addAttribute("drivers", driverService.findAll());
        return "view/loads";
    }


    @GetMapping("/load/form")
    public String updateLoad(Model model) {
        model.addAttribute("load", Load.builder().build());
        return "load-form";
    }

    @GetMapping("/load/form-update")
    public String createLoad(Model model, @RequestParam("id") Long id) {
        model.addAttribute("load", service.findById(id));
        return "load-form";
    }

    @GetMapping("/load/delete")
    public String deleteLoad(@RequestParam("id") Long id) {
        service.deleteById(id);
        return "redirect:/load";
    }

    @PostMapping("/load/save")
    public String saveUser(@ModelAttribute("load") Load load) {
        service.save(load);
        return "redirect:/load";
    }
}
