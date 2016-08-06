package com.mahran.goeuro_test.utilities;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mahran.goeuro_test.models.*;

public class JsonParser {

	public static GeoPosition toGeoPosition(String jsonString) throws JSONException
	{
		return toGeoPosition(new JSONObject(jsonString));
	}

	public static GeoPosition toGeoPosition(JSONObject jsonObj)
	{
		return null;
	}

	public static ArrayList<City> toCitiesList(String jsonString) throws JSONException
	{
		JSONArray anJsonArray= new JSONArray(jsonString);
		ArrayList<City> cities = new ArrayList<City>();
		for(int i=0; i < anJsonArray.length(); i++)
			cities.add(toCity(anJsonArray.getJSONObject(i)));
		return cities ;
	}

	private static City toCity(JSONObject jsonObject) throws JSONException {
		/*
		 * 
	public static String ID_KEY = "_id";
	public static String KEY_KEY = "key";
	public static String NAME_KEY = "name";
	public static String FULLNAME_KEY = "fullName";
	public static String IATA_AIRPORT_CODE_KEY = "iata_airport_code";
	public static String TYPE_KEY = "type";
	public static String COUNTRY_KEY = "country";
	public static String GEO_POSITION_KEY = "geo_position";
	public static String LOCATION_ID_KEY = "locationId";
	public static String IN_EUROPE_KEY = "inEurope";
	public static String COUNTRY_ID_KEY = "countryId";
	public static String COUNTRY_CODE_KEY = "countryCode";
	public static String CORE_COUNTRY_KEY = "coreCountry";
	public static String DISTANCE_KEY = "distance";
	*/
		City city = new City();
		city.set_id(jsonObject.getInt(City.ID_KEY));
		city.setKey(jsonObject.getString(City.KEY_KEY));
		city.setName(jsonObject.getString(City.NAME_KEY));
		city.setFullName(jsonObject.getString(City.FULLNAME_KEY));
		city.setIata_airport_code(jsonObject.getString(City.IATA_AIRPORT_CODE_KEY));
		city.setType(jsonObject.getString(City.TYPE_KEY));
		city.setCountry(jsonObject.getString(City.COUNTRY_KEY));
		city.setGeo_position(toGeoPosition(jsonObject.getJSONObject(City.GEO_POSITION_KEY)));
		city.setLocationId( jsonObject.getInt(City.LOCATION_ID_KEY));
		city.setInEurope(jsonObject.getBoolean(City.IN_EUROPE_KEY));
		city.setCountryId(jsonObject.getInt(City.COUNTRY_ID_KEY));
		city.setCountryCode(jsonObject.getString(City.COUNTRY_CODE_KEY));
		city.setCoreCountry(jsonObject.getBoolean(City.CORE_COUNTRY_KEY));
		city.setDistance( jsonObject.getDouble(City.DISTANCE_KEY));
		return city;
	}

	
}
