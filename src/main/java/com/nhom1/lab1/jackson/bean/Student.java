package com.nhom1.lab1.jackson.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Student {
    private String name;
    private Boolean gender = false;
    private Double marks = 0.0;
    private Contact contact;
    private List<String> subjects;
}
