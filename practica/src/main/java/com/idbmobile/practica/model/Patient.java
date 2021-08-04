package com.idbmobile.practica.model;

import java.time.LocalDate;
import java.util.List;

import com.idbmobile.practica.enums.Type;
import com.idbmobile.practica.enums.Vaccine;

// Patient class
public class Patient extends User {

	private LocalDate firstDose;
	private LocalDate secondDose;

	private List<Test> tests;

	private Vaccine vaccine;

	public Patient(int id, String name, String surname, List<Test> tests, Vaccine vaccine, LocalDate firstDose,
			Type type) {
		super(id, name, surname, type);
		this.tests = tests;
		this.vaccine = vaccine;
		type = Type.PATIENT;

	}

	public LocalDate getFirstDose() {
		return firstDose;
	}

	// can´t set the first dose if you already have the second dose
	public void setFirstDose(LocalDate firstDose) {
		if (this.secondDose != null) {
			this.firstDose = null;
		} else if (this.firstDose != null) {
			System.out.println("You can´t modify the date, already exist.");
		} else {
			this.firstDose = firstDose;
		}
	}

	public LocalDate getSecondDose() {
		return secondDose;
	}

	// if the patient don´t have the first dose, can´t set the second dose, also if
	// vaccine is Johnson&Johnson also can´t set second dose.
	public void setSecondDose(LocalDate secondDose) {

		if (firstDose == null) {
			this.secondDose = null;
		} else if (vaccine.equals(Vaccine.JONHNSONANDJONHNSON)) {
			this.secondDose = null;
		} else {
			this.secondDose = secondDose;
		}

	}

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		// check what if vaccine and set the date of second dose
		if (vaccine.equals(vaccine.PFIZER) || vaccine.equals(vaccine.MODERNA)) {
			this.secondDose = firstDose.plusDays(21);
		} else if (vaccine.equals(vaccine.JONHNSONANDJONHNSON)) {
			secondDose = null;
		} else if (vaccine.equals(Vaccine.NONE)) {
			this.vaccine = vaccine;
			this.firstDose = null;
			this.secondDose = null;
		}
	}

}
