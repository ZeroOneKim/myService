package com.example.myService.controller;

import com.example.myService.entity.Cat;
import com.example.myService.repository.CatRepository;
import com.example.myService.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CatService catService;
    @Autowired
    private CatRepository catRepository;

    @GetMapping("/home")
    public String adminhome() {
        return "/admin/home";
    }

    @GetMapping("/cat/catlist")
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

        return "/admin/cat/catlist";
    }
    @GetMapping("/cat/catform")
    public String catform(Model model) {
        return "/admin/cat/catform";
    }
    @GetMapping("/cat/catreform")
    public String catreform(Model model, @RequestParam(required = false) Long id)
    {
        if (id==null) {
            return "redirect:/admin/home";
        }
        Cat cat = catRepository.findById(id).orElse(null);
        model.addAttribute("cat", cat);
        return "/admin/cat/catreform";
    }
    @PostMapping("/cat/update")
    public String catupdate(Cat cat, Model model, Authentication authentication, String filename)
            throws Exception{
        System.out.println(filename);
        String username = authentication.getName();
        catService.update(cat,username);

        return "redirect:/admin/cat/catlist";
    }


    @PostMapping("/cat/catformpro")  //
    public String catformpro(Cat cat, Model model, MultipartFile catfile, Authentication authentication)
            throws Exception {
        String username = authentication.getName();
        catService.catwrite(cat, catfile, username);
        System.out.println(catfile+"  입력");
        return "redirect:/admin/cat/catlist";
    }

    @GetMapping("/cat/catview")
    public String catView(Model model, @RequestParam(required = false ) Long id) { //request 문법
        if (id==null) {
            model.addAttribute("cat", new Cat());
        } else {
            Cat cat = catRepository.findById(id).orElse(null);
            model.addAttribute("cat", cat);
        }
        return "/admin/cat/catview";
    }

    @GetMapping("/cat/catformdel")
    public String catformdel(Long id, String filename){
        catService.catDelete(id, filename);
        return "redirect:/admin/cat/catlist";
    }
}

