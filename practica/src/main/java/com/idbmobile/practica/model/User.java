package com.idbmobile.practica.model;

import com.idbmobile.practica.enums.Type;

public abstract class User {

	private String dni;
	private String name;
	private String surname;

	private Boolean isAlta;

	private Boolean isBaja;

	private Type type;

	public User(String dni, String name, String surname, Type type) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.isAlta = true;
		this.isBaja = false;
		this.type = type;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Boolean getIsAlta() {
		return isAlta;
	}

	public Boolean getIsBaja() {
		return isBaja;
	}

	public void setIsAlta(Boolean isAlta) {
		this.isAlta = isAlta;
	}

	public void setIsBaja(Boolean isBaja) {
		this.isBaja = isBaja;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [dni=" + dni + ", name=" + name + ", surname=" + surname + ", isAlta=" + isAlta + ", isBaja="
				+ isBaja + ", type=" + type + "]";
	}

}
