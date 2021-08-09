package com.idbmobile.practica.menu;

import static com.idbmobile.practica.main.Main.userHashMap;

import java.util.Scanner;

import com.idbmobile.practica.model.Administator;
import com.idbmobile.practica.model.Employee;
import com.idbmobile.practica.model.Nurse;
import com.idbmobile.practica.model.Technical;

public class Menu {

	public static Scanner sc;

	public static void login() {
		sc = new Scanner(System.in);
		System.out.println("Welcome to the Integrated Management System of a COVID-19 clinic ");
		System.out.println("To start using the system you need to login in ");
		System.out.println("Please enter your id");
		String id = sc.next();
		System.out.println("Please enter your password");
		String password = sc.next();

		// checks if id and password entered correctly
		// if not return to menu again
		if (userHashMap.containsKey(id)) {
			Employee employee = (Employee) userHashMap.get(id);
			if (employee.getPassword().equals(password)) {
				System.out.println("Access granted");
				createMainMenu(employee);
			} else {
				System.out.println("Access denied. Password is incorrect.");
				login();
			}
		} else {
			System.out.println("There not user with this id the system.");
			login();
		}
	}

	// depends of introduced DNI - open menu for concrete employee
	public static void createMainMenu(Employee employee) {
		if (employee instanceof Administator) {
			MenuAdmin.createMenuAdmin(sc);
		} else if (employee instanceof Nurse) {
			MenuNurse.createMenuNurse(sc, employee);
		} else if (employee instanceof Technical) {
			MenuTechnical.createMenuTechnical(sc, employee);
		}
	}
}
