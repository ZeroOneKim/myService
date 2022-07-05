package com.example.myService.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dog_id;

    private String dog_species;
    private String dog_age;
    private String dog_wm;
    private String dog_vaccine;
    private String dog_neutral;
    private String dog_about;

    private String dog_filename;
    private String dog_filepath;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
