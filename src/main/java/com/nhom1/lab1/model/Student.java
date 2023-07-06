package com.nhom1.lab1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Student {
    private String name;
    private Boolean male = false;
    private Double marks = 0.0;
}


