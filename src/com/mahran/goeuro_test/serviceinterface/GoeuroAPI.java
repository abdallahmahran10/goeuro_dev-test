package com.mahran.goeuro_test.serviceinterface;

import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import com.mahran.goeuro_test.models.City;
import com.mahran.goeuro_test.utilities.JsonParser;
import com.mahran.goeuro_test.utilities.Logger;

public class GoeuroAPI {
	private GoeuroRestServiceClient goeuroRestServiceClient;
	private final String SUGGEST_POSITION_PATH = "position/suggest/en/";
	private Logger logger;

	public GoeuroAPI() {
		goeuroRestServiceClient = new GoeuroRestServiceClient();
		logger = Logger.getInstant();
	}

	public ArrayList<City> suggestPosition(String cityName) {
		try {
			String respStr = goeuroRestServiceClient.GET(SUGGEST_POSITION_PATH + cityName);
			return JsonParser.toCitiesList(respStr);
		} catch (IOException e) {
			logger.ERROR(e);
		} catch (JSONException e) {
			logger.ERROR(e);
		}
		return null;
	}
}
