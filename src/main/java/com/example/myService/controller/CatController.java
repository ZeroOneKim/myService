package com.example.myService.controller;

import com.example.myService.entity.Cat;
import com.example.myService.repository.CatRepository;
import com.example.myService.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/cat")
public class CatController {
    @Autowired
    private CatRepository catRepository;
    @Autowired
    private CatService catService;

    @GetMapping("/catlist")
    public String catlist(Model model) {
        model.addAttribute("cat", catService.cat());
        return "cat/catlist";
    }
    @GetMapping("/catform")
    public String catform(Model model) {
        return "cat/catform";
    }

    @PostMapping("/catformpro")  //
    public String catformpro(Cat cat, Model model, MultipartFile catfile) throws Exception {
        catService.catwrite(cat, catfile);
        return "redirect:/cat/catlist";
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

    @PostMapping("/catformdel")
    public String catformdelete(Long id) {
        catService.catdelete(id);
        return "/cat/catlist";
    }
}
