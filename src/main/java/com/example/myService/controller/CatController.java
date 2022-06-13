package com.example.myService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cat")
public class CatController {

    @GetMapping("/catlist")
    public String list() {
        return "cat/catlist";
    }


}
