package com.api.msdollarquotebcb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.api.msdollarquotebcb.dtos.DollarQuoteDto;
import com.api.msdollarquotebcb.dtos.ResponseApiBcbDollarQuoteDto;
import com.api.msdollarquotebcb.exception.NotBusinessDayException;
import com.api.msdollarquotebcb.services.BcbService;
import com.api.msdollarquotebcb.services.DollarQuoteService;
import com.api.msdollarquotebcb.utils.DateUtil;

@Service
public class DollarQuoteServiceImpl implements DollarQuoteService {

    @Autowired
    BcbService bcbService;

    @Override
    public DollarQuoteDto getDollarQuote(String dateForm) {

	DateUtil.isDateValid(dateForm);

	ResponseApiBcbDollarQuoteDto dollarQuote = bcbService.getCotacaoDolarDia(dateForm);

	if (CollectionUtils.isEmpty(dollarQuote.getQuote())) {
	    throw new NotBusinessDayException(dateForm);
	}

	return dollarQuote.getQuote().get(0);
    }

}
