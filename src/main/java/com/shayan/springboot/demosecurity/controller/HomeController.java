package com.shayan.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";

    }

    @GetMapping("/leaders")
    public String leaders() {
        return "leaders";

    }

    @GetMapping("/system")
    public String system() {
        return "system";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "denied";
    }

}
