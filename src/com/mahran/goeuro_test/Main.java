package com.mahran.goeuro_test;

import java.util.ArrayList;

import com.mahran.goeuro_test.models.City;
import com.mahran.goeuro_test.serviceinterface.GoeuroAPI;
import com.mahran.goeuro_test.utilities.CSVUtilities;
import com.mahran.goeuro_test.utilities.Logger;

public class Main {
	static String csvFilePath = "records.csv";
	public static void main(String[] args) {
		String cityName = "";
		if (args.length < 1 || (cityName = args[0]).isEmpty()) {
			System.out.println("Kindly enter the city name as a parameter\n" + "Example:\n"
					+ "java -jar goeuro_dev-test.jar \"CITY_NAME\"");
		}
		//
		try 
		{
			Logger.getInstant().INFO("Calling Goeuro API with city name = "+ cityName);
			GoeuroAPI goeuroAPI = new GoeuroAPI();
			ArrayList<City> records = goeuroAPI.suggestPosition(cityName);
			if(records == null || records.size() < 1)
			{
				Logger.getInstant().INFO("API returned with 0 records!");
			}
			else 
			{
				Logger.getInstant().INFO("API returned successfully with "+Integer.toString(records.size())+" records.");
				 if (!CSVUtilities.writeToCSV(csvFilePath, records))
					 Logger.getInstant().ERROR("Could NOT save records to File");
			}
			Logger.getInstant().INFO("Done!");
		} catch (Exception e)
		{
			Logger.getInstant().ERROR(e);
		}
	}
}
