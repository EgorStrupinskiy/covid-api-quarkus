package com.innowise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class ApiRequest {
    private List<String> countryList;
    private LocalDate fromDate;
    private LocalDate toDate;
}
