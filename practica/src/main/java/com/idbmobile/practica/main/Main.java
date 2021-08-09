package com.idbmobile.practica.main;

import java.util.HashMap;

import com.idbmobile.practica.enums.Type;
import com.idbmobile.practica.menu.Menu;
import com.idbmobile.practica.model.Administator;
import com.idbmobile.practica.model.Nurse;
import com.idbmobile.practica.model.Patient;
import com.idbmobile.practica.model.Technical;
import com.idbmobile.practica.model.User;

public class Main {

	public static HashMap<String, User> userHashMap = new HashMap<String, User>();

	public static void main(String[] args) {
		createAdministrator();
		createNurses();
		createPatients();
		createTechnicals();
		Menu.login();

	}

	// creation of Administrator
	public static Administator createAdministrator() {
		Administator administator = new Administator("1", "Jose", "Mendez", "jose00", Type.ADMINISTRATOR);
		administator.setIsAlta(true);
		userHashMap.put("1", administator);
		return administator;
	}

	// creation of Patients
	public static HashMap<String, User> createPatients() {

		Patient patient = new Patient("10", "Yulia", "Melnyk", null, null, null, Type.PATIENT);
		Patient patient2 = new Patient("11", "Mariana", "Foster", null, null, null, Type.PATIENT);
		Patient patient3 = new Patient("12", "Alex", "Smith", null, null, null, Type.PATIENT);
		Patient patient4 = new Patient("13", "Sergio", "Gonzales", null, null, null, Type.PATIENT);
		Patient patient5 = new Patient("14", "Miriam", "Lopez", null, null, null, Type.PATIENT);

		userHashMap.put("10", patient);
		userHashMap.put("11", patient2);
		userHashMap.put("12", patient3);
		userHashMap.put("13", patient4);
		userHashMap.put("14", patient5);

		return userHashMap;
	}

	public static HashMap<String, User> createNurses() {

		Nurse nurse = new Nurse("2", "Maria", "Sanchez", "maria00", Type.NURSE);
		Nurse nurse2 = new Nurse("3", "Antonio", "Calvente", "antonio00", Type.NURSE);
		Nurse nurse3 = new Nurse("4", "Sofia", "Reyes", "sofia00", Type.NURSE);
		Nurse nurse4 = new Nurse("5", "Cristina", "Carillo", "cristi00", Type.NURSE);

		userHashMap.put("2", nurse);
		userHashMap.put("3", nurse2);
		userHashMap.put("4", nurse3);
		userHashMap.put("5", nurse4);

		return userHashMap;

	}

	public static HashMap<String, User> createTechnicals() {

		Technical technical = new Technical("6", "Diego", "Martin", "diego00", Type.TECHNICAL);
		Technical technical2 = new Technical("7", "Paloma", "Carillo", "paloma00", Type.TECHNICAL);
		Technical technical3 = new Technical("8", "Manuel", "Sanchez", "manuel00", Type.TECHNICAL);

		userHashMap.put("6", technical);
		userHashMap.put("7", technical2);
		userHashMap.put("8", technical3);

		return userHashMap;

	}

}
