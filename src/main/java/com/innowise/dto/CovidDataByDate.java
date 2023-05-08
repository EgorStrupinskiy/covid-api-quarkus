package com.innowise.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidDataByDate {

    @JsonProperty("Country")
    private String country;

    @JsonProperty("Date")
    private LocalDate date;

    @JsonProperty("Cases")
    private int cases;
}
