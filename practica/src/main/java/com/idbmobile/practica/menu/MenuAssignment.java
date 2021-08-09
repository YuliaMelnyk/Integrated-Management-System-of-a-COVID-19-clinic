package com.idbmobile.practica.menu;

import static com.idbmobile.practica.main.Main.userHashMap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.idbmobile.practica.enums.TestType;
import com.idbmobile.practica.enums.Type;
import com.idbmobile.practica.enums.Vaccine;
import com.idbmobile.practica.model.AntigenTest;
import com.idbmobile.practica.model.Employee;
import com.idbmobile.practica.model.Nurse;
import com.idbmobile.practica.model.PCRTest;
import com.idbmobile.practica.model.Patient;
import com.idbmobile.practica.model.SerologicalAnalysis;
import com.idbmobile.practica.model.Technical;
import com.idbmobile.practica.model.Test;
import com.idbmobile.practica.utils.LocalDateTimeComparator;

public class MenuAssignment {
	public static int idPatient = 0;
	static boolean isExit = false;
	static HashMap<Integer, Runnable> hashMap = new HashMap<Integer, Runnable>();
	public static Patient patient = null;
	public static int quantity = 0;

	public static void createMenuAssignment(Scanner scanner) {

		do {

			System.out.println("1. Assignment test");
			System.out.println("2. Assignment vaccine");
			System.out.println("3. Return");

			switch (scanner.nextInt()) {
			case 1:
				assignmentTest(scanner);
				break;
			case 2:
				assignmentVaccine(scanner);
				break;
			case 3:
				isExit = true;
				MenuAdmin.createMenuAdmin(scanner);
				break;
			default:
				System.out.println("The action isnt correct");
				break;
			}
		} while (!isExit);
	}

	private static void assignmentVaccine(Scanner scanner) {
		List<Patient> patients = new ArrayList<Patient>();
		System.out.println("Enter id of patient");
		idPatient = scanner.nextInt();

		Patient patient = (Patient) userHashMap.get(idPatient);

		patients.add(patient);

		System.out.println("Enter id of Nurse");
		int idNurse = scanner.nextInt();

		Nurse nurse = (Nurse) userHashMap.get(idNurse);

		nurse.setPatients(patients);

		patient.setVaccine(randomEnum(Vaccine.class));

		System.out.println("Enter a year of vaccination");
		int year = scanner.nextInt();

		System.out.println("Enter a month of vaccination");
		int month = scanner.nextInt();

		System.out.println("Enter a day of vaccination");
		int day = scanner.nextInt();

		patient.setFirstDose(LocalDate.of(year, month, day));
		patient.setSecondDose(null);

	}

	private static void assignmentTest(Scanner scanner) {

		System.out.println("Enter N id of patient");
		idPatient = scanner.nextInt();

		try {
			patient = (Patient) userHashMap.get(idPatient);
		} catch (Exception e) {
			System.out.println("Patient id isnt correct. Try again");
			assignmentTest(scanner);
		}

		// checks if id of patient and technical is correct
		if (patient.getType().equals(Type.PATIENT)) {

			System.out.println("Enter N id of Technical");
			int idTechnical = scanner.nextInt();

			Employee employee = (Employee) userHashMap.get(idTechnical);
			if (employee.getType().equals(Type.TECHNICAL) || employee.getType().equals(Type.NURSE)) {

				hashMap.put(1, () -> setTest(scanner, employee, patient, TestType.ANTIGEN));
				hashMap.put(2, () -> setTest(scanner, employee, patient, TestType.PCR));
				hashMap.put(3, () -> setTest(scanner, employee, patient, TestType.SEROLOGICAL));
				hashMap.put(4, () -> createMenuAssignment(scanner));

				System.out.println("Which test you want to assign?");
				System.out.println("1. Antigen Test");
				System.out.println("2. PCR Test");
				System.out.println("3. Serological Test");
				System.out.println("4. Exit");

				hashMap.get(scanner.nextInt()).run();

			} else {
				System.out.println("Id of technical isnt correct. Try again");
				assignmentTest(scanner);
			}
		} else {
			System.out.println("Id of patient isnt correct. Try again");
			assignmentTest(scanner);
		}
	}

	// set test to employee and patient
	public static void setTest(Scanner scanner, Employee employee, Patient patient, TestType type) {
		List<Test> tests = patient.getTests();
		if (tests == null) {
			tests = new ArrayList<Test>();
		}
		LocalDate testDate = setTestDay(scanner);

		boolean isLimit = checkLimitTestForWeek(testDate, employee);

		if (isLimit) {
			System.out.println("You cant assigned test for this employee, he/she get over his/her weekly limit");
			MenuAdmin.createMenuAdmin(scanner);
		} else {
			if (type.equals(TestType.PCR)) {
				tests.add(new PCRTest(testDate, TestType.PCR));
				patient.setTests(tests);
			} else if (type.equals(TestType.ANTIGEN)) {
				tests.add(new AntigenTest(testDate, TestType.ANTIGEN));
				patient.setTests(tests);
			} else if (type.equals(TestType.SEROLOGICAL)) {
				tests.add(new SerologicalAnalysis(testDate, TestType.SEROLOGICAL));
				patient.setTests(tests);
			}
		}

		List<Patient> patients = employee.getPatients();
		if (patients == null) {
			patients = new ArrayList<Patient>();
		}
		patients.add(patient);
		employee.setPatients(patients);

		System.out.println("Test assigned ");
		System.out.println("--------------------------------------------------------------------");
	}

	// checks limit of weekly tests for Technical (max 4) and Nurse (max 5)
	public static boolean checkLimitTestForWeek(LocalDate localDate, Employee employee) {
		LocalDate time = localDate.minusDays(7);

		// get all patients assigned to this employee
		List<Patient> patients = employee.getPatients();
		if (patients == null) {
			return false;
		}
		// get all tests of this patients
		for (Patient patient : patients) {
			List<Test> tests = patient.getTests();
			if (tests == null) {
				tests = new ArrayList<Test>();
			}
			List<LocalDate> testDates = new ArrayList<LocalDate>();

			// get Dates of tests and sorted them
			for (Test test : tests) {
				testDates.add(test.getTestDate());
			}

			List<LocalDate> sorted = new ArrayList<>(testDates);
			Comparator<LocalDate> comparator = new LocalDateTimeComparator();
			sorted.sort(comparator);

			// Get all dates of tests in 7 days
			LocalDate startDate = localDate.minusDays(7);

			List<LocalDate> listOfDates = startDate.datesUntil(localDate).collect(Collectors.toList());

			// checks limit of weekly test days
			for (LocalDate date : listOfDates) {
				for (Test test : tests) {
					if (test.getTestDate().equals(date)) {
						employee.setLimit(employee.getLimit() + 1);
					}
					if (employee instanceof Technical && employee.getLimit() == 4) {
						return true;
					} else if (employee instanceof Nurse && employee.getLimit() == 5) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static LocalDate setTestDay(Scanner scanner) {
		System.out.println("Enter a year of test");
		int year = scanner.nextInt();

		System.out.println("Enter a month of test");
		int month = scanner.nextInt();

		System.out.println("Enter a day of test");
		int day = scanner.nextInt();
		LocalDate testDate = LocalDate.of(year, month, day);

		return testDate;
	}

	// get random Vaccine
	public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
		Random random = new Random();
		int x = random.nextInt(clazz.getEnumConstants().length);
		return clazz.getEnumConstants()[x];
	}
}
