package com.shokanmyrzaxmet.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MistController {
    @GetMapping("/mist")
    public String mainController(){

        return "heroes.html";
    }
}
