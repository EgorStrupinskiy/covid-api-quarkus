package com.innowise.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.innowise.dto.Country;
import com.innowise.dto.CovidDataByDate;
import com.innowise.util.CovidHTTPClient;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.apache.http.util.EntityUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Singleton
public class CountryClient {
    @Inject
    @ConfigProperty(name = "base-url")
    String baseUrl;

    public List<Country> getCountries() {
        String url = baseUrl + "/countries";
        var response = CovidHTTPClient.execute(url);
        List<Country> countriesList = new ArrayList<>();
        try {
            var jsonResponse = EntityUtils.toString(Objects.requireNonNull(response).getEntity());
            var objectMapper = new ObjectMapper();
            countriesList = objectMapper.readValue(jsonResponse, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countriesList;
    }
}
