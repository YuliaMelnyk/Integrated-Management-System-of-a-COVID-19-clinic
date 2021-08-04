package com.idbmobile.practica.model;

import java.time.LocalDate;

import com.idbmobile.practica.enums.TestType;

public class SerologicalAnalysis extends Test {

	// 6 month

	private int level;

	public SerologicalAnalysis(LocalDate testDate, TestType testType) {
		super(testDate, testType);
		testType = TestType.SEROLOGICAL;
	}

	public int getLevel() {
		return level;
	}

	// set level of analysis from 0 to 10
	public void setLevel(int level) {
		if (level >= 0 && level <= 10) {
			this.level = level;
		} else {
			System.out.println("The value of serological analysis must be from 0 to 10");

		}
	}
}
