package com.example.studentapp.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Student {
    private UUID id;
    private String firstName;
    private String secondName;
    private LocalDate dateOfBirthday;
    private boolean isDelete = false;
    private UUID groupId;

    public Student(UUID id, String firstName, String secondName, LocalDate dateOfBirthday,
                   boolean isDelete, UUID groupId) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirthday = dateOfBirthday;
        this.isDelete = isDelete;
        this.groupId = groupId;
    }

}
