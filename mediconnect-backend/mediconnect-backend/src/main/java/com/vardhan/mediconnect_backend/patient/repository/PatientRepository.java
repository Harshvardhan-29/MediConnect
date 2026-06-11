package com.vardhan.mediconnect_backend.patient.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vardhan.mediconnect_backend.auth.entity.User;
import com.vardhan.mediconnect_backend.patient.entity.Patient;

public interface PatientRepository
        extends JpaRepository<Patient, Long> {
	Optional<Patient> findByUser(User user);
		
}