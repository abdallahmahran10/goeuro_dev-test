package com.mahran.goeuro_test;

import java.util.ArrayList;

import com.mahran.goeuro_test.models.City;
import com.mahran.goeuro_test.serviceinterface.GoeuroAPI;

public class Main {

	public static void main(String[] args) {
		String cityName="";
		if(args.length<1 || (cityName = args[0]).isEmpty())
		{
			System.out.println("Kindly enter the city name as a parameter\n"+
					"Example:\n"+
					"java -jar goeuro_dev-test.jar \"CITY_NAME\"");
		}
		//
		GoeuroAPI goeuroAPI = new GoeuroAPI();
		ArrayList<City> cities = goeuroAPI.suggestPosition(cityName);
	}
}
