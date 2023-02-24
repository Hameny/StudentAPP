package com.example.studentapp.Services.IMPL;

import com.example.studentapp.DTO.Student;
import com.example.studentapp.Repository.StudentRepository;
import com.example.studentapp.Services.StudentService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class StudentServiceIPML implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceIPML(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {

        return studentRepository.getAllStudents();
    }
    @Override
    public List<Student> getStudentById(UUID id) {
        return studentRepository.getStudentById(id);
    }
    @Override
    public List<Student> getStudentBySecondName(String secondName) {
        return studentRepository.getStudentBySecondName(secondName);
    }
}
