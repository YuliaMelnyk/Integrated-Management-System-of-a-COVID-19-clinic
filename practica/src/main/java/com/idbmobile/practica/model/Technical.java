package com.idbmobile.practica.model;

import com.idbmobile.practica.enums.Type;

public class Technical extends Employee {
	public Technical(int id, String name, String surname, String password, Type type) {
		super(id, name, surname, password, type);
		type = Type.TECHNICAL;
	}

}
