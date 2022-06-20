package com.example.myService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/docs/5.2/dist/css/bootstrap.min.css")
    public String errorset() {
        return "redirect:/";
    }  //로그인시 딱한번만 /docs/5.2/dist/css/bootstrap.min.css 이동되는 이유를 찾지 못하여...
}
