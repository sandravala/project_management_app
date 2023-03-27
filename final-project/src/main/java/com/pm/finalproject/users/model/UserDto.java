package com.pm.finalproject.users.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private Set<String> roles;
}
