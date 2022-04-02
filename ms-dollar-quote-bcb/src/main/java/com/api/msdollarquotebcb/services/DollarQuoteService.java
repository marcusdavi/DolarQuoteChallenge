package com.api.msdollarquotebcb.services;

import com.api.msdollarquotebcb.dtos.DollarQuoteDto;

public interface DollarQuoteService {
    
    DollarQuoteDto getDollarQuote(String dateForm);

}
