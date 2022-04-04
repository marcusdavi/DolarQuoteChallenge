package com.api.msdollartwodays.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.api.msdollartwodays.dtos.ResponseDollarQuoteApiDto;
import com.api.msdollartwodays.dtos.ResponseDollarTwoDaysQuotesDto;
import com.api.msdollartwodays.services.DollarQuoteApiService;
import com.api.msdollartwodays.services.DollarTwoDaysService;
import com.api.msdollartwodays.utils.DateUtil;

@Service
public class DollarTwoDaysServiceImpl implements DollarTwoDaysService {

    @Autowired
    DollarQuoteApiService bcbService;

    @Override
    public ResponseDollarTwoDaysQuotesDto getDollarQuotes(String dateForm) {

	DateUtil.isDateValid(dateForm);

	ResponseDollarQuoteApiDto dollarQuoteDay = bcbService.getDollarQuoteDay(dateForm);

	ResponseDollarQuoteApiDto dollarQuoteDayBefore = getDollarQuoteDayBefore(dateForm);

	return new ResponseDollarTwoDaysQuotesDto(dollarQuoteDay.getCotacaoCompra(),
		DateUtil.formatDateBR(dollarQuoteDay.getDataHoraCotacao()), dollarQuoteDayBefore.getCotacaoCompra(),
		DateUtil.formatDateBR(dollarQuoteDayBefore.getDataHoraCotacao()));

    }

    private ResponseDollarQuoteApiDto getDollarQuoteDayBefore(String date) {
	boolean finded = false;
	String dateBefore = DateUtil.backToBusinessDayWithString(date);

	ResponseDollarQuoteApiDto dollarQuoteDay = new ResponseDollarQuoteApiDto();

	while (!finded) {
	    try {
		dollarQuoteDay = bcbService.getDollarQuoteDay(dateBefore);
		finded = true;
	    } catch (HttpClientErrorException ex) {
		dateBefore = DateUtil.backToBusinessDayWithString(dateBefore);
	    }
	}

	return dollarQuoteDay;
    }

}
