package com.api.msdollartwodays.services;

import com.api.msdollartwodays.dtos.ResponseDollarQuoteApiDto;

public interface DollarQuoteApiService {
    
    ResponseDollarQuoteApiDto getDollarQuoteDay(String date);

}
