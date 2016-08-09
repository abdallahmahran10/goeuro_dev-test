package com.mahran.goeuro_test.serviceinterface;

import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import com.mahran.goeuro_test.models.City;
import com.mahran.goeuro_test.utilities.JsonParser;
import com.mahran.goeuro_test.utilities.Logger;

/*
 * this class contains methods that 
 * maps all the Goeuro API services
 * for each service path there is a method 
 * that call the GoeuroRestServiceClient with 
 * the corresponding path
 * @author Abdallah
 */
public class GoeuroAPI {
	private GoeuroRestServiceClient goeuroRestServiceClient;
	private final String SUGGEST_POSITION_PATH = "position/suggest/en/";
	private Logger logger;

	/*
	 * defaul ctor initializes GoeuroRestServiceClient to consume it later with
	 * the proper service path it also initializes the logger to be used in
	 * logging
	 */
	public GoeuroAPI() {
		goeuroRestServiceClient = new GoeuroRestServiceClient();
		logger = Logger.getInstant();
	}

	/**
	 * consume the REST client with Suggest Position API method path
	 * 
	 * @param cityName
	 *            the city name to be send as a param to the api
	 * @return
	 */
	public ArrayList<City> suggestPosition(String cityName) {
		try {
			String respStr = goeuroRestServiceClient.GET(SUGGEST_POSITION_PATH + cityName);
			Logger.getInstant().INFO("API Response: " + respStr);
			return JsonParser.toCitiesList(respStr);
		} catch (IOException e) {
			logger.ERROR(e);
		} catch (JSONException e) {
			logger.ERROR("Could not parse API response: " + e.getMessage());
		}
		return null;
	}
}
