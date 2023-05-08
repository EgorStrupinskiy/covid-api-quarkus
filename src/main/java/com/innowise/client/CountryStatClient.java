package com.innowise.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.innowise.dto.CovidDataByDate;
import com.innowise.util.CovidHTTPClient;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.apache.http.util.EntityUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Singleton
public class CountryStatClient {
    @Inject
    @ConfigProperty(name = "base-url")
    String baseUrl;

    public List<CovidDataByDate> getCasesByDatePeriod(String country, LocalDate startDate, LocalDate endDate) {
        var url = baseUrl + "/country/" + country + "/status/confirmed/live?from=" + startDate + "&to=" + endDate;
        var response = CovidHTTPClient.execute(url);
        List<CovidDataByDate> dataByDateList = new ArrayList<>();
        try {
            var jsonResponse = EntityUtils.toString(Objects.requireNonNull(response).getEntity());
            var objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            dataByDateList = objectMapper.readValue(jsonResponse, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataByDateList;
    }
}

