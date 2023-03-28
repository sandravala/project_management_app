package com.pm.finalproject.users;

import com.pm.finalproject.users.model.Role;
import com.pm.finalproject.users.model.SignupRequest;
import com.pm.finalproject.users.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.pm.finalproject.users.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found [email=%s]", email)));
    }

    public String saveUser(SignupRequest newUser) {

        String result = "";

        if(!validateUser(newUser.getEmail()).isPresent()) {

            Set<String> newRoles = new HashSet<>();
            newRoles.add("NEW");

            String encoded = new BCryptPasswordEncoder().encode(newUser.getPassword());

            User createdUser = userRepository.save(User.builder()
                    .name(newUser.getName())
                    .email(newUser.getEmail())
                    .surname(newUser.getSurname())
                    .organisation(newUser.getOrganisation())
                    .password(encoded)
                    .roles(newRoles.stream()
                            .map(Role::new)
                            .collect(Collectors.toSet()))
                    .build());

            result += "created";
        } else {
            result += "exists";
        }

        return result;
    }



    public Set<Role> setRoles(Long userId, List<String> roles) {

            User user = userRepository.getReferenceById(userId);

            Set<Role> userRolesSet = roles.stream()
                    .map(Role::new)
                    .collect(Collectors.toSet());

            user.setRoles(userRolesSet);

        return user.getRoles();

    }


    private Optional<User> validateUser(String email) {
        return userRepository.findByEmail(email);
    }
}
