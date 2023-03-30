package com.pm.finalproject.users;

import com.pm.finalproject.users.model.Role;
import com.pm.finalproject.users.model.SignupRequest;
import com.pm.finalproject.users.model.UserDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.pm.finalproject.users.model.User;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found [email=%s]", email)));
    }

    public String saveUser(SignupRequest newUser) {

        String result = "";

        if(!validateUser(newUser.getEmail()).isPresent()) {

            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("NEW").get());


            User createdUser = userRepository.save(User.builder()
                    .name(newUser.getName())
                    .email(newUser.getEmail())
                    .surname(newUser.getSurname())
                    .organisation(newUser.getOrganisation())
                    .password("{noop}"+newUser.getPassword())
                    .roles(roles)
                    .build());

            roleRepository.findByName("NEW").get().addUser(createdUser);
            result += "userCreated";
        } else {
            result += "exists";
        }
        return result;
    }


    @Transactional
    public Set<Role> setRoles(Long userId, List<String> roles) {

            User user = userRepository.getReferenceById(userId);
            Set<User> userSet = new HashSet<>();
            userSet.add(user);

            Set<Role> userRolesSet = roles.stream()
                    .map(role -> roleRepository.findByName(role).get())
                    .collect(Collectors.toSet());

            user.setRoles(userRolesSet);

            if( userRolesSet.iterator().hasNext())
                userRolesSet.iterator().next().setUsers(userSet);
        return user.getRoles();

    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(u -> UserDto.builder()
                                .id(u.getId())
                                .name(u.getName())
                                .surname(u.getSurname())
                                .email(u.getEmail())
                                .organisation(u.getOrganisation())
                                .roles(u.getRoles().stream().map(role -> role.getName()).collect(Collectors.toSet()))
                        .build()
                        ).collect(Collectors.toList());
    }

    private Optional<User> validateUser(String email) {

        return userRepository.findByEmail(email);
    }
}
