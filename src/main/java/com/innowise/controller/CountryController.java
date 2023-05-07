package com.innowise.controller;

import com.innowise.dto.Country;
import com.innowise.service.CountryService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("/countries")
public class CountryController {
    @Inject
    CountryService service;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Country> list() {
        return service.getCountriesList();
    }
}
