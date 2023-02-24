package com.example.studentapp.Services.IMPL;


import com.example.studentapp.DTO.Phone;
import com.example.studentapp.Repository.PhoneRepository;
import com.example.studentapp.Services.PhoneService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@Component
public class PhoneServiceIMPL implements PhoneService {
    private final PhoneRepository phoneRepository;

    public PhoneServiceIMPL(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public void addPhoneByStudentID(UUID studentID, String phoneNumber) {
        phoneRepository.addPhoneByStudentID(studentID,phoneNumber);
    }

    @Override
    public List<Phone> getPhoneByStudentID(UUID studentID) {
        return phoneRepository.getPhoneByStudentID(studentID);
    }

    @Override
    public List<Phone> getAllPhone() {
        return phoneRepository.getAllPhone();
    }
}
