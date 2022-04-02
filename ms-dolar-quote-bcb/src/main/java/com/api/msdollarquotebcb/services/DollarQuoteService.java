package com.api.msdollarquotebcb.services;

import com.api.msdollarquotebcb.dtos.ResponseApiBcbDollarQuoteDto;

public interface DollarQuoteService {
    
    ResponseApiBcbDollarQuoteDto getDollarQuotes(String dateForm);

}
