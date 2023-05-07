package com.innowise.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class CovidHTTPClient {

    public static HttpResponse execute(String url) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            String jsonResponse = EntityUtils.toString(response.getEntity());
            System.out.println(jsonResponse);
            httpGet.setHeader("Accept", "application/json");
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
