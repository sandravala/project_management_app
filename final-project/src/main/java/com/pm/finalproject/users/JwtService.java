package com.pm.finalproject.users;

import com.pm.finalproject.users.model.Role;
import com.pm.finalproject.users.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private static final String ROLES_CLAIM = "roles";

    private final RoleRepository roleRepository;
    private byte[] secretKey = "HbVWjy4LaI71OAUzr8rD7478lb7pwOtsuIWZHIK9VWKkfI3linaS8u9b0yuF8N2sxLKv02Q+gZcYZcUo+OM2oA==".getBytes();

    public JwtService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public String createToken(User user) {

        Date now = new Date();

        return Jwts.builder()
                .setIssuer("pm-app-back-end")
                .setSubject(user.getEmail())
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 1800000)) // 30 min
                .claim(ROLES_CLAIM, user.getRoles().stream()
                        .map(Role::getName)
                        .collect(Collectors.toSet()))
                .signWith(Keys.hmacShaKeyFor(secretKey), SignatureAlgorithm.HS512)
                .compact();
    }

    public User parseToken(String jwt) {

        Claims body = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey))
                        .build()
                                .parseClaimsJws(jwt)
                .getBody();

        Set<Role> roleSet = ((List<String>) body.get(ROLES_CLAIM)).stream()
                .map(role -> roleRepository.findByName(role).get())
                .collect(Collectors.toSet());

        User user = User.builder()
                .email(body.getSubject())
                .roles(roleSet) // ["ADMIN", "USER", ...] -> [new Role(...), new Role(...)]
                .build();
        return user;
    }

}
