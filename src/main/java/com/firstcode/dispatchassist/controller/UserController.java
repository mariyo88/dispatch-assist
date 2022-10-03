package com.firstcode.dispatchassist.controller;

import com.firstcode.dispatchassist.model.User;
import com.firstcode.dispatchassist.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Log4j2
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService service;
    private static final String USERS = "users";

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("")
    public String getAllUsers(Model model) {
        model.addAttribute(USERS, service.findAll());
        return "view/user";
    }

    @GetMapping("/update")
    public String createUser(Model model, @RequestParam("id") Long id) {
        User user = service.findById(id);
        model.addAttribute("user", user);
        log.debug("Return user {}", user.toString());
        return "view/users-form";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        service.deleteById(id);
        return "redirect:";
    }

    @GetMapping("/form")
    public String updateUser(Model model) {
        model.addAttribute(USERS, User.builder().build());
        return "view/users-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("users") User user) {
        service.save(user);
        return "redirect:/user";
    }
}
