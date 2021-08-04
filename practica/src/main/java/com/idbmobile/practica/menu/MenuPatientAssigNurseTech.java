package com.idbmobile.practica.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.idbmobile.practica.enums.Type;
import com.idbmobile.practica.main.Main;
import com.idbmobile.practica.model.Nurse;
import com.idbmobile.practica.model.User;

public class MenuPatientAssigNurseTech {

	public static void showAllAssigned() {

		List<Nurse> nurses = new ArrayList<Nurse>();
		System.out.println("Assigned Nurses");

		HashMap<Integer, User> hashMapNurses = Main.createNurses();

		// search in all users type Nurse and search for assigned patients
		for (Map.Entry<Integer, User> entry : Main.userHashMap.entrySet()) {

			User user = entry.getValue();

			if (user.getType().equals(Type.NURSE)) {
				Nurse nurse = (Nurse) user;
				if (nurse.getPatient() != null) {
					nurses.add(nurse);
				}

			}
		}

		for (Nurse nurse : nurses) {
			System.out.println(nurse.toString());
		}

	}

}
