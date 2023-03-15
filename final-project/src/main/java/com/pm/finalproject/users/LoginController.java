package com.pm.finalproject.users;

import com.pm.finalproject.users.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String userLogin(@RequestBody @Valid UserDto userDto) {
        System.out.println(userDto.toString());
        return "login endpointas veikia";
    }


}
