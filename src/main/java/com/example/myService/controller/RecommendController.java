package com.example.myService.controller;

import com.example.myService.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recommend")
public class RecommendController {
    @Autowired
    private ResultService resultService;

    @GetMapping("/want")
    public String wantr(Model model) {
        return "/recommend/want";
    }

    @GetMapping("/result")
    public String result(Model model) {
        String answer = resultService.result();
        model.addAttribute("answer", answer);
        return "/recommend/result";
    }

    @PostMapping("/recommendprocess")
    public String wantpro(int kind, int time, int love) {
        resultService.forResult(kind, time, love);
        return "redirect:/recommend/result";
    }
}
