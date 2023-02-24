package com.example.studentapp.Repository.IMPL;

import com.example.studentapp.DTO.Student;
import com.example.studentapp.Repository.StudentRepository;
import com.example.studentapp.Utill.ConnectionManager;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class StudentRepositoryIMPL implements StudentRepository {
    List<Student> studentList = new ArrayList<>();

    @Override
    public List<Student> getAllStudents() {
        try {
            Statement statement = ConnectionManager.open().createStatement();
            String q = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(q);
            resultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public List<Student> getStudentById(UUID idStudent) {
        String searchStudentById = "SELECT * FROM students WHERE id = ?";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(searchStudentById);
            preparedStatement.setObject(1, idStudent);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public List<Student> getStudentBySecondName(String secondName) {
        String searchStudentBySecondName = "SELECT * FROM students WHERE second_name = ?";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(searchStudentBySecondName);
            preparedStatement.setString(1, secondName);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    private void resultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String firstName = resultSet.getString("first_name");
            String secondName = resultSet.getString("second_name");
            LocalDate dateOfBirthday = LocalDate.parse(resultSet.getString("date_of_birthday"));
            boolean isDelete = Boolean.parseBoolean(resultSet.getString("isDelete"));
            UUID groupId = UUID.fromString(resultSet.getString("group_id"));
            Student student = new Student(id, firstName, secondName, dateOfBirthday, isDelete, groupId);
            studentList.add(student);
        }
    }
}
