package com.example.oauth_sb_student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private String id;

    private String name;

    private String email;

    private String picture;

}
