package com.vardhan.mediconnect_backend.patient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vardhan.mediconnect_backend.patient.dto.CreatePatientRequest;
import com.vardhan.mediconnect_backend.patient.dto.PatientProfileResponse;
import com.vardhan.mediconnect_backend.patient.dto.PatientResponse;
import com.vardhan.mediconnect_backend.patient.dto.UpdatePatientRequest;
import com.vardhan.mediconnect_backend.patient.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(
            PatientService patientService) {

        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<PatientResponse> createPatient(
            @RequestBody CreatePatientRequest request) {

        PatientResponse response =
                patientService.createPatient(request);

        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatient(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                patientService.getPatient(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> updatePatient(
            @PathVariable Long id,
            @RequestBody UpdatePatientRequest request) {

        return ResponseEntity.ok(
                patientService.updatePatient(
                        id,
                        request));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(
    		@PathVariable Long id){
    	patientService.deletePatient(id);

        return ResponseEntity.ok(
                "Patient deleted successfully");
    }
    
    @GetMapping("/profile/{userId}")
    public ResponseEntity<PatientProfileResponse>
    getPatientProfile(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                patientService.getPatientProfile(
                        userId));
    }
}