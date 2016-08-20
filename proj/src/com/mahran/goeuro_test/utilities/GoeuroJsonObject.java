package com.mahran.goeuro_test.utilities;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Override JsonObject to handle the null values sent in the JSON response
 *
 * @author Abdallah
 *
 */
public class GoeuroJsonObject extends JSONObject {

	Logger logger = Logger.getInstant();

	/**
	 * defail ctor
	 */
	public GoeuroJsonObject() {
		super();
	}

	/**
	 * copy ctor, copy all values from the input JSONObject
	 * 
	 * @param obj
	 *            object to be copied
	 */
	public GoeuroJsonObject(JSONObject obj) {
		super(obj, JSONObject.getNames(obj));
	}

	/**
	 * create JSONObject from the json string
	 * 
	 * @param jsonString
	 *            json string
	 * @throws JSONException
	 *             fails to parse to a JSONObject
	 */
	public GoeuroJsonObject(String jsonString) throws JSONException {
		super(jsonString);
	}

	/**
	 * get int value by key, return 0 if fails
	 */
	@Override
	public int getInt(String key) {
		try {
			return super.getInt(key);
		} catch (JSONException e) {
			logger.WARNING("JSONObject[" + key + "] is null or not find in the json string");
			return 0;
		}
	}

	/**
	 * get string value by key, return empty string if fails
	 */
	@Override
	public String getString(String key) {
		try {
			return super.getString(key);
		} catch (JSONException e) {
			logger.WARNING("JSONObject[" + key + "] is null or not find in the json string");
			return "";
		}
	}

	/**
	 * get boolean value by key, return false if fails
	 */
	@Override
	public boolean getBoolean(String key) {
		try {
			return super.getBoolean(key);
		} catch (JSONException e) {
			logger.WARNING("JSONObject[" + key + "] is null or not find in the json string");
			return false;
		}
	}

	/**
	 * get double value by key, return 0 if fails
	 */
	@Override
	public double getDouble(String key) {
		try {
			return super.getDouble(key);
		} catch (JSONException e) {
			logger.WARNING("JSONObject[" + key + "] is null or not find in the json string");
			return 0;
		}
	}

	/**
	 * get json object value by key, return empty object if fails
	 */
	@Override
	public JSONObject getJSONObject(String key) throws JSONException {
		try {
			return super.getJSONObject(key);
		} catch (JSONException e) {
			logger.WARNING("JSONObject[" + key + "] is null or not find in the json string");
			return new GoeuroJsonObject();
		}
	}
}
