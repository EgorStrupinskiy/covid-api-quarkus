package com.innowise.service;

import com.innowise.client.CountryStatClient;
import com.innowise.dto.ApiRequest;
import com.innowise.dto.CountryStatistics;
import com.innowise.dto.CovidDataByDate;
import com.innowise.dto.MinMaxCases;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Singleton
public class CountryStatService {
    @Inject
    CountryStatClient client;

    public List<CountryStatistics> getMaxAndMinCasesByCountryAndDateRange(ApiRequest request) {
        List<String> countries = request.getCountryList();
        LocalDate startDate = request.getFromDate();
        LocalDate endDate = request.getToDate();
        LocalDate previousDate = startDate.minusDays(1);
        var resultList = new ArrayList<CountryStatistics>();
        for (String country : countries) {
            var data = client.getCasesByDatePeriod(country, previousDate, endDate);
            var cases = getMaxAndMinCases(data);
            resultList.add(new CountryStatistics(country, cases.getMaxCases(), cases.getMinCases()));
        }
        return resultList;
    }


    public static MinMaxCases getMaxAndMinCases(List<CovidDataByDate> dataList) {
        List<Integer> casesDiff = IntStream.range(1, dataList.size())
                .map(i -> dataList.get(i).getCases() - dataList.get(i - 1).getCases())
                .boxed()
                .toList();

        int maxCases = Collections.max(casesDiff);
        int minCases = Collections.min(casesDiff);

        return new MinMaxCases(maxCases, minCases);
    }
}
