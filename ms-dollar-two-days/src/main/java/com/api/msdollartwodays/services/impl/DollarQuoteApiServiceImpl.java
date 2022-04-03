package com.api.msdollartwodays.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.msdollartwodays.dtos.ResponseDollarQuoteApiDto;
import com.api.msdollartwodays.services.DollarQuoteApiService;

@Service
public class DollarQuoteApiServiceImpl implements DollarQuoteApiService {

    private static final String MS_DOLLAR_QUOTE_DAY_URL = "http://localhost:8081/ms-dollar-quote-api/dollar-quotes?dateForm={date}";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseDollarQuoteApiDto getDollarQuoteDay(String date) {
	HttpHeaders httpHeaders = new HttpHeaders();

	ResponseEntity<ResponseDollarQuoteApiDto> response = restTemplate.exchange(MS_DOLLAR_QUOTE_DAY_URL, HttpMethod.GET,
		new HttpEntity<>(httpHeaders), ResponseDollarQuoteApiDto.class, date);

	return response.getBody();
    }

}
