package com.userdetails.demo.domain.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@Getter
@Setter
public class User {
    @NonNull
    private String userId;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

    private String gender;

    private String address1;

    private String city;

    private String state;

    private String postCode;

    private String street;

    private String title;

}
