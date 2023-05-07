package com.innowise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Country {
    private String country;
    private String slug;
    private String iso2;
}
