package com.innowise.controller;

import com.innowise.model.ApiRequest;
import io.quarkus.vertx.web.Body;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.LocalDate;
import java.util.List;


@Path("/statistics")
public class CountryStatController {
    @Inject
    @ConfigProperty(name = "base-url")
    String baseUrl;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public String list(@Body ApiRequest request) {
        List<String> countryList = request.getCountryList();
        LocalDate fromDate = request.getFromDate();
        LocalDate toDate = request.getToDate();
        return fromDate + " " + toDate;
    }
}
