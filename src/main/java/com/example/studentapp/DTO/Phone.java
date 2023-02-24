package com.example.studentapp.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class Phone {
    private UUID id;

    private String numberPhone;

    private UUID studentID;

    public Phone(UUID id, String numberPhone, UUID studentID) {
        this.id = id;
        this.numberPhone = numberPhone;
        this.studentID = studentID;
    }
    public Phone(String numberPhone, UUID studentID) {
        this.id = UUID.randomUUID();
        this.numberPhone = numberPhone;
        this.studentID = studentID;
    }

    public Phone() {}

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", numberPhone='" + numberPhone + '\'' +
                ", studentID=" + studentID +
                '}'+ '\n';
    }
}
