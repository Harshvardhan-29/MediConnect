package com.vardhan.mediconnect_backend.doctor.dto;

public class DoctorResponse {

    private Long id;
    private String specialization;
    private Integer experienceYears;
    private Double consultationFee;

    public DoctorResponse(
            Long id,
            String specialization,
            Integer experienceYears,
            Double consultationFee) {

        this.id = id;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
        this.consultationFee = consultationFee;
    }

    public Long getId() {
        return id;
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