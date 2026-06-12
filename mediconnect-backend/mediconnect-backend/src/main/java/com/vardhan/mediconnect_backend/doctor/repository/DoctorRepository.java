package com.vardhan.mediconnect_backend.doctor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vardhan.mediconnect_backend.auth.entity.User;
import com.vardhan.mediconnect_backend.doctor.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long>{
	Optional<Doctor> findByUser(User user);
	List<Doctor> findBySpecialization(
	        String specialization);
}
