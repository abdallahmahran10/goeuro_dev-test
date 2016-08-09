package com.mahran.goeuro_test.serviceinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

public class GoeuroRestServiceClient {
	private static final String BASE_URL = "http://api.goeuro.com/api/v2/";
	static HttpClient GoeuroClient;
	
	public GoeuroRestServiceClient()
	{
		GoeuroClient = HttpClientBuilder.create().build();
	}

	/**
	 * Execute GET request 
	 * @param apiMethodPath: method path
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public String GET(String apiMethodPath) throws ClientProtocolException, IOException {
			String url = BASE_URL + apiMethodPath;
			HttpGet request = new HttpGet(url);
			HttpResponse response = GoeuroClient.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "", responseStr= "";
			while ((line = rd.readLine()) != null) {
				responseStr+=line;
			}
			return responseStr;
	}
	
	/**
	 * Execute POST request 
	 * @param apiMethodPath: method path
	 * @param requestInput: request params
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String POST(String apiMethodPath, HttpEntity requestInput) throws ClientProtocolException, IOException {
			String url = BASE_URL + apiMethodPath;
			HttpPost postRequest = new HttpPost(url);
			postRequest.setEntity(requestInput);
			HttpResponse response = GoeuroClient.execute(postRequest);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "", responseStr= "";
			while ((line = rd.readLine()) != null) {
				responseStr+=line;
			}
			return responseStr;
	}

}
