package com.idbmobile.practica.model;

import com.idbmobile.practica.enums.Type;

public class Administator extends Employee {

	private Type type;

	public Administator(int id, String name, String surname, String password, Type type) {
		super(id, name, surname, password, type);
		this.type = Type.ADMINISTRATOR;

	}

}
