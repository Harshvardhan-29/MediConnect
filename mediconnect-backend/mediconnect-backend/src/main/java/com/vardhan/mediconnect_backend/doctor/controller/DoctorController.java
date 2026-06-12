package com.vardhan.mediconnect_backend.doctor.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vardhan.mediconnect_backend.doctor.dto.CreateDoctorRequest;
import com.vardhan.mediconnect_backend.doctor.dto.DoctorProfileResponse;
import com.vardhan.mediconnect_backend.doctor.dto.DoctorResponse;
import com.vardhan.mediconnect_backend.doctor.dto.DoctorSearchResponse;
import com.vardhan.mediconnect_backend.doctor.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(
            DoctorService doctorService) {

        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorResponse>
    createDoctor(
            @RequestBody CreateDoctorRequest request) {

        return ResponseEntity.ok(
                doctorService.createDoctor(
                        request));
    }
    
    @GetMapping("/profile/{userId}")
    public ResponseEntity<DoctorProfileResponse>
    getDoctorProfile(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                doctorService.getDoctorProfile(
                        userId));
    }
    
    
//    Receives specialization from URL.
//    Calls DoctorService.
//    Returns matching doctors.
    @GetMapping("/search")
    public ResponseEntity<List<DoctorSearchResponse>>
    searchDoctors(
            @RequestParam String specialization) {

        return ResponseEntity.ok(
                doctorService.searchDoctors(
                        specialization));
    }
    
}