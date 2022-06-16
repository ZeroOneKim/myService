package com.example.myService.repository;

import com.example.myService.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {

    /*List<Cat> findByTitle(String cat_species)*/; //for Restapi 에러때문에 보류
}
