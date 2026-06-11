package com.vardhan.mediconnect_backend.patient.service;

import com.vardhan.mediconnect_backend.patient.dto.CreatePatientRequest;
import com.vardhan.mediconnect_backend.patient.dto.PatientProfileResponse;
import com.vardhan.mediconnect_backend.patient.dto.PatientResponse;
import com.vardhan.mediconnect_backend.patient.dto.UpdatePatientRequest;

public interface PatientService {

    PatientResponse createPatient(CreatePatientRequest request);
    PatientResponse getPatient(Long id);
    PatientResponse updatePatient(Long id,UpdatePatientRequest request);
    void deletePatient(Long id);
    
    PatientProfileResponse getPatientProfile(Long userId);
}