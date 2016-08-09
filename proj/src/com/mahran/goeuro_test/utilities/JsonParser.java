package com.mahran.goeuro_test.utilities;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import com.mahran.goeuro_test.models.*;

public class JsonParser {
	/////////////////////
	public static ArrayList<City> toCitiesList(String jsonString) throws JSONException {
		JSONArray anJsonArray = new JSONArray(jsonString);
		ArrayList<City> cities = new ArrayList<City>();
		for (int i = 0; i < anJsonArray.length(); i++)
			cities.add(toCity(new GoeuroJsonObject( anJsonArray.getJSONObject(i))));
		return cities;
	}

	public static City toCity(String jsonString) throws JSONException {
		
		return toCity(new GoeuroJsonObject(jsonString));
	}

	public static City toCity(GoeuroJsonObject jsonObj) throws JSONException {
		City city = new City();
		city.set_id(jsonObj.getInt(City.ID_KEY));
		city.setKey(jsonObj.getInt(City.KEY_KEY));
		city.setName(jsonObj.getString(City.NAME_KEY));
		city.setFullName(jsonObj.getString(City.FULLNAME_KEY));
		city.setIata_airport_code(jsonObj.getString(City.IATA_AIRPORT_CODE_KEY));
		city.setType(jsonObj.getString(City.TYPE_KEY));
		city.setCountry(jsonObj.getString(City.COUNTRY_KEY));
		city.setGeo_position(toGeoPosition(new GoeuroJsonObject(jsonObj.getJSONObject(City.GEO_POSITION_KEY))));
		city.setLocationId(jsonObj.getInt(City.LOCATION_ID_KEY));
		city.setInEurope(jsonObj.getBoolean(City.IN_EUROPE_KEY));
		city.setCountryId(jsonObj.getInt(City.COUNTRY_ID_KEY));
		city.setCountryCode(jsonObj.getString(City.COUNTRY_CODE_KEY));
		city.setCoreCountry(jsonObj.getBoolean(City.CORE_COUNTRY_KEY));
		city.setDistance(jsonObj.getDouble(City.DISTANCE_KEY));
		return city;
	}

	public static GeoPosition toGeoPosition(String jsonString) throws JSONException {
		return toGeoPosition(new GoeuroJsonObject(jsonString));
	}

	public static GeoPosition toGeoPosition(GoeuroJsonObject jsonObj) throws JSONException {
		GeoPosition geoPosition = new GeoPosition();
		geoPosition.setLatitude(jsonObj.getInt(GeoPosition.LATITUDE_KEY));
		geoPosition.setLongitude(jsonObj.getInt(GeoPosition.LONGITUDE_KEY));
		return geoPosition;
	}

}
