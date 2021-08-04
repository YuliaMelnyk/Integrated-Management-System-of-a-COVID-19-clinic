package com.idbmobile.practica.model;

import java.time.LocalDate;

import com.idbmobile.practica.enums.TestType;

public class AntigenTest extends Test {

	private Result result;

	public AntigenTest(LocalDate testDate, TestType testType) {
		super(testDate, testType);
		testType = TestType.ANTIGEN;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
