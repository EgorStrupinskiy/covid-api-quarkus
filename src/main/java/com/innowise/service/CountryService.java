package com.innowise.service;

import com.innowise.client.CountryClient;
import com.innowise.dto.Country;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class CountryService {
    @Inject
    CountryClient client;

    public List<Country> getCountriesList() {
        return client.getCountries();
    }
}
