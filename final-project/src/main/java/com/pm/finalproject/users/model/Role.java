package com.pm.finalproject.users.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="ROLE")
public class Role implements GrantedAuthority {

    private static final String SPRING_SECURITY_AUTHORITY_PREFIX = "ROLE_";

    @Id
    private String name;

    @Override
    public String getAuthority() {
        return SPRING_SECURITY_AUTHORITY_PREFIX + name;
    }
}