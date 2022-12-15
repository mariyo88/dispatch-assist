package com.firstcode.dispatchassist.controller;

import com.firstcode.dispatchassist.model.Driver;
import com.firstcode.dispatchassist.model.User;
import com.firstcode.dispatchassist.service.DriverService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/driver")
public class DriverController {

    private final DriverServic service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @GetMapping("")
    public String getAllDrivers(Model model) {
        model.addAttribute("drivers", service.findAll());
        model.addAttribute("posts", service.findPage(5, 3));
        return "view/driver";
    }

    @GetMapping("update")
    public String getDriver(Model model, @RequestParam("id") Long id) {
        Driver byId = service.findById(id);

        //byId.setLastName(TimeUnit.MILLISECONDS.toHours(new Date().getTime() - byId.getModified().getTime()) + " hours ago");

        model.addAttribute("driver", byId);
        return "view/driver-form";
    }

    @PostMapping("/process")
    public String process(@Valid @ModelAttribute("driver") Driver driver,
                          BindingResult errors, Model model) {

//        String userName = user.getUsername();
//
//        if (errors.hasErrors()) {
//            return "registration-form";
//        }
//
//        User existing = userService.findByUserName(userName);
//        if (existing != null) {
//            model.addAttribute("registrationError", "User name already exists.");
//            return "registration-form";
//        }
        service.save(driver);

        return "redirect:/owner";
    }

//    @GetMapping("/listDrivers")
//    public String listDrivers(Model model,
//                              @RequestParam("page") Optional<Integer> page,
//                              @RequestParam("size") Optional<Integer> size) {
//
//        int currentPage = page.orElse(1);
//        int pageSize = size.orElse(5);
//
//        Page<Driver> driverPage = service.findPaginated(PageRequest.of(currentPage - 1, pageSize));
//        model.addAttribute("driverPage", driverPage);
//
//        int totalPages = driverPage.getTotalPages();
//        if (totalPages > 0) {
//            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
//                    .boxed()
//                    .collect(Collectors.toList());
//            model.addAttribute("pageNumbers", pageNumbers);
//        }
//
//        return "view/pageDrivers";
//    }

    @GetMapping("/about")
    public String posts(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                        @RequestParam(value = "size", required = false, defaultValue = "2") int size, Model model) {
        model.addAttribute("posts", service.findPage(pageNumber, size));
        return "view/test";
    }

    @GetMapping("/edit")
    public String profileEdit() {
        return "view/profile-edit";
    }
}
