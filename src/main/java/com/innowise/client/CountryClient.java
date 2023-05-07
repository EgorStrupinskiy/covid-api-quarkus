package com.innowise.client;

import com.innowise.dto.Country;
import com.innowise.util.CovidHTTPClient;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;

@Singleton
public class CountryClient {
    @Inject
    @ConfigProperty(name = "base-url")
    String baseUrl;

    public List<Country> getCountries() {
        String url = baseUrl + "/countries";
        CovidHTTPClient.execute(url);
        return null;
    }
}
