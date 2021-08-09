package com.idbmobile.practica.model;

import java.util.List;

import com.idbmobile.practica.enums.Type;

public abstract class Employee extends User {

	private String password;
	private List<Patient> patients;
	private int limit;

	public Employee(String dni, String name, String surname, String password, Type type) {
		super(dni, name, surname, type);
		this.password = password;
		this.limit = 0;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
