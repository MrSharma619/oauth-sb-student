package com.example.oauth_sb_student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.UUID;

@Entity
@Data
public class Authority implements GrantedAuthority {

    @Id
    private UUID id;

    private String authority;

}
