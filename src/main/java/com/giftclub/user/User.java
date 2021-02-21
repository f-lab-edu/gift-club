package com.giftclub.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDate birth;
}
