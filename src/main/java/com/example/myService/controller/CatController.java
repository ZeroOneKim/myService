package com.example.myService.controller;

import com.example.myService.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cat")
public class CatController {


    @GetMapping("/catlist")
    public String list(Model model) {
        return "cat/catlist";
    }
}
