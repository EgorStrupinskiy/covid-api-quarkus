package com.innowise.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CovidDataByDate {
    private String country;
    private LocalDate date;
    private int cases;
}
