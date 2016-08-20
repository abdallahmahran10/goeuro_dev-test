package com.mahran.goeuro_test.test;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import org.junit.Test;

import com.mahran.goeuro_test.models.City;
import com.mahran.goeuro_test.utilities.CSVUtilities;

public class CSVUtilitiesTest {

	@Test(expected = InvalidParameterException.class)
	public void writeToCSV_FailureExpected() {
		CSVUtilities.writeToCSV("", new ArrayList<City>());
	}

}
