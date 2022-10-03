package com.firstcode.dispatchassist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScheduledController {

    @GetMapping("scheduled")
    public String getScheduled() {
        return "view/scheduled";
    }
}
