package com.api.msdollartwodays.services;

import com.api.msdollartwodays.dtos.ResponseDollarTwoDaysQuotesDto;

public interface DollarTwoDaysService {
    
    ResponseDollarTwoDaysQuotesDto getDollarQuotes(String dateForm);

}
