package com.api.msdollartwodays.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.msdollartwodays.dtos.ResponseDollarQuoteApiDto;
import com.api.msdollartwodays.dtos.ResponseDollarQuoteDto;
import com.api.msdollartwodays.services.DollarQuoteApiService;
import com.api.msdollartwodays.services.DollarQuoteService;
import com.api.msdollartwodays.utils.DateUtil;

@Service
public class DollarQuoteServiceImpl implements DollarQuoteService {

    @Autowired
    DollarQuoteApiService bcbService;

    @Override
    public ResponseDollarQuoteDto getDollarQuotes(String dateForm) {

	DateUtil.isDateValid(dateForm);

	ResponseDollarQuoteApiDto dollarQuoteDay = bcbService.getDollarQuoteDay(dateForm);

	// TODO Verificar se dia atual teve retorno
	// TODO Calcular Data do Dia Anterior
	ResponseDollarQuoteApiDto dollarQuoteDayBefore = bcbService.getDollarQuoteDay(dateForm);

	return new ResponseDollarQuoteDto(dollarQuoteDay.getCotacaoCompra(),
		DateUtil.StringToLocalDate(dollarQuoteDay.getDataHoraCotacao()),
		dollarQuoteDayBefore.getCotacaoCompra(),
		DateUtil.StringToLocalDate(dollarQuoteDayBefore.getDataHoraCotacao()));

    }

}
