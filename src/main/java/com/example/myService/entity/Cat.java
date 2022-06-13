package com.example.myService.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
