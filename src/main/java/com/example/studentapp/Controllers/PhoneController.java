package com.example.studentapp.Controllers;

import com.example.studentapp.DTO.Phone;
import com.example.studentapp.Services.PhoneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/phones")
public class PhoneController {
    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/getAllPhones")
    public List<Phone> getAllPhones() {
        return phoneService.getAllPhone();
    }

    @GetMapping("/getPhoneByStudentId")
    public List<Phone> getPhoneByStudentId(UUID studentId) {
        return phoneService.getPhoneByStudentID(studentId);
    }
}
