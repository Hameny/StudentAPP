package com.example.studentapp.Services;

import com.example.studentapp.DTO.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    List<Student> getAllStudents();
    List<Student> getStudentById(UUID id);
    List<Student> getStudentBySecondName(String secondName);
}
