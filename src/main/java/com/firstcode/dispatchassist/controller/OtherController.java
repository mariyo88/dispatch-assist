package com.firstcode.dispatchassist.controller;

import com.firstcode.dispatchassist.model.User;
import com.firstcode.dispatchassist.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class OtherController {

    private final UserService userService;

    public OtherController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/settings")
    public String getSettings() {
        return "view/settings";
    }

    @GetMapping("/faqs")
    public String getFaq() {
        return "view/faqs";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "view/about";
    }

    @GetMapping("/profile")
    public String getProfile(Model model, Authentication authentication) {
        String userName = authentication.getName();
        model.addAttribute("user", userService.findByUserName(userName));
        return "view/profile";
    }

    @PostMapping("/profile/process")
    public String process(@Valid @ModelAttribute("users") User user) {
        userService.save(user);
        return "redirect:/profile";
    }
}
