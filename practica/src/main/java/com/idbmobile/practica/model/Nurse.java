package com.idbmobile.practica.model;

import java.util.List;

import com.idbmobile.practica.enums.Type;

public class Nurse extends Employee {

	private List<Patient> patients;

	public Nurse(String dni, String name, String surname, String password, Type type) {
		super(dni, name, surname, password, type);
		type = Type.NURSE;
	}

	@Override
	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatient(List<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Nurse [ DNI=" + getDni() + ", Name=" + getName() + ", Surname=" + getSurname() + ", Patients="
				+ patients + ", Limit=" + getLimit() + ", IsAlta=" + getIsAlta() + ", IsBaja=" + getIsBaja() + ", Type="
				+ getType() + "]";
	}

}
