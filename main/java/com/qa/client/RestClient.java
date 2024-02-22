package com.qa.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	
	public void get(String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget);
		int statusCode =closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code -------->"+statusCode);
	    String responseString =  EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
	    JSONObject responsejson = new JSONObject(responseString);
	    System.out.println("Response from API------>"+responsejson);
	}

}
