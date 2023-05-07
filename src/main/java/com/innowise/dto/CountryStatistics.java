package com.innowise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryStatistics {
    private String country;
    private int maxCases;
    private int minCases;
}
