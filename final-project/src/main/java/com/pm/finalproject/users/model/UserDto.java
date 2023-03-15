package com.pm.finalproject.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotBlank
    private String email;
    @NotBlank
    private String password;


}

