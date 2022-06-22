package com.example.myService.controller;

import com.example.myService.entity.Cat;
import com.example.myService.entity.User;
import com.example.myService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/login")
    public String login(Model model) {
        return "account/login";
    }


    @PostMapping("/register")
    public String register(User user) {
        userService.save(user);
        /*if (bindingResult.hasErrors()) {
            return "/account/login";
        }*/
        return "redirect:/";
    }
}
