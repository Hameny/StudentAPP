package com.example.studentapp.Controllers;

import com.example.studentapp.DTO.Student;
import com.example.studentapp.Services.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/getStudentById")
    public  List<Student> getStudentById(UUID id){
        return studentService.getStudentById(id);
    }
    @GetMapping("/getStudentBySecondName")
    public  List<Student> getStudentBySecondName(String secondName){
        return studentService.getStudentBySecondName(secondName);
    }
}
