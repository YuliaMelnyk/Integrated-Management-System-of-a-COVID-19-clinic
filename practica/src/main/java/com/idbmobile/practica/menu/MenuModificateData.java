package com.idbmobile.practica.menu;

import static com.idbmobile.practica.main.Main.userHashMap;

import java.util.HashMap;
import java.util.Scanner;

import com.idbmobile.practica.model.User;

// Menu to manage the data of Nurses and Technical
public class MenuModificateData {
	static boolean isExit = false;

	public static void createMenuModificate(Scanner scanner) {

		HashMap<Integer, Runnable> hashMap = new HashMap<Integer, Runnable>();

		System.out.println("Modificate employee data");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Enter id of the employee");

		int id = scanner.nextInt();

		if (userHashMap.containsKey(id)) {
			final User user = userHashMap.get(id);
			hashMap.put(1, () -> setAlta(user));
			hashMap.put(2, () -> setBaja(user));
			hashMap.put(3, () -> setName(user, scanner));
			hashMap.put(4, () -> setSurname(user, scanner));
			hashMap.put(5, () -> exit(scanner));
		} else {
			System.out.println("Id " + id + " not found in the system");
			createMenuModificate(scanner);
		}
		do {
			System.out.println("______________________________________________________________________________");
			System.out.println("Choose the N of action ");
			System.out.println("______________________________________________________________________________");
			System.out.println("1. Alta");
			System.out.println("______________________________________________________________________________");
			System.out.println("2. Baja");
			System.out.println("______________________________________________________________________________");
			System.out.println("3. Modificate name");
			System.out.println("______________________________________________________________________________");
			System.out.println("4. Modificate surname");
			System.out.println("______________________________________________________________________________");
			System.out.println("5. Exit");

			hashMap.get(scanner.nextInt()).run();

		} while (!isExit);

	}

	private static void setAlta(User user) {
		user.setIsAlta(true);
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("ALTA");
		System.out.println("------------------------------------------------------------------------------");
	}

	private static void setBaja(User user) {
		user.setIsBaja(true);
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("BAJA");
		System.out.println("------------------------------------------------------------------------------");
	}

	private static void setName(User user, Scanner scanner) {
		System.out.println("Enter a new name");
		String name = scanner.next();
		user.setName(name);
		System.out.println("Name successfuly changes to " + name);
		System.out.println("------------------------------------------------------------------------------");
	}

	private static void setSurname(User user, Scanner scanner) {
		System.out.println("Enter a new surname");
		String surname = scanner.next();
		user.setSurname(surname);
		System.out.println("Surname successfuly changes to " + surname);
		System.out.println("------------------------------------------------------------------------------");
	}

	private static void exit(Scanner scanner) {
		MenuAdmin.createMenuAdmin(scanner);
		isExit = true;
	}

}
