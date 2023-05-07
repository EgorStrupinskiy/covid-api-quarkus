package com.innowise.controller;

import com.innowise.model.ApiRequest;
import com.innowise.model.CountryStatistics;
import com.innowise.service.CountryStatService;
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
    CountryStatService service;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public List<CountryStatistics> list(@Body ApiRequest request) {
        return service.getMaxAndMinCasesByCountryAndDateRange(request);
    }
}
