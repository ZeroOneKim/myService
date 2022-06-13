package com.example.myService.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Cat {
    @Id
    public String cat_id;
}
