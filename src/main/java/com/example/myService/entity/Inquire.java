package com.example.myService.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Inquire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inquire_id;

    // user FK
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    // cat FK
    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Cat cat_id;
}
