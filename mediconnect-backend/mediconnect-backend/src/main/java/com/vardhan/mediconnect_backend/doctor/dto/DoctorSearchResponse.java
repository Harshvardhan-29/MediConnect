//Instead of returning full doctor information,
//this class returns only the data needed for search results.
//
//This is what the patient will see when searching doctors.

package com.vardhan.mediconnect_backend.doctor.dto;

public class DoctorSearchResponse {

    private Long doctorId;
    private String name;
    private String specialization;
    private Integer experienceYears;
    private Double consultationFee;

    public DoctorSearchResponse(
            Long doctorId,
            String name,
            String specialization,
            Integer experienceYears,
            Double consultationFee) {

        this.doctorId = doctorId;
        this.name = name;
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