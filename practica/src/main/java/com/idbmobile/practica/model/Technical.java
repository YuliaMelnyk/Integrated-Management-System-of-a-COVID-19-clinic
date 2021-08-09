package com.idbmobile.practica.model;

import com.idbmobile.practica.enums.Type;

public class Technical extends Employee {
	public Technical(String dni, String name, String surname, String password, Type type) {
		super(dni, name, surname, password, type);
		type = Type.TECHNICAL;
	}

	@Override
	public String toString() {
		return "Technical [ Dni()=" + getDni() + ", Name()=" + getName() + ", Surname=" + getSurname() + ", Patients="
				+ getPatients() + ", Limit=" + getLimit() + ", IsAlta()=" + getIsAlta() + ", IsBaja()=" + getIsBaja()
				+ ", Type()=" + getType() + "]";
	}

}
