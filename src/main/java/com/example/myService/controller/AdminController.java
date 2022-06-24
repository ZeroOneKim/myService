package com.example.myService.controller;

import com.example.myService.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CatService catService;


    @GetMapping("/catlist")
    public String catlist(Model model, @PageableDefault(size = 6) Pageable pageable) {
        model.addAttribute("cat", catService.cat(pageable));
        String writer = "작성자 : ";
        model.addAttribute("writer", writer);
        int startPage = 1;
        int endPage = catService.cat(pageable).getTotalPages();
        int nowPage = catService.cat(pageable).getPageable().getPageNumber();
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("nowPage", nowPage);

        return "/admin/catlist";
    }
}

