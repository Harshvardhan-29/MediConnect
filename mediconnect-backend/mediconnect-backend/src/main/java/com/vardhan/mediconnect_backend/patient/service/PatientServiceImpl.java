package com.vardhan.mediconnect_backend.patient.service;

import org.springframework.stereotype.Service;

import com.vardhan.mediconnect_backend.auth.entity.User;
import com.vardhan.mediconnect_backend.auth.repository.UserRepository;
import com.vardhan.mediconnect_backend.patient.dto.CreatePatientRequest;
import com.vardhan.mediconnect_backend.patient.dto.PatientProfileResponse;
import com.vardhan.mediconnect_backend.patient.dto.PatientResponse;
import com.vardhan.mediconnect_backend.patient.dto.UpdatePatientRequest;
import com.vardhan.mediconnect_backend.patient.entity.Patient;
import com.vardhan.mediconnect_backend.patient.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final UserRepository userRepository;

    public PatientServiceImpl(
            PatientRepository patientRepository,
            UserRepository userRepository) {

        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PatientResponse createPatient(
            CreatePatientRequest request) {

        User user = userRepository.findById(
                request.getUserId()).orElseThrow();

        Patient patient = new Patient();

        patient.setPhoneNumber(request.getPhoneNumber());
        patient.setAge(request.getAge());
        patient.setGender(request.getGender());
        patient.setUser(user);

        Patient savedPatient =
                patientRepository.save(patient);

        return new PatientResponse(
                savedPatient.getId(),
                savedPatient.getPhoneNumber(),
                savedPatient.getAge(),
                savedPatient.getGender());
    }
    
    @Override
    public PatientResponse getPatient(Long id) {
    Patient patient =patientRepository.findById(id)
    		                       .orElseThrow();
    
    return new PatientResponse(
    		patient.getId(),
    		patient.getPhoneNumber(),
    		patient.getAge(),
    		patient.getGender());
    }
    
    @Override
    public PatientResponse updatePatient(Long id,UpdatePatientRequest request) {
    	
    	Patient patient=patientRepository.findById(id).orElseThrow();
    	 patient.setPhoneNumber(
    	            request.getPhoneNumber());

    	    patient.setAge(
    	            request.getAge());

    	    patient.setGender(
    	            request.getGender());

    	    Patient updatedPatient =
    	            patientRepository.save(patient);
    	   
    	    return new PatientResponse(
    	            updatedPatient.getId(),
    	            updatedPatient.getPhoneNumber(),
    	            updatedPatient.getAge(),
    	            updatedPatient.getGender());
    }
    
    @Override
    public void deletePatient(Long id) {
    	Patient patient=patientRepository.findById(id).orElseThrow();
    
    	patientRepository.delete(patient);
    }
    
    @Override
    public PatientProfileResponse getPatientProfile(Long userId) {
    	User user =userRepository.findById(userId).orElseThrow();
    	
    	Patient patient=patientRepository.findByUser(user).orElseThrow();
    	
    	return new PatientProfileResponse(
    			patient.getId(),
    			user.getName(), 
    			user.getEmail(),
    			patient.getPhoneNumber(),
                patient.getAge(),
                patient.getGender());
    }
}