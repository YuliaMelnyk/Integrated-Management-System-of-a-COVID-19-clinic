package com.idbmobile.practica.utils;

import java.time.LocalDate;
import java.util.Comparator;

public class LocalDateTimeComparator implements Comparator<LocalDate> {
	@Override
	public int compare(LocalDate o1, LocalDate o2) {
		// Compare the date portion first. If equal, then look at time-of-day.
		int result = o1.compareTo(o2); // Consider only the date portion first.
		result = ((-1) * result); // Flip the positive/negative sign of the int, to get ascending order. Or more
									// simply: `= - result ;`.
		if (0 == result) // If dates are equal, look at the time-of-day.
		{
			System.out.println("reversing ");
			result = o1.compareTo(o2);
		}
		return result;
	}
}