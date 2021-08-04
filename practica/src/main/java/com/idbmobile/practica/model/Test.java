package com.idbmobile.practica.model;

import java.time.LocalDate;

import com.idbmobile.practica.enums.TestType;

public abstract class Test {

	private LocalDate testDate;

	private TestType testType;

	public Test(LocalDate testDate, TestType testType) {
		super();
		this.testDate = testDate;
		this.testType = testType;
	}

	public LocalDate getTestDate() {
		return testDate;
	}

	public void setTestDate(LocalDate testDate) {
		this.testDate = testDate;
	}

	public TestType getTestType() {
		return testType;
	}

	public void setTestType(TestType testType) {
		this.testType = testType;
	}

}
