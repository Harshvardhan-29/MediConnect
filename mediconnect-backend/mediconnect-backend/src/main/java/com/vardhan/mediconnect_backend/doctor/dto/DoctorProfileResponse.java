package com.vardhan.mediconnect_backend.doctor.dto;

public class DoctorProfileResponse {

    private Long doctorId;
    private String name;
    private String email;
    private String specialization;
    private Integer experienceYears;
    private Double consultationFee;

    public DoctorProfileResponse(
            Long doctorId,
            String name,
            String email,
            String specialization,
            Integer experienceYears,
            Double consultationFee) {

        this.doctorId = doctorId;
        this.name = name;
        this.email = email;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
        this.consultationFee = consultationFee;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public Double getConsultationFee() {
        return consultationFee;
    }
}