package com.example.myService.service;

import com.example.myService.entity.Cat;
import com.example.myService.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {
    @Autowired
    public CatRepository catRepository;

    private List<Cat> cat = catRepository.findAll();
}
