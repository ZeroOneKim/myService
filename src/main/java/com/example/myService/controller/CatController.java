package com.example.myService.controller;

import com.example.myService.entity.Cat;
import com.example.myService.entity.User;
import com.example.myService.repository.CatRepository;
import com.example.myService.service.CatService;
import com.example.myService.service.InquireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cat")
public class CatController {
    @Autowired
    private CatRepository catRepository;
    @Autowired
    private CatService catService;
    @Autowired
    private InquireService inquireService;

    @GetMapping("/catlist")
    public String catlist(Model model,@PageableDefault(size = 6) Pageable pageable) {
        model.addAttribute("cat", catService.cat(pageable));
        String writer = "작성자 : ";
        model.addAttribute("writer", writer);
        int startPage = 1;
        int endPage = catService.cat(pageable).getTotalPages();
        int nowPage = catService.cat(pageable).getPageable().getPageNumber();
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("nowPage", nowPage);

        return "cat/catlist";
    }
    @GetMapping("/catform")
    public String catform(Model model) {
        return "cat/catform";
    }


    @GetMapping("/catview")
    public String catView(Model model, @RequestParam(required = false ) Long id) { //request 문법
        if (id==null) {
            model.addAttribute("cat", new Cat());
        } else {
            Cat cat = catRepository.findById(id).orElse(null);
            model.addAttribute("cat", cat);
        }
        return "/cat/catview";
    }

    @PostMapping("/catinquire")
    public String catinquire(Long cat_id, Model model, Authentication authentication) {
        String username = authentication.getName();
        inquireService.inquirereserve(cat_id, username);
        return "redirect:/cat/catlist";
    }
}
