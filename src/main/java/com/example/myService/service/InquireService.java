package com.example.myService.service;

import com.example.myService.entity.Cat;
import com.example.myService.entity.User;
import com.example.myService.repository.InquireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class InquireService {
    @Autowired
    private InquireRepository inquireRepository;

    public void inquirereserve(Long id, String username) {
        System.out.println(id);
        System.out.println(username);
    }
}
