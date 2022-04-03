package com.api.msdollartwodays.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.msdollartwodays.dtos.ResponseDollarQuoteApiDto;
import com.api.msdollartwodays.services.DollarQuoteApiService;
import com.api.msdollartwodays.utils.DateUtil;

@Service
public class DollarQuoteApiServiceImpl implements DollarQuoteApiService {

    private static final String MS_DOLLAR_QUOTE_DAY_URL = "http://localhost:8082/ms-dollar-quote-api/dollar-quotes?dateForm={date}";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseDollarQuoteApiDto getDollarQuoteDay(String date) {
	
	String paramDate = DateUtil.formatDateToParamAPI(date);

	ResponseDollarQuoteApiDto response = restTemplate.getForObject(MS_DOLLAR_QUOTE_DAY_URL, ResponseDollarQuoteApiDto.class, paramDate);

	return response;
    }

}
