package com.example.studentapp.Repository.IMPL;

import com.example.studentapp.Utill.ConnectionManager;
import com.example.studentapp.DTO.Phone;
import com.example.studentapp.Repository.PhoneRepository;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PhoneRepositoryIPML implements PhoneRepository {
    List<Phone> phoneArrayList = new ArrayList<>();

    @Override
    public List<Phone> addPhoneByStudentID(UUID studentID, String phoneNumber) {
        String addPhoneToStudent = "INSERT INTO public.Phones(student_id,number_phone) VALUES  (?,?)";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(addPhoneToStudent);
            preparedStatement.setObject(1, studentID);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phoneArrayList;
    }

    @Override
    public List<Phone> getPhoneByStudentID(UUID studentID) {
        String getPhoneByStudentID = "SELECT * FROM phones\n" +
                "WHERE student_id = ?";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(getPhoneByStudentID);
            preparedStatement.setObject(1, studentID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet(resultSet);
            while (resultSet.next()) {
                phoneArrayList.add(new Phone(UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("number_of_phone"),
                        UUID.fromString(resultSet.getString("studentID"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phoneArrayList;
    }

    @Override
    public List<Phone> getAllPhone() {
        try {
            Statement statement = ConnectionManager.open().createStatement();
            String getAllPhones = "SELECT * FROM phones";
            ResultSet resultSet = statement.executeQuery(getAllPhones);
            resultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phoneArrayList;
    }

    private void resultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String numberPhone = resultSet.getString("number_phone");
            UUID studentId = UUID.fromString(resultSet.getString("student_id"));
            Phone phone = new Phone(id, numberPhone, studentId);
            phoneArrayList.add(phone);
        }
    }
}
