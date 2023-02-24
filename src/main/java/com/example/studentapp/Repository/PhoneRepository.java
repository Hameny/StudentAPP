package com.example.studentapp.Repository;

import com.example.studentapp.DTO.Phone;

import java.util.List;
import java.util.UUID;

public interface PhoneRepository {
    List<Phone> addPhoneByStudentID(UUID studentID, String phoneNumber);

    List<Phone> getPhoneByStudentID(UUID fromString);
    List<Phone> getAllPhone();
}