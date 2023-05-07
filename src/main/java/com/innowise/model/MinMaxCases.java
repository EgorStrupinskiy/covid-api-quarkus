package com.innowise.model;

import lombok.Data;

@Data
public class MinMaxCases {
    private int minCases;
    private int maxCases;

    public MinMaxCases(int minCases, int maxCases) {
        this.minCases = minCases;
        this.maxCases = maxCases;
    }
}
