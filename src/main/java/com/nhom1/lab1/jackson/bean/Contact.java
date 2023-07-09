package com.nhom1.lab1.jackson.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Contact {
    private String email;
    private String phone;
    private String address;
}
