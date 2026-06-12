package com.vardhan.mediconnect_backend.doctor.service;

import java.util.List;

import com.vardhan.mediconnect_backend.doctor.dto.CreateDoctorRequest;
import com.vardhan.mediconnect_backend.doctor.dto.DoctorProfileResponse;
import com.vardhan.mediconnect_backend.doctor.dto.DoctorResponse;
import com.vardhan.mediconnect_backend.doctor.dto.DoctorSearchResponse;

public interface DoctorService {

		DoctorResponse createDoctor(CreateDoctorRequest request);
		DoctorProfileResponse getDoctorProfile(Long userId);
		List<DoctorSearchResponse> searchDoctors(
		        String specialization);
		
}
