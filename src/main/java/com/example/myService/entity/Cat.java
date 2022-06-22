package com.example.myService.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cat_id;

    private String cat_species;
    private String cat_age;
    private String cat_wm;
    private String cat_vaccine;
    private String cat_neutral;
    private String cat_about;

    private String cat_filename;
    private String cat_filepath;

    @ManyToOne()  //One -> Cat table
    @JoinColumn(name = "user_id") //referencedColumnName = "id" 제외 cuz Long id already exist
    private User user;
}
