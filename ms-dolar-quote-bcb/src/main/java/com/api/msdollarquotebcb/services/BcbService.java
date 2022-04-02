package com.api.msdollarquotebcb.services;

import com.api.msdollarquotebcb.dtos.ResponseApiBcbDollarQuoteDto;

public interface BcbService {
    
    ResponseApiBcbDollarQuoteDto getCotacaoDolarDia(String dateForm);

}
