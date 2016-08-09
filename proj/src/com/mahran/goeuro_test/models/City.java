package com.mahran.goeuro_test.models;

import java.util.HashMap;

/*
 * this class is the model data for a city JSON object
 * @author Abdallah 
 */
public class City {

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
	public static String NAMES_KEY = "names";
	public static String ALTERNATIVE_NAMES_KEY = "alternativeNames";
	//
	private int _id;
	private int key;
	private String name;
	private String fullName;
	private String iata_airport_code;
	private String type;
	private String country;
	private GeoPosition geo_position;
	private int locationId;
	private boolean inEurope;
	private int countryId;
	private String countryCode;
	private boolean coreCountry;
	private double distance;
	private HashMap<String, String> names;
	private HashMap<String, String> alternativeNames;

	//
	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIata_airport_code() {
		return iata_airport_code;
	}

	public void setIata_airport_code(String iata_airport_code) {
		this.iata_airport_code = iata_airport_code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public GeoPosition getGeo_position() {
		return geo_position;
	}

	public void setGeo_position(GeoPosition geo_position) {
		this.geo_position = geo_position;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public boolean isInEurope() {
		return inEurope;
	}

	public void setInEurope(boolean inEurope) {
		this.inEurope = inEurope;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public boolean isCoreCountry() {
		return coreCountry;
	}

	public void setCoreCountry(boolean coreCountry) {
		this.coreCountry = coreCountry;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public HashMap<String, String> getNames() {
		return names;
	}

	public void setNames(HashMap<String, String> names) {
		this.names = names;
	}

	public HashMap<String, String> getAlternativeNames() {
		return alternativeNames;
	}

	public void setAlternativeNames(HashMap<String, String> alternativeNames) {
		this.alternativeNames = alternativeNames;
	}

}
