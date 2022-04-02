package com.api.msdollarquotebcb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.api.msdollarquotebcb.dtos.ResponseApiBcbDollarQuoteDto;
import com.api.msdollarquotebcb.exception.NotBusinessDayException;
import com.api.msdollarquotebcb.services.BcbService;
import com.api.msdollarquotebcb.services.DateUtil;
import com.api.msdollarquotebcb.services.DollarQuoteService;

@Service
public class DollarQuoteServiceImpl implements DollarQuoteService {

    @Autowired
    BcbService bcbService;

    @Override
    public ResponseApiBcbDollarQuoteDto getDollarQuotes(String dateForm) {

	DateUtil.isDateValid(dateForm);

	ResponseApiBcbDollarQuoteDto dollarQuote = bcbService.getCotacaoDolarDia(dateForm);

	if (CollectionUtils.isEmpty(dollarQuote.getQuote())) {
	    throw new NotBusinessDayException(dateForm);
	}

	return dollarQuote;
    }

}
