package com.example.myService.controller;

import com.example.myService.entity.Cat;
import com.example.myService.entity.Inquire;
import com.example.myService.entity.User;
import com.example.myService.repository.CatRepository;
import com.example.myService.repository.InquireRepository;
import com.example.myService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/admin/manage")
public class ManageController {
    @Autowired
    private InquireRepository inquireRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CatRepository catRepository;

    @GetMapping("/inquire")
    public String inquire(Model model) {
        List<Inquire> inquires = inquireRepository.findAll();
        List<User> user = userRepository.findAll();
        List<Cat> cat = catRepository.findAll();
        model.addAttribute("inquires", inquires);
        model.addAttribute("cat", cat);
        model.addAttribute("user", user);

        return "/admin/manage/inquire";
    }
}
