package com.innowise.model;

import lombok.Data;

@Data
public class CountryStatistics {
    private String country;
    private int maxCases;
    private int minCases;

    public CountryStatistics(String country, int maxCases, int minCases) {
        this.country = country;
        this.maxCases = maxCases;
        this.minCases = minCases;
    }
}
