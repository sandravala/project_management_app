package com.pm.finalproject.users;

import com.pm.finalproject.users.model.*;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public LoginResponse userLogin(@RequestBody @Valid LoginRequest loginRequest) {
            User user = authenticate(loginRequest);

        return new LoginResponse(generateJwt(user), UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .surname(user.getSurname())
                .organisation(user.getOrganisation())
                .roles(user.getRoles().stream()
                        .map(Role::getName)
                        .collect(Collectors.toSet()))
                .build());
    }

    private String generateJwt(User user) {
        return jwtService.createToken(user);
    }

    private User authenticate(LoginRequest loginRequest) {

        return (User) authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()))
                .getPrincipal();
    }


}
