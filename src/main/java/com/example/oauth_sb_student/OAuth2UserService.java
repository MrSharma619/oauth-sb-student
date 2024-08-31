package com.example.oauth_sb_student;

import com.example.oauth_sb_student.dto.StudentDto;
import com.example.oauth_sb_student.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OAuth2UserService extends DefaultOAuth2UserService {

    private final StudentRepository repository;

    public OAuth2User loadUser(OAuth2UserRequest request){
        OAuth2User user = super.loadUser(request);

        processUser(request, user);

        return user;
    }

    private void processUser(OAuth2UserRequest request, OAuth2User user){
        StudentDto studentDto = new StudentDto(
                user.getAttributes().get("sub").toString(),
                user.getAttributes().get("name").toString(),
                user.getAttributes().get("email").toString(),
                user.getAttributes().get("picture").toString()
        );

        Optional<Student> studentOptional = repository.findByUsername(studentDto.getEmail());

        Student student = studentOptional
                            .map(existingStudent -> updateExistingUser(existingStudent, studentDto))
                            .orElseGet(() -> registerUser(request, studentDto));

    }

    private Student registerUser(OAuth2UserRequest request, StudentDto dto){
        Student student = new Student();

        student.setProvider(request.getClientRegistration().getRegistrationId());
        student.setProviderId(dto.getId());
        student.setName(dto.getName());
        student.setUsername(dto.getEmail());
        student.setPicture(dto.getPicture());
        student.setId(UUID.randomUUID());

        return repository.save(student);

    }

    private Student updateExistingUser(Student student, StudentDto dto){
        student.setName(dto.getName());
        student.setPicture(dto.getPicture());

        return repository.save(student);
    }

}
