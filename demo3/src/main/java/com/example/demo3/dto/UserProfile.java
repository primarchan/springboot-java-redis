package com.example.demo3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class UserProfile {

    @JsonProperty
    private String name;

    @JsonProperty
    private int age;

    @Builder
    public UserProfile(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
