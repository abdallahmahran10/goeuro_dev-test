package com.mahran.goeuro_test.utilities;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import com.mahran.goeuro_test.models.City;

/*	
 * this class handle the dumping of Goeuro models class to csv file
 * @author Abdallah
 */
public class CSVUtilities {
	/**
	 * dump cities list to a csv file with UTF_8 encoding
	 * 
	 * @param csvFilePath
	 *            path of the csv file
	 * @param cities
	 *            list to be dumped
	 * @return true if succeeded, false otherwise
	 */
	public static boolean writeToCSV(String csvFilePath, ArrayList<City> cities) {
		if(csvFilePath.isEmpty())
			throw new InvalidParameterException("CSV filename can not be empty");
		Logger.getInstant().INFO("Saving records data in CSV file.");
		Writer writer;
		try {
			writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(csvFilePath), StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < cities.size(); i++) {
				sb.append(String.valueOf(cities.get(i).get_id()));
				sb.append(',');
				sb.append(cities.get(i).getName());
				sb.append(',');
				sb.append(cities.get(i).getType());
				sb.append(',');
				sb.append(String.valueOf(cities.get(i).getGeo_position().getLatitude()));
				sb.append(',');
				sb.append(String.valueOf(cities.get(i).getGeo_position().getLongitude()));
				sb.append('\n');
			}
			String data = sb.toString();
			Logger.getInstant().INFO("Data to dump: \n" + data);
			writer.write(data);
			writer.close();
			return true;
		} catch (FileNotFoundException e) {
			Logger.getInstant().ERROR(e);
		} catch (UnsupportedEncodingException e) {
			Logger.getInstant().ERROR(e);
		} catch (IOException e) {
			Logger.getInstant().ERROR(e);
		}
		return false;
	}
}
