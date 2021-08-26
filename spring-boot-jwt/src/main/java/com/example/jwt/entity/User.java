package com.example.jwt.entity;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    Integer id;
    
    String name;

    @NotNull
    String accessCode;

    @NotNull
    String accessKey;
}