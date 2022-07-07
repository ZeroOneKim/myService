package com.example.myService.controller;

import com.example.myService.entity.Dog;
import com.example.myService.entity.Inquire;
import com.example.myService.repository.DogRepository;
import com.example.myService.repository.UserRepository;
import com.example.myService.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/dog")
public class DogController {
    @Autowired
    private DogRepository dogRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DogService dogService;
    @GetMapping("/doglist")
    public String doglist(Model model, @PageableDefault(size = 6) Pageable pagealbe) {
        model.addAttribute("dog", dogService.dog(pagealbe));
        String writer = "작성자 : ";
        int startPage = 1;
        model.addAttribute("writer", writer);
        int endPage = dogService.dog(pagealbe).getTotalPages();
        int nowPage = dogService.dog(pagealbe).getPageable().getPageNumber();
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("nowPage", nowPage);
        return "dog/doglist";
    }

    @GetMapping("/dogview")
    public String dogview(Model model, @RequestParam(required = false) Long id)  {
        if(id == null) {
            model.addAttribute("dog", new Dog());
        } else {
            Dog dog = dogRepository.findById(id).orElse(null);
            model.addAttribute("dog", dog);
        }

        return "dog/dogview";
    }

    /*@PostMapping("/doginquire")  //보류
    public String dogView(@Valid Inquire inquire) {
        return "redirect:/dog/doglist";
    }*/
}
