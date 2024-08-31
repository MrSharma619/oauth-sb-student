package com.example.oauth_sb_student;

import com.example.oauth_sb_student.entity.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    @EntityGraph(attributePaths = "authorities")
    Optional<Student> findByUsername(String username);

}
