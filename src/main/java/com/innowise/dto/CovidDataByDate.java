package com.innowise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CovidDataByDate {
    private String country;
    private LocalDate date;
    private int cases;
}
