package com.vardhan.mediconnect_backend.patient.service;

import com.vardhan.mediconnect_backend.patient.dto.CreatePatientRequest;
import com.vardhan.mediconnect_backend.patient.dto.PatientResponse;

public interface PatientService {

    PatientResponse createPatient(CreatePatientRequest request);
    PatientResponse getPatient(Long id);
}