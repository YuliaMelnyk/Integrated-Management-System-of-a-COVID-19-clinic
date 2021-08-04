package com.idbmobile.practica.model;

import java.util.List;

import com.idbmobile.practica.enums.Type;

public class Nurse extends Employee {

	private List<Patient> patient;

	public Nurse(int id, String name, String surname, String password, Type type) {
		super(id, name, surname, password, type);
		type = Type.NURSE;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Nurse [patient=" + patient + "]";
	}

}
