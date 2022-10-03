package com.firstcode.dispatchassist.controller;

import com.firstcode.dispatchassist.model.User;
import com.firstcode.dispatchassist.service.DriverService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final DriverService service;

    public LoginController(DriverService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

    @GetMapping("/register")
    public String add(Model theModel) {
        theModel.addAttribute("user", User.builder().build());
        return "registration-form";
    }

    @GetMapping("/owner")
    public String posts(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                        @RequestParam(value = "size", required = false, defaultValue = "10") int size, Model model) {
        model.addAttribute("drivers", service.findPage(pageNumber, size));
        return "owner1";
    }
}
