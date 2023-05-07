package com.innowise.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ApiRequest {
    private List<String> countryList;
    private LocalDate fromDate;
    private LocalDate toDate;
}
