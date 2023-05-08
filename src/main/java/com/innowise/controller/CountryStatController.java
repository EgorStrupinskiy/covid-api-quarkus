package com.innowise.controller;

import com.innowise.dto.ApiRequest;
import com.innowise.dto.CountryStatistics;
import com.innowise.service.CountryStatService;
import io.quarkus.vertx.web.Body;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("/statistics")
public class CountryStatController {
    @Inject
    CountryStatService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public List<CountryStatistics> list(@Body ApiRequest request) {
        return service.getMaxAndMinCasesByCountryAndDateRange(request);
    }
}
