package com.pm.finalproject.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Entity
@Table(name="USER")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private String password;


}
