package com.pm.finalproject.users.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ROLE")
public class Role implements GrantedAuthority {

    private static final String SPRING_SECURITY_AUTHORITY_PREFIX = "ROLE_";

    @Id
    private String name;

    @ManyToMany(mappedBy = "roles", cascade = { CascadeType.ALL })
    @JsonBackReference
    private Set<User> users;


    @Override
    public String getAuthority() {
        return SPRING_SECURITY_AUTHORITY_PREFIX + name;
    }

    public void addUser(User user) {
        if(users == null)
            users = new HashSet<>();
        users.add(user);
    }
}