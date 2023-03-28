package com.pm.finalproject.users;

import com.pm.finalproject.users.model.Role;
import com.pm.finalproject.users.model.SignupRequest;
import com.pm.finalproject.users.model.User;
import com.pm.finalproject.users.model.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
public class UserController {
    private final UserService userService;
    @PostMapping("/user")
    public String createUser(@RequestBody SignupRequest newUser) {

        return userService.saveUser(newUser);
    }

    @PutMapping("/roles/{userId}")
    public Set<Role> addRoles(@PathVariable Long userId, @RequestBody List<String> roles) {
        return userService.setRoles(userId, roles);
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

}
