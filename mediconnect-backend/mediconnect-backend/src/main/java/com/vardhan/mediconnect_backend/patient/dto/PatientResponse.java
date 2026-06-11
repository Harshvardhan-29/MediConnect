package com.vardhan.mediconnect_backend.patient.dto;

public class PatientResponse {

    private Long id;
    private String phoneNumber;
    private Integer age;
    private String gender;

    public PatientResponse() {
    }

    public PatientResponse(Long id,
                           String phoneNumber,
                           Integer age,
                           String gender) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}