package com.idbmobile.practica.model;

import java.time.LocalDate;

import com.idbmobile.practica.enums.Result;
import com.idbmobile.practica.enums.TestType;

public class PCRTest extends Test {

	// 15 days

	private Result result;

	public PCRTest(LocalDate testDate, TestType testType) {
		super(testDate, testType);
		testType = TestType.PCR;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
