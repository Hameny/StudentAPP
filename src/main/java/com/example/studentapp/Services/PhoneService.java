package com.example.studentapp.Services;

import com.example.studentapp.DTO.Phone;

import java.util.List;
import java.util.UUID;

public interface PhoneService {
    void addPhoneByStudentID(UUID studentID, String phoneNumber);
    List<Phone> getPhoneByStudentID(UUID studentID);
    List<Phone> getAllPhone();
}
