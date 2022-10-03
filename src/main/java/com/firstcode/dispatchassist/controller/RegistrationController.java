package com.firstcode.dispatchassist.controller;

import com.firstcode.dispatchassist.model.User;
import com.firstcode.dispatchassist.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/process")
    public String process(@Valid @ModelAttribute("users") User user, BindingResult errors, Model model) {
        String userName = user.getUsername();

        if (errors.hasErrors()) {
            return "registration-form";
        }

        User existing = userService.findByUserName(userName);
        if (existing != null) {
            model.addAttribute("registrationError", "User name already exists.");
            return "registration-form";
        }
        userService.register(user);

        return "registration-confirmation";
    }
}
