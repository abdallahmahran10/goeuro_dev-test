package com.mahran.goeuro_test.utilities;

import org.json.JSONException;
import org.json.JSONObject;

/////////////// Override JsonObject to handle the null values sent in the JSON response

public class GoeuroJsonObject extends JSONObject {

	Logger logger = Logger.getInstant();
	public GoeuroJsonObject()
	{
		super();
	}
	public GoeuroJsonObject(JSONObject obj)
	{
		super(obj, JSONObject.getNames(obj));
	}
	public GoeuroJsonObject(String jsonString) throws JSONException
	{
		super(jsonString);
	}

	@Override
	public int getInt(String key) {
		try {
			return super.getInt(key);
		} catch (JSONException e) {
			logger.WARNING("JSONObject["+ key+"] is null or not find in the json string");
			return 0;
		}
	}

	//
	@Override
	public String getString(String key) {
		try {
			return super.getString(key);
		} catch (JSONException e) {
			logger.WARNING("JSONObject["+ key+"] is null or not find in the json string");
			return "";
		}
	}

	//
	@Override
	public boolean getBoolean(String key) {
		try {
			return super.getBoolean(key);
		} catch (JSONException e) {
			logger.WARNING("JSONObject["+ key+"] is null or not find in the json string");
			return false;
		}
	}

	//
	@Override
	public double getDouble(String key) {
		try {
			return super.getDouble(key);
		} catch (JSONException e) {
			logger.WARNING("JSONObject["+ key+"] is null or not find in the json string");
			return 0;
		}
	}
	//
	@Override
	public JSONObject getJSONObject(String key) throws JSONException {
		try {
			return super.getJSONObject(key);
		} catch (JSONException e) {
			logger.WARNING("JSONObject["+ key+"] is null or not find in the json string");
			return new GoeuroJsonObject();
		}
	}
}
