package com.vardhan.mediconnect_backend.doctor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vardhan.mediconnect_backend.auth.entity.User;
import com.vardhan.mediconnect_backend.auth.repository.UserRepository;
import com.vardhan.mediconnect_backend.doctor.dto.CreateDoctorRequest;
import com.vardhan.mediconnect_backend.doctor.dto.DoctorProfileResponse;
import com.vardhan.mediconnect_backend.doctor.dto.DoctorResponse;
import com.vardhan.mediconnect_backend.doctor.dto.DoctorSearchResponse;
import com.vardhan.mediconnect_backend.doctor.entity.Doctor;
import com.vardhan.mediconnect_backend.doctor.repository.DoctorRepository;

@Service
public class DoctorServiceImpl
        implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;

    public DoctorServiceImpl(
            DoctorRepository doctorRepository,
            UserRepository userRepository) {

        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
    }

    @Override
    public DoctorResponse createDoctor(
            CreateDoctorRequest request) {

        User user = userRepository
                .findById(request.getUserId())
                .orElseThrow();

        Doctor doctor = new Doctor();

        doctor.setSpecialization(
                request.getSpecialization());

        doctor.setExperienceYears(
                request.getExperienceYears());

        doctor.setConsultationFee(
                request.getConsultationFee());

        doctor.setUser(user);

        Doctor savedDoctor =
                doctorRepository.save(doctor);

        return new DoctorResponse(
                savedDoctor.getId(),
                savedDoctor.getSpecialization(),
                savedDoctor.getExperienceYears(),
                savedDoctor.getConsultationFee());
    }
    
    @Override
    public DoctorProfileResponse getDoctorProfile(
            Long userId) {

        User user = userRepository
                .findById(userId)
                .orElseThrow();

        Doctor doctor = doctorRepository
                .findByUser(user)
                .orElseThrow();

        return new DoctorProfileResponse(
                doctor.getId(),
                user.getName(),
                user.getEmail(),
                doctor.getSpecialization(),
                doctor.getExperienceYears(),
                doctor.getConsultationFee()
        );
    }
    
    
//    1. Fetches doctors matching a specialization.
//    2. Fetches the linked user for each doctor.
//    3. Creates search result objects.
//    4. Returns a list to the frontend.
    @Override
    public List<DoctorSearchResponse> searchDoctors(
            String specialization) {

        List<Doctor> doctors =
                doctorRepository.findBySpecialization(
                        specialization);

        return doctors.stream()
                .map(doctor -> new DoctorSearchResponse(
                        doctor.getId(),
                        doctor.getUser().getName(),
                        doctor.getSpecialization(),
                        doctor.getExperienceYears(),
                        doctor.getConsultationFee()
                ))
                .collect(Collectors.toList());
    }
    
}