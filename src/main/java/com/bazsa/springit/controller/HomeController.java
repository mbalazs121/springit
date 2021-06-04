package com.bazsa.springit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller // dont looking for view
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }
}
