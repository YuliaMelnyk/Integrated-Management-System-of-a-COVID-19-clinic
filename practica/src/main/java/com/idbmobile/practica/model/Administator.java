package com.idbmobile.practica.model;

import com.idbmobile.practica.enums.Type;

public class Administator extends Employee {

	private Type type;

	public Administator(String dni, String name, String surname, String password, Type type) {
		super(dni, name, surname, password, type);
		this.type = Type.ADMINISTRATOR;
	}

	@Override
	public String toString() {
		return "Administator [ Dni=" + getDni() + ", Name=" + getName() + ", Surname=" + getSurname() + "type=" + type
				+ ", Limit=" + getLimit() + ", IsAlta=" + getIsAlta() + ", IsBaja=" + getIsBaja() + ", Type="
				+ getType() + "]";
	}

}
