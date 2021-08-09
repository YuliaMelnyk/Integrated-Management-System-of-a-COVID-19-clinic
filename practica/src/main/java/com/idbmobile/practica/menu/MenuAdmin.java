package com.idbmobile.practica.menu;

import static com.idbmobile.practica.main.Main.userHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.idbmobile.practica.model.User;

public class MenuAdmin {

	public static void createMenuAdmin(Scanner scanner) {

		HashMap<Integer, Runnable> hashMap = new HashMap<Integer, Runnable>();
		hashMap.put(1, () -> modificateData(scanner));
		hashMap.put(2, () -> MenuAssignment.createMenuAssignment(scanner));
		hashMap.put(3, () -> viewAllUsers(scanner));
		hashMap.put(4, () -> MenuPatientAssigNurseTech.showAllAssigned());

		boolean isExit = false;

		System.out.println("Choose the N of accion ");
		System.out.println("______________________________________________________________________________");
		System.out.println("1. User managment (modificate data)");
		System.out.println("______________________________________________________________________________");
		System.out.println("2. Assignment of tests and vaccines");
		System.out.println("______________________________________________________________________________");
		System.out.println("3. Data visualization of all the people registered in the system");
		System.out.println("______________________________________________________________________________");
		System.out.println(
				"4. Viewing patients assigned to each nurse/technician for testing diagnostics and vaccinations");
		System.out.println("______________________________________________________________________________");
		System.out.println("5. Viewing the list of confined patients and the dates of lockdown");
		System.out.println("______________________________________________________________________________");
		System.out.println("6. Management of post-confinement serological testing scheduling");
		System.out.println("______________________________________________________________________________");
		System.out.println("7. Update of the vaccine stock");
		System.out.println("______________________________________________________________________________");
		System.out.println(
				"8. Visualization of the tentative vaccine planning, based on the patients registered at a certain time");
		System.out.println("______________________________________________________________________________");

		hashMap.get(scanner.nextInt()).run();
	}

	public static void modificateData(Scanner scanner) {
		System.out.println("Choose user to modificate ");
		System.out.println("_______________________________");
		System.out.println("1. Nurse");
		System.out.println("_______________________________");
		System.out.println("2. Technical");
		System.out.println("_______________________________");
		System.out.println("3. Patient");
		System.out.println("_______________________________");

		switch (scanner.nextInt()) {
		case 1:
			MenuModificateData.createMenuModificate(scanner);
			break;
		case 2:
			MenuModificateData.createMenuModificate(scanner);
			break;
		case 3:
			MenuModificateData.createMenuModificate(scanner);
			break;

		default:
			break;
		}

	}

	public static void viewAllUsers(Scanner scanner) {
		for (Map.Entry<String, User> entry : userHashMap.entrySet()) {
			User user = entry.getValue();
			System.out.println(user.toString());
		}

	}

}
