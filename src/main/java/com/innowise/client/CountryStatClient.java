package com.innowise.client;

import com.innowise.dto.CovidDataByDate;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Singleton
public class CountryStatClient {
    @Inject
    @ConfigProperty(name = "base-url")
    String baseUrl;

    public List<CovidDataByDate> getCasesByDatePeriod(String country, LocalDate startDate, LocalDate endDate) {
        String url = baseUrl + "/" + country + "/status/confirmed/live?from=" + startDate + "&to=" + endDate;
        System.out.println(url);
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "application/json");

        try {
            HttpResponse response = httpClient.execute(httpGet);
            String jsonResponse = EntityUtils.toString(response.getEntity());
            System.out.println(jsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
