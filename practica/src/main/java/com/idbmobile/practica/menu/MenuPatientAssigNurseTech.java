package com.idbmobile.practica.menu;

import static com.idbmobile.practica.main.Main.userHashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.idbmobile.practica.enums.Type;
import com.idbmobile.practica.model.Nurse;
import com.idbmobile.practica.model.Technical;
import com.idbmobile.practica.model.User;

public class MenuPatientAssigNurseTech {

	public static void showAllAssigned() {

		List<Nurse> nurses = new ArrayList<Nurse>();
		System.out.println("Assigned Nurses");

		// search in all Nurses and search for assigned patients
		for (Map.Entry<String, User> entry : userHashMap.entrySet()) {
			User user = entry.getValue();
			if (user.getType().equals(Type.NURSE)) {
				if (((Nurse) user).getPatients() != null) {
					nurses.add((Nurse) user);
				}
			}
		}

		// print them
		if (nurses != null) {
			for (Nurse nurse : nurses) {
				System.out.println(nurse.toString());
			}
		} else {
			System.out.println("There no nurses assigned");
		}

		List<Technical> technicals = new ArrayList<Technical>();
		System.out.println("Assigned Technicals");

		// search in all Technicals and search for assigned patients
		for (Map.Entry<String, User> entry : userHashMap.entrySet()) {
			User user = entry.getValue();
			if (user.getType().equals(Type.TECHNICAL)) {
				if (((Technical) user).getPatients() != null) {
					technicals.add((Technical) user);
				}
			}
		}

		// print them
		if (technicals != null) {
			for (Technical technical : technicals) {
				System.out.println(technical.toString());
			}
		} else {
			System.out.println("There no technicals assigned");
		}
	}
}
