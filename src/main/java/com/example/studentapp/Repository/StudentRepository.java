package com.example.studentapp.Repository;

import com.example.studentapp.DTO.Student;

import java.util.List;
import java.util.UUID;

public interface StudentRepository {
    List<Student> getAllStudents();
    List<Student> getStudentById(UUID id);
    List<Student> getStudentBySecondName(String secondName);
}
