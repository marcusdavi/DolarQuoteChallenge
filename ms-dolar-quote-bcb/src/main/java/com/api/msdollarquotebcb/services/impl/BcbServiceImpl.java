package com.api.msdollarquotebcb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.msdollarquotebcb.dtos.ResponseApiBcbDollarQuoteDto;
import com.api.msdollarquotebcb.services.BcbService;

@Service
public class BcbServiceImpl implements BcbService {

    private static final String FORMAT = "json";
    private static final String DOLLAR_QUOTE_DAY_URL = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='{dateForm}'&$top=100&$format={format}";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseApiBcbDollarQuoteDto getCotacaoDolarDia(String dateForm) {
	HttpHeaders httpHeaders = new HttpHeaders();

	ResponseEntity<ResponseApiBcbDollarQuoteDto> response = restTemplate.exchange(DOLLAR_QUOTE_DAY_URL, HttpMethod.GET,
		new HttpEntity<>(httpHeaders), ResponseApiBcbDollarQuoteDto.class, dateForm, FORMAT);

	return response.getBody();
    }

}
