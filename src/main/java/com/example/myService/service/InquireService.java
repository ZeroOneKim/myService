package com.example.myService.service;

import com.example.myService.entity.Cat;
import com.example.myService.entity.Dog;
import com.example.myService.entity.Inquire;
import com.example.myService.entity.User;
import com.example.myService.repository.CatRepository;
import com.example.myService.repository.InquireRepository;
import com.example.myService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InquireService {
    @Autowired
    private CatRepository catRepository;
    @Autowired
    private InquireRepository inquireRepository;
    @Autowired
    private UserRepository userRepository;
    public void inquirereserve(Inquire inquire , Cat cat_id, String username) {

        User user = userRepository.findByUsername(username);
        inquire.setUser_id(user);
        inquire.setCat_id(cat_id);
        inquireRepository.save(inquire);
    }
    public void inquirereserving(Inquire inquire , Dog dog_id, String username) {

        User user = userRepository.findByUsername(username);
        inquire.setUser_id(user);
        inquire.setDog_id(dog_id);
        inquireRepository.save(inquire);
    }
}
