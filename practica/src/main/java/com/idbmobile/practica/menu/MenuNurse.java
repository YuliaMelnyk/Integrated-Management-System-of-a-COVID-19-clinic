package com.idbmobile.practica.menu;

import static com.idbmobile.practica.main.Main.userHashMap;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.idbmobile.practica.model.Employee;
import com.idbmobile.practica.model.Patient;

public class MenuNurse {

	public static void createMenuNurse(Scanner scanner, Employee employee) {
		HashMap<Integer, Runnable> hashMap = new HashMap<Integer, Runnable>();
		hashMap.put(1, () -> dataOfPatients(scanner, employee));
		hashMap.put(2, () -> registrationMenu(scanner, employee));

		boolean isExit = false;

		System.out.println("Choose the N of accion ");
		System.out.println("______________________________________________________________________________");
		System.out.println(
				"1. Viewing data of assigned patients (dates of tests/vaccination, results, dates of confinement,...)");
		System.out.println("______________________________________________________________________________");
		System.out.println("2. Registration and updating of diagnostic tests and vaccination to your patients.");
		System.out.println("______________________________________________________________________________");
	}

	// view data of all assigned patients
	private static void dataOfPatients(Scanner scanner, Employee employee) {
		List<Patient> patients = employee.getPatients();
		for (Patient patient : patients) {
			System.out.println(patient.toString());
		}
	}

	private static void registrationMenu(Scanner scanner, Employee employee) {

		HashMap<Integer, Runnable> hashMap = new HashMap<Integer, Runnable>();
		hashMap.put(1, () -> registrationVaccine(scanner, employee));
		hashMap.put(2, () -> registrationTest(scanner, employee));

		System.out.println("Choose the N of accion ");
		System.out.println("___________");
		System.out.println("1. Vaccine");
		System.out.println("___________");
		System.out.println("1. Test");
	}

	private static void registrationVaccine(Scanner scanner, Employee employee) {
		System.out.println("______________________________________________________________________________");
		System.out.println("Please enter DNI of patient");
		String dni = scanner.next();
		Patient patient = (Patient) userHashMap.get(dni);
		assignmentVaccine(employee);

	}

	private static void assignmentVaccine(Employee employee) {

	}

	private static void registrationTest(Scanner scanner, Employee employee) {

	}

}
