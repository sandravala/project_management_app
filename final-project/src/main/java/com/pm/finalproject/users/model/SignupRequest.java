
package com.pm.finalproject.users.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class SignupRequest {
    private String name;
    private String surname;
    private String password;
    private String organisation;
    private String email;
}


