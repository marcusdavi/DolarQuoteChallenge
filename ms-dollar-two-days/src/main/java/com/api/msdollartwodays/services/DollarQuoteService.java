package com.api.msdollartwodays.services;

import com.api.msdollartwodays.dtos.ResponseDollarQuoteDto;

public interface DollarQuoteService {
    
    ResponseDollarQuoteDto getDollarQuotes(String dateForm);

}
