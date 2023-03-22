package com.pm.finalproject.users;

import com.pm.finalproject.users.model.Role;
import com.pm.finalproject.users.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private byte[] secretKey = "HbVWjy4LaI71OAUzr8rD7478lb7pwOtsuIWZHIK9VWKkfI3linaS8u9b0yuF8N2sxLKv02Q+gZcYZcUo+OM2oA==".getBytes();
    public String createToken(User user) {

        Date now = new Date();

        return Jwts.builder()
                .setIssuer("pm-app-back-end")
                .setSubject(user.getEmail())
                .setIssuedAt(now)
                .claim("roles", user.getRoles().stream()
                        .map(Role::getName)
                        .collect(Collectors.toSet()))
                .signWith(Keys.hmacShaKeyFor(secretKey), SignatureAlgorithm.HS512)
                .compact();
    }

}
