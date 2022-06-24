package com.example.myService.controller.restapi;

import com.example.myService.entity.Cat;
import com.example.myService.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;          //아직 미구현 ㅠㅠ...

@RestController
@RequestMapping("api")
class CatRestApiController {
    @Autowired
    private CatRepository repository;

    @GetMapping("/Cats")
    List<Cat> all() {
        return repository.findAll();
    }

    /*@GetMapping("/Cats")
    List<Cat> all(@RequestParam(required = false) String cat_species) {
        if(StringUtils.isEmpty(cat_species)) {
            return repository.findAll(); //전달이 안되었을 경우
        } else {
            return repository.findByTitle(cat_species);
        }
    }*/

    @PostMapping("/Cats")
    Cat newCat(@RequestBody Cat newCat) {
        return repository.save(newCat);
    }


    @GetMapping("/Cats/{id}")
    Cat one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CatNotFoundException(id)); //spring.io
    }

    @PutMapping("/Cats/{id}")
    Cat replaceCat(@RequestBody Cat newCat, @PathVariable Long id) {

        return repository.findById(id)
                .map(Cat -> {
                    Cat.setCat_species(newCat.getCat_species());    //DB
                    Cat.setCat_age(newCat.getCat_age());
                    Cat.setCat_wm(newCat.getCat_wm());
                    Cat.setCat_vaccine(newCat.getCat_vaccine());
                    Cat.setCat_neutral(newCat.getCat_neutral());
                    Cat.setCat_about(newCat.getCat_about());
                    Cat.setCat_filename(newCat.getCat_filepath());

                    return repository.save(Cat);
                })
                .orElseGet(() -> {
                    newCat.setCat_id(id);
                    return repository.save(newCat);
                });
    }

    @DeleteMapping("/Cats/{id}")
    void deleteCat(@PathVariable Long id) {
        repository.deleteById(id);
    }
}