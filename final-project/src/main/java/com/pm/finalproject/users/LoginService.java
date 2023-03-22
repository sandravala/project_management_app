package com.pm.finalproject.users;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.pm.finalproject.users.model.User;

@RequiredArgsConstructor
@Service
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found [email=%s]", email)));
    }
}
