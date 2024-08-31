package com.example.oauth_sb_student.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Student {

    @Id
    private UUID id;

    @OneToMany
    private Set<Authority> authorities;

    private String password;

    private String name;

    private String picture;

    @Column(unique = true)
    private String username;

    private String provider;

    private String providerId;

}
