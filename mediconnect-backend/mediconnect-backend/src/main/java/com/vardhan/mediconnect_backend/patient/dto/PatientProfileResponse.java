package com.vardhan.mediconnect_backend.patient.dto;

public class PatientProfileResponse {
	
	private Long patientId;
	private String name;
	private String email;
	private String phoneNumber;
	private Integer age;
	private String gender;
	
	
	public PatientProfileResponse(Long patientId, String name, String email, String phoneNumber, Integer age,
			String gender) {
		//super();
		this.patientId = patientId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.gender = gender;
	}
	public Long getPatientId() {
		return patientId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public Integer getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	
}
