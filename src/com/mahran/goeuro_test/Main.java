package com.mahran.goeuro_test;

import java.util.ArrayList;

import com.mahran.goeuro_test.models.City;
import com.mahran.goeuro_test.serviceinterface.GoeuroAPI;
import com.mahran.goeuro_test.utilities.Logger;

public class Main {

	public static void main(String[] args) {
		String cityName = "";
		if (args.length < 1 || (cityName = args[0]).isEmpty()) {
			System.out.println("Kindly enter the city name as a parameter\n" + "Example:\n"
					+ "java -jar goeuro_dev-test.jar \"CITY_NAME\"");
		}
		//
		try {
			GoeuroAPI goeuroAPI = new GoeuroAPI();
			ArrayList<City> cities = goeuroAPI.suggestPosition(cityName);
			Logger.getInstant().INFO(Integer.toString(cities.size()));
		} catch (Exception e)
		{
			Logger.getInstant().ERROR(e);
		}
	}
}
